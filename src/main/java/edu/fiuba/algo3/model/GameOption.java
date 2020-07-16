package edu.fiuba.algo3.model;

public class GameOption {
	
	private long id;
	private String text;
	
	public GameOption(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}		

}
