package edu.fiuba.algo3.engine.score;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.model.MatchResult;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.model.Score;

public class ScoreCalculator {
	
	private ScoreCalculator() {}
	
	public static void calculateAndAssignPoints(Question question, MatchResult ... results) {
		List<MatchResult> resultList = Arrays.asList(results);
		calculateQuestionScore(resultList, question);
		calculateAugmenters(resultList);
		sumFinalScore(resultList);				
	}
	
	private static void calculateQuestionScore(List<MatchResult> resultList, Question question) {
		resultList.stream().forEach(result -> {
			result.setMatchScore(new Score(question.calculatePoints(result.getSelectedOptions())));
		});
	}
	
	private static void calculateAugmenters(List<MatchResult> resultList) {
		resultList.stream().forEach(resultOne -> {
			resultList.stream().forEach(resultTwo -> {
				if(!resultOne.equals(resultTwo)) {		
					checkAugmenters(resultOne, resultOne.getMatchScore(), resultTwo.getMatchScore());					
				}
			});
		});
	}
	
	private static void sumFinalScore(List<MatchResult> resultList) {
		resultList.stream().forEach(result -> {
			result.sumMatchScoreToPlayer();
		});
	}
	
	private static void checkAugmenters(MatchResult playerResult, Score playerScore, Score opponentScore) {
		if(playerResult.getSelectedAugmenter() != null) {
			playerResult.calculateForScoreAugmenter(playerScore, opponentScore);
		}
	}

}
