package edu.fiuba.algo3.model;

import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.exceptions.NotValidAugmenterException;

public class Player {
	
	private String name;
	private int score;
	private Map<AugmenterType, Integer> augmentersUsesAvailable;

	public Player(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public Map<AugmenterType, Integer> getAugmentersUsesAvailable() {
		return augmentersUsesAvailable;
	}

	public void setAugmentersUsesAvailable(Map<AugmenterType, Integer> augmentersUsesAvailable) {
		this.augmentersUsesAvailable = augmentersUsesAvailable;
	}
	
	public void setNewAugmenter(AugmenterType augmenterType, Integer uses) {
		if(augmentersUsesAvailable == null) {
			augmentersUsesAvailable = new HashMap<>();
		}
		augmentersUsesAvailable.put(augmenterType, uses);
	}
	
	public Integer getAugmentersUsesAvailable(AugmenterType augmenterType) throws NotValidAugmenterException {
		if(augmentersUsesAvailable == null || !augmentersUsesAvailable.containsKey(augmenterType)) {
			throw new NotValidAugmenterException();
		}
		return augmentersUsesAvailable.get(augmenterType);
	}

	
	
}
