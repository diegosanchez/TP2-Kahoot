package edu.fiuba.algo3.model;

import java.util.ArrayList;
import java.util.List;

public class OptionGroup extends GameOption {
		
	private List<GameOption> options;
	
	public OptionGroup(String text) {
		super(text);
	}
	
	public List<GameOption> getOptions() {
		return options;
	}
	public void setOptions(List<GameOption> options) {
		this.options = options;
	}

	public void addOption(GameOption option) {
		if(options == null) {
			options = new ArrayList<GameOption>();
		}
		options.add(option);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof OptionGroup) {
			OptionGroup optionGroup = (OptionGroup) obj;
			return options.equals(optionGroup.getOptions());
		}
		return false;
	}

}
