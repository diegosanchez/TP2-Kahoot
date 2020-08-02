package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

import static edu.fiuba.algo3.constants.Views.ORDERED_CHOICE_QUESTION_VIEW;

public class OrderedChoiceQuestion extends Question {
	
	public OrderedChoiceQuestion(String text) {
		super(text);
	}
	
	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean hasPenalty() {
		return false;
	}

	@Override
	public String getView() {
		return ORDERED_CHOICE_QUESTION_VIEW;
	}

}
