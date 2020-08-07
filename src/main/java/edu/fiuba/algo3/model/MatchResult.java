package edu.fiuba.algo3.model;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class MatchResult {

	private Player player;
	private ScoreAugmenter selectedAugmenter;
	private Score matchScore;

	public MatchResult(Player player, AugmenterType selectedAugmenter, Score matchScore) {
		this.player = player;
		this.selectedAugmenter = player.getAugmenter(selectedAugmenter);
		this.matchScore = matchScore;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}


	public Score getMatchScore() {
		return matchScore;
	}

	public void setMatchScore(Score matchScore) {
		this.matchScore = matchScore;
	}

	public void sumMatchScoreToPlayer() {
		player.sumScore(matchScore);
	}

	public void applyScoreAugmenter(Score opponentScore) {
		selectedAugmenter.applyScoreAugmenter(matchScore, opponentScore);
	}

	
	
}
