package edu.fiuba.algo3.model;

import java.util.List;

import edu.fiuba.algo3.constants.QuestionType;

public abstract class Question {

	protected String text;
	protected QuestionType type;
	protected List<GameOption> options;
	protected List<GameOption> correctOptions;

	public Question(String text, List<GameOption> optionsList) {
		this.text = text;
		this.options = optionsList;
	}

	public List<GameOption> getOptions() {
		return options;
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
	
	public QuestionType getType() {
		return type;
	}

	/***
	 * Returns the earned or lost points depending on the answer to the question
	 * @return
	 */
	public abstract int calculatePoints(List<GameOption> selectedOptions);

	public abstract boolean hasPenalty();
}
