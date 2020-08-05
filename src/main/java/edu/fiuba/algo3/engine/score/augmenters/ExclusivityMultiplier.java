package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Score;

public class ExclusivityMultiplier extends ScoreAugmenter {

	@Override
	public void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore) {		
		if(questionScore.getQuestionScore() == opponentQuestionScore.getQuestionScore()){
			questionScore.setQuestionScore(0);
			opponentQuestionScore.setQuestionScore(0);
		}else if(questionScore.getQuestionScore() > 0) {
			questionScore.setQuestionScore(questionScore.getQuestionScore() * 2);
		}else {
			opponentQuestionScore.setQuestionScore(opponentQuestionScore.getQuestionScore() * 2);
		}
	}

	@Override
	public AugmenterType getAugmenterType() {
		return AugmenterType.EXCLUSIVITY;
	}

}
