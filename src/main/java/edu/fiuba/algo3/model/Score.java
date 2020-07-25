package edu.fiuba.algo3.model;

public class Score {

	private int value;

	public Score(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public void sumScore(Score score) {
		this.value = this.value + score.getValue();
	}
}
