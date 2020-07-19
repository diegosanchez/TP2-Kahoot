package edu.fiuba.algo3.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.display.SceneLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainController {
	
	@FXML
	public VBox mainWindow;
	
	@FXML
	public MenuItem newGameOptiom;
	
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newGame(ActionEvent event) throws IOException {
		Stage stage = (Stage) mainWindow.getScene().getWindow();
		SceneLoader.loadScene(stage, Views.PLAYER_NAME_VIEW);
	}
	
}
