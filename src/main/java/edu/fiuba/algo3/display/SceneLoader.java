package edu.fiuba.algo3.display;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class SceneLoader {

	public static Scene loadScene(String viewName) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		Pane panel = loader.load(ViewFinder.findView(viewName));
		Scene scene = new Scene(panel);
		return scene;
	}
	
}
