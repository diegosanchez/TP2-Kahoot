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
	
	public void sum(Score score) {
		value = score.getValue() + value;
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
