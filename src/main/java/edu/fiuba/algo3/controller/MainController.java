package edu.fiuba.algo3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;


import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.display.SceneLoader;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainController {
	
	@FXML
	public VBox mainWindow;
	
	@FXML
	public MenuItem newGameOption;
	
	@FXML
	public MenuItem quitOption;
	
	@FXML
	public MenuItem aboutOption;

	public void initialize() {
		System.out.println("MainController loaded.");
	}
	
	public void closeApp(ActionEvent event) {
		Platform.exit();
	}
	
	public void showAboutModal(ActionEvent event) {
		try {
			SceneLoader.loadModalAndShow(mainWindow, Views.ABOUT_VIEW);
		} catch (ViewLoadingException e) {
			e.printStackTrace();
		}
	}

	public void newGame(ActionEvent event) throws ViewLoadingException {
		SceneLoader.loadModalAndShow(mainWindow, Views.PLAYER_NAME_VIEW);
	}
	
}
