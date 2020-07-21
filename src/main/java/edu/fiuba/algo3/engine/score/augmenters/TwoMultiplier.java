package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Player;

public class TwoMultiplier extends ScoreAugmenter {

	@Override
	protected void applyNewScore(Player currentPlayer, Player opponent, int score, int opponentScore) {		
		currentPlayer.setScore(currentPlayer.getScore() + score * 2);
	}

	@Override
	protected AugmenterType getAugmenterType() {
		return AugmenterType.MULTIPLY_PER_TWO;
	}

}
