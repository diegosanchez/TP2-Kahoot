package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;

public class TrueFalseWithPenaltyQuestion extends TrueFalseQuestion {	
	
	public TrueFalseWithPenaltyQuestion(String text) {
		super(text);
	}

	@Override
	protected int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return -1;
	}
}
