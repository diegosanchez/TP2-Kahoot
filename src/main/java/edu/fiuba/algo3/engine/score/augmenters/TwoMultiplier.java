package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Score;

public class TwoMultiplier extends ScoreAugmenter {

	@Override
	public void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore) {			
		questionScore.setQuestionScore(questionScore.getQuestionScore() * 2);
	}

	@Override
	public AugmenterType getAugmenterType() {
		return AugmenterType.MULTIPLY_PER_TWO;
	}

	@Override
	public boolean isNil() {
		return false;
	}

}
