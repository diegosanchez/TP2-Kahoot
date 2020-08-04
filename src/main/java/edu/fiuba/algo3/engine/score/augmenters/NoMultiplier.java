package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Score;

public class NoMultiplier extends ScoreAugmenter{
    @Override
    public void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore) { }

    @Override
    public AugmenterType getAugmenterType() {
        return AugmenterType.NO_MULTIPLIER;
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
