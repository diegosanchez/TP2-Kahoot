package edu.fiuba.algo3.engine.questions;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.constants.QuestionType;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.OptionGroup;
import edu.fiuba.algo3.model.Question;

public class GroupChoiceQuestion extends Question {	

	public GroupChoiceQuestion(String text, List<GameOption> optionList) { super(text, optionList); }

	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return 0;
	}
	
	public List<String> getOptionGroupList(){
		List<String> optionGroupList = new ArrayList<>();
		for(GameOption option : correctOptions) {
			if(!optionGroupList.contains(option.getOptionGroup())) {
				optionGroupList.add(option.getOptionGroup());
			}
		}
		return optionGroupList;
	}

	@Override
	public boolean hasPenalty() {
		return false;
	}

	@Override
	public QuestionType getType() {
		return QuestionType.GROUP_CHOICE;
	}
}
