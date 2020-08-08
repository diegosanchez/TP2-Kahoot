package edu.fiuba.algo3.engine.questions;

import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Question;

import static edu.fiuba.algo3.constants.Views.MULTIPLE_CHOICE_QUESTION_VIEW;

public class MultipleChoiceWithPenaltyQuestion extends Question {

    public MultipleChoiceWithPenaltyQuestion(String text, List<GameOption> optionsList) { super(text, optionsList); }

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

	@Override
	public boolean hasPenalty() {
		return true;
	}
}
