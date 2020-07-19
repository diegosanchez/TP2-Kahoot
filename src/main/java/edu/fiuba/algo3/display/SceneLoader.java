package edu.fiuba.algo3.display;

import java.io.IOException;

import edu.fiuba.algo3.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SceneLoader {

	private static final String VIEW_PACKAGE = "/view/";
	private static final String FXML_PREFIX = ".fxml";

	private static FXMLLoader loader;

	public static void loadScene(Stage stage, String viewName) throws IOException {
		loader = new FXMLLoader(App.class.getResource(VIEW_PACKAGE + viewName + FXML_PREFIX));
		Parent root = loader.load();

		stage.setScene(new Scene(root));
		stage.setMinWidth(root.minWidth(-1));
		stage.setMinHeight(root.minHeight(-1));
	}

	public static void loadModalAndShow(Parent rootPane, String viewName)
			throws IOException {

		Stage dialog = new Stage();
		loadScene(dialog, viewName);

		dialog.initOwner(rootPane.getScene().getWindow());
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.showAndWait();
	}

	public static <T> T getSceneController(){
		return loader.getController();
	}
}
