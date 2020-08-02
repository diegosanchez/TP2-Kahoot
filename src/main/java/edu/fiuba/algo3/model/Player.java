package edu.fiuba.algo3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.constants.AugmenterType;

public class Player {
	
	private String name;
	private Score score = new Score(0);
	private Map<AugmenterType, Integer> augmentersUsesAvailable;

	public Player(String name){
		this.name = name;
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

	public Map<AugmenterType, Integer> getAugmentersUsesAvailable() {
		return augmentersUsesAvailable;
	}
	
	public void setNewAugmenter(AugmenterType augmenterType, Integer uses) {
		if(augmentersUsesAvailable == null) {
			augmentersUsesAvailable = new HashMap<>();
		}
		if(!augmentersUsesAvailable.containsKey(augmenterType))
			augmentersUsesAvailable.put(augmenterType, uses);
	}
	
	public Integer getAugmentersUsesAvailable(AugmenterType augmenterType)  {
		if(augmentersUsesAvailable != null && augmentersUsesAvailable.containsKey(augmenterType)) {
			return augmentersUsesAvailable.get(augmenterType);
		}
		return 0;
	}
	
	public void substractUseOfAugmenter(AugmenterType scoreAugmenter) {
		Integer currentUses = augmentersUsesAvailable.get(scoreAugmenter);
		augmentersUsesAvailable.put(scoreAugmenter, currentUses - 1);
	}

	public MatchResult answerQuestion(GameOption selectedOption) {
		return new MatchResult(this, selectedOption);
	}

	public MatchResult answerQuestion(List<GameOption> selectedOption) {
		return new MatchResult(this, selectedOption);
	}

	public MatchResult answerQuestionWithAugmenter(List<GameOption> selectedOption, AugmenterType augmenter) {
		//REFACTOR HERE (MAYBE)
		if (this.getAugmentersUsesAvailable().get(augmenter) <= 0)
			return this.answerQuestion(selectedOption);
		else
			this.substractUseOfAugmenter(augmenter);
			return new MatchResult(this, selectedOption, augmenter);
	}


}
