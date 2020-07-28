package edu.fiuba.algo3.engine.questions;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.OptionGroup;
import edu.fiuba.algo3.model.Question;

public class GroupChoiceQuestion extends Question {	
	
	public GroupChoiceQuestion(String text) {
		super(text);
	}
	
	@Override
	public int calculatePoints(List<GameOption> selectedOptions) {
		if(selectedOptions.equals(correctOptions)) {
			return 1;
		}
		return 0;
	}
	
	public List<OptionGroup> getOptionGroupList(){
		List<OptionGroup> optionGroupList = new ArrayList<>();
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
}
