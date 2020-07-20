package edu.fiuba.algo3.engine.score.augmenters;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Player;

public class ExclusivityMultiplier extends ScoreAugmenter {

	@Override
	protected void applyNewScore(Player currentPlayer, Player opponent, int score, int opponentScore) {		
		if(score > opponentScore) {
			currentPlayer.setScore(currentPlayer.getScore() + score * 2);
		}else if(score < opponentScore){
			opponent.setScore(opponent.getScore() + opponentScore * 2);
		}
	}

	@Override
	protected AugmenterType getAugmenterType() {
		return AugmenterType.EXCLUSIVITY;
	}

}
