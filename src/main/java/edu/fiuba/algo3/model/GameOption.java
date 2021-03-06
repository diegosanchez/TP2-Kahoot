package edu.fiuba.algo3.model;

public class GameOption {
	
	private Long id;
	private String text;
	private OptionGroup optionGroup;
	
	public GameOption(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public OptionGroup getOptionGroup() {
		return optionGroup;
	}

	public void setOptionGroup(OptionGroup group) {
		this.optionGroup = group;
	}		
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GameOption) {
			GameOption gameOption = (GameOption) obj;
			if(!text.equals(gameOption.getText())) {
				return false;
			}
			if(optionGroup != null && !optionGroup.equals(gameOption.getOptionGroup())) {
				return false;
			}
			return true;
			
		}
		return false;
	}

}
