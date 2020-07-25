package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.model.MatchResult;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.model.Score;

public class ScoreCalculator {
	
	private ScoreCalculator() {}
	
	public static void calculateAndAssignPoints(MatchResult playerOneResult, MatchResult playerTwoResult, Question question) {
		Score playerOneQuestionScore = new Score(question.calculatePoints(playerOneResult.getSelectedOptions()));
		Score playerTwoQuestionScore = new Score(question.calculatePoints(playerTwoResult.getSelectedOptions()));
		
		checkAugmenters(playerOneResult, playerOneQuestionScore, playerTwoQuestionScore);
		checkAugmenters(playerTwoResult, playerTwoQuestionScore, playerOneQuestionScore);
		
		playerOneResult.getPlayer().getScore().sumScore(playerOneQuestionScore);
		playerTwoResult.getPlayer().getScore().sumScore(playerTwoQuestionScore);
	}
	
	private static void checkAugmenters(MatchResult playerResult, Score playerScore, Score opponentScore) {
		if(playerResult.getSelectedAugmenter() != null) {
			playerResult.getSelectedAugmenter().getInstance().applyScoreAugmenter(playerScore, opponentScore);
			playerResult.getPlayer().substractUseOfAugmenter(playerResult.getSelectedAugmenter());
		}
	}

}
