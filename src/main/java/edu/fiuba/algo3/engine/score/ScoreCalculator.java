package edu.fiuba.algo3.engine.score;

import java.util.List;

import edu.fiuba.algo3.model.MatchResult;

public class ScoreCalculator {
	
	private ScoreCalculator() {}
	
	public static void calculateAndAssignPoints(List<MatchResult> matchResults) {
		calculateAugmenters(matchResults);
		sumFinalScore(matchResults);				
	}
	
	private static void calculateAugmenters(List<MatchResult> resultList) {
		resultList.stream().forEach(resultOne -> {
			resultList.stream().forEach(resultTwo -> {
				if(!resultOne.equals(resultTwo)) {	
					resultOne.applyScoreAugmenter(resultTwo.getMatchScore());				
				}
			});
		});
	}
	
	private static void sumFinalScore(List<MatchResult> resultList) {
		resultList.stream().forEach(
			MatchResult::sumMatchScoreToPlayer
		);
	}
	

}
