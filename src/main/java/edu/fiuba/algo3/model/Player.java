package edu.fiuba.algo3.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.augmenters.NoMultiplier;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class Player {
	
	private String name;
	private Score score;
	private int exclusivityUses;
	private HashMap<AugmenterType, Integer> augmentersUsesAvailable;
	private final Integer augmenterUses = 2;

	public Player(String name){
		this.name = name;
		exclusivityUses = 2;
		score = new Score(0);

		augmentersUsesAvailable = new HashMap<>();
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

	public HashMap<AugmenterType, Integer> getAugmentersUsesAvailable() {
		return augmentersUsesAvailable;
	}

	public Integer getAugmentersUsesAvailable(AugmenterType augmenterType)  {
		if(augmentersUsesAvailable.containsKey(augmenterType)) {
			return augmentersUsesAvailable.get(augmenterType);
		}
		else augmentersUsesAvailable.put(augmenterType, augmenterUses);
		return augmenterUses;
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

		if(!augmenter.isNil()){
			Integer uses = getAugmentersUsesAvailable(augmenter.getAugmenterType());
			augmentersUsesAvailable.put(augmenter.getAugmenterType(), uses  >= 1 ? (uses - 1) : 0);
		}
	}

	public void updateScore(Score opponentScore) {
		this.score.update(opponentScore);
	}
}
