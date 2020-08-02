package edu.fiuba.algo3.model;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.engine.score.augmenters.NoMultiplier;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class Player {
	
	private String name;
	private Score score;
	private int exclusivityUses;

	public Player(String name){
		this.name = name;
		exclusivityUses = 2;
		score = new Score(0);
	}

	public String getName() {
		return name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public void answerQuestion(Question question, List<GameOption> selectedOption) {
		score.setAugmenter(new NoMultiplier());
		score.setQuestionScore(question.calculatePoints(selectedOption));
	}

	public void answerQuestion(Question question, GameOption selectedOption) {
		answerQuestion(question, Arrays.asList(selectedOption));
	}

	public void answerQuestionWithAugmenter(Question question, List<GameOption> selectedOption, ScoreAugmenter augmenter) {
		score.setAugmenter(augmenter);
		score.setQuestionScore(question.calculatePoints(selectedOption));

		if(!question.hasPenalty() && !augmenter.isNil())
			exclusivityUses = exclusivityUses >= 1 ? (exclusivityUses-1) : 0;
	}

	public int getExclusivityUsesAvailable() {
		return exclusivityUses;
	}
}
