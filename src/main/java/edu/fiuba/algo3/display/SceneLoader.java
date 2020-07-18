package edu.fiuba.algo3.display;

import java.io.IOException;

import edu.fiuba.algo3.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneLoader {

	private static final String VIEW_PACKAGE = "/view/";
	private static final String FXML_PREFIX = ".fxml";

	private static FXMLLoader loader;

	public static Scene loadScene(String viewName) throws IOException {
		loader = new FXMLLoader(App.class.getResource(VIEW_PACKAGE + viewName + FXML_PREFIX));
		Parent root = loader.load();
		return new Scene(root);
	}

	public static Object getSceneController(){
		return loader.getController();
	}
	
}
