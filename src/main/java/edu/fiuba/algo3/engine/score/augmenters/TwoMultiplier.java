package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Score;

public class TwoMultiplier extends ScoreAugmenter {

	@Override
	public void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore) {			
		questionScore.setValue(questionScore.getValue() * 2);
	}

	@Override
	protected AugmenterType getAugmenterType() {
		return AugmenterType.MULTIPLY_PER_TWO;
	}

}
