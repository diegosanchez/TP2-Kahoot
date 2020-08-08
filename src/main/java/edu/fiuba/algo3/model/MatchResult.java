package edu.fiuba.algo3.model;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class MatchResult {

	private Player player;
	private ScoreAugmenter selectedAugmenter;
	private Score matchScore;

	public MatchResult(Player player, Question question, AugmenterType selectedAugmenter, List<GameOption> selectedOptions) {
		this.player = player;
		this.selectedAugmenter = player.getAugmenter(selectedAugmenter);
		this.matchScore = new Score(question.calculatePoints(selectedOptions));
	}
	
	public MatchResult(Player player, Question question, List<GameOption> selectedOptions) {
		this(player,  question, null, selectedOptions);
	}
	
	public MatchResult(Player player, Question question, AugmenterType selectedAugmenter, GameOption ... selectedOptions) {
		this(player,  question, selectedAugmenter, Arrays.asList(selectedOptions));
	}
	
	public MatchResult(Player player, Question question, GameOption ... selectedOptions) {
		this(player,  question, null, Arrays.asList(selectedOptions));
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
