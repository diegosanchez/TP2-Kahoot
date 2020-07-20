package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Player;

public abstract class ScoreAugmenter {
	
	public void applyScoreAugmenter(Player currentPlayer, Player opponent, int score, int opponentScore) {
		applyNewScore(currentPlayer, opponent, score, opponentScore);
		substractUseOfAugmenter(currentPlayer);
	}
	
	protected abstract void applyNewScore(Player currentPlayer, Player opponent, int score, int opponentScore);
	protected abstract AugmenterType getAugmenterType();
	
	protected void substractUseOfAugmenter(Player player) {
		Integer currentUses = player.getAugmentersUsesAvailable().get(getAugmenterType());
		player.getAugmentersUsesAvailable().put(getAugmenterType(), currentUses - 1);
	}
}
