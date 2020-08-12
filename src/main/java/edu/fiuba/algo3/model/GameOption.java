package edu.fiuba.algo3.model;

public class GameOption {
	
	protected Long id;
	protected String text;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof GameOption) {
			GameOption gameOption = (GameOption) obj;
			if(!text.equals(gameOption.getText())) {
				return false;
			}
			return true;
			
		}
		return false;
	}

}
