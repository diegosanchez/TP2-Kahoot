package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(String text) {
		super(text);
	}

	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.size() == correctOptions.size() && selectedOptions.containsAll(correctOptions)) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean hasPenalty() {
		return false;
	}

}
