package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

public class MultipleChoiceWithPenaltyQuestion extends Question {
	
	public MultipleChoiceWithPenaltyQuestion(String text) {
		super(text);
	}

	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		int puntaje = 0;
		for(GameOption option : selectedOptions) {
			if(correctOptions.contains(option)) {
				puntaje ++;
			}else {
				puntaje --;
			}			
		}
		return puntaje;
	}
}
