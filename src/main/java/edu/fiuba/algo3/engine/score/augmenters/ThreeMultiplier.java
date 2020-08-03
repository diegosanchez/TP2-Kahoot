package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Score;

public class ThreeMultiplier extends ScoreAugmenter{
	
	@Override
	public void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore) {			
		questionScore.setQuestionScore(questionScore.getQuestionScore() * 3);
	}

	@Override
	public AugmenterType getAugmenterType() {
		return AugmenterType.MULTIPLY_PER_THREE;
	}

	@Override
	public boolean isNil() {
		return false;
	}

}
