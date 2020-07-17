package edu.fiuba.algo3.model;

import java.util.List;

public abstract class Question {

	private long id;
	private String text;
	private List<GameOption> options;
	protected List<GameOption> correctOptions;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<GameOption> getOptions() {
		return options;
	}

	public void setOptions(List<GameOption> options) {
		this.options = options;
	}	
	
	public List<GameOption> getCorrectOptions() {
		return correctOptions;
	}

	public void setCorrectOptions(List<GameOption> correctOptions) {
		this.correctOptions = correctOptions;
	}	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	/***
	 * Returns the earned or lost points depending on the answer to the question
	 * @return
	 */
	public abstract int calculatePoints(List<GameOption> selectedOptions);

	
}
