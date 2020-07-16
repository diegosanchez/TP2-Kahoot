package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

public class MultipleChoiceQuestion extends Question {

	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return 0;
	}

}
