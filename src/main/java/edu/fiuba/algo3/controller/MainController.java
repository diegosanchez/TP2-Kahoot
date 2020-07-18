package edu.fiuba.algo3.controller;

import javafx.fxml.FXML;
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
		Stage dialog = new Stage();
		try {
			dialog.setScene(SceneLoader.loadScene(Views.ABOUT_VIEW));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dialog.initOwner(mainWindow.getScene().getWindow());
		dialog.initModality(Modality.APPLICATION_MODAL); 
		dialog.showAndWait();
	}

	public void newGame(ActionEvent event) throws IOException {
		Stage stage = (Stage) mainWindow.getScene().getWindow();
		stage.setScene(SceneLoader.loadScene(Views.PLAYER_NAME_VIEW));
	}
	
}
