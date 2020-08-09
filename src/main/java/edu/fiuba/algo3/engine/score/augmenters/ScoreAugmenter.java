package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.model.Score;

public abstract class ScoreAugmenter {
	
	public abstract void applyScoreAugmenter(Score questionScore, Score opponentQuestionScore);
	public abstract int getUsesPerPlayer();
	public abstract boolean isForPenalty();
	
}
