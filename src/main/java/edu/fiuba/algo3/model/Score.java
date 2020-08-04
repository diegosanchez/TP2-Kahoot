package edu.fiuba.algo3.model;

import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

public class Score {

	private int value;
	private int questionScore;
	private ScoreAugmenter augmenter;

	public Score(int value){
		this.value = value;
		questionScore = 0;
	}

	public Score(int value, int questionScore){
		this.value = value;
		this.questionScore = questionScore;
	}

	public void update(Score oponentScore){
		augmenter.applyScoreAugmenter(this, oponentScore);
		value += questionScore;
	}
	
	public int getValue() {
		return value;
	}

	public int getQuestionScore(){
		return questionScore;
	}

	public void setQuestionScore(int tempScore){
		this.questionScore = tempScore;
	}

	public void setAugmenter(ScoreAugmenter augmenter){
		this.augmenter = augmenter;
	}

	public ScoreAugmenter getAugmenter(){
		return augmenter;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void sumScore(Score score) {
		this.value = this.value + score.getValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
