package edu.fiuba.algo3.engine.questions;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

import static edu.fiuba.algo3.constants.Views.TRUE_FALSE_QUESTION_VIEW;

public class TrueFalseQuestion extends Question {	
	
	public TrueFalseQuestion(String text) {
		super(text);
	}

	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return 0;
	}
	
	public int calculatePoints(GameOption selectedOption) {
		List<GameOption> selectedOptions = new ArrayList<>();
		selectedOptions.add(selectedOption);
		return calculatePoints(selectedOptions);
	}
	
	public void setCorrectOption(GameOption option) {
		this.correctOptions = new ArrayList<>();
		this.correctOptions.add(option);
	}

	@Override
	public boolean hasPenalty() {
		return false;
	}

	@Override
	public String getView() {
		return TRUE_FALSE_QUESTION_VIEW;
	}

}
