package edu.fiuba.algo3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class Player {
	
	private String name;
	private Score score;
	private List<ScoreAugmenter> augmenters = new ArrayList<>();

	public Player(String name){
		this.name = name;
		score = new Score(0);
		loadAugmenters();
	}

	public String getName() {
		return name;
	}

	public Score getScore() {
		return score;
	}

	private void loadAugmenters() {
		for(AugmenterType augmenterType : AugmenterType.values()) {
			ScoreAugmenter augmenter = augmenterType.getScoreAugmenter();
			IntStream.range(0, augmenter.getUsesPerPlayer()).forEach(
				element -> augmenters.add(augmenter)
			);
		}
	}

	public Score answerQuestion(Question question, GameOption ... selectedOption) {
		return new Score(question.calculatePoints(Arrays.asList(selectedOption)));
	}


	public void answerQuestionWithAugmenter(Question question, String augmenterName, GameOption ... selectedOption) {
		
		score.setQuestionScore(question.calculatePoints(Arrays.asList(selectedOption)));
	}

}
