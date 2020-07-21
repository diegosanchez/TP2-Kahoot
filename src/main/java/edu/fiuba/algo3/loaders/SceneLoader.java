package edu.fiuba.algo3.loaders;

import java.io.IOException;

import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.resources.ViewFinder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SceneLoader {

	private static FXMLLoader loader;

	public static void loadScene(Stage stage, String viewName) throws ViewLoadingException {
		loader = new FXMLLoader(ViewFinder.findView(viewName));		
		Parent root;
		try {
			root = loader.load();
		} catch (IOException e) {
			throw new ViewLoadingException("View: " + viewName + " couldn't be loaded by an IOException: " + e.getMessage());
		}

		stage.setScene(new Scene(root));
		stage.setMinWidth(root.minWidth(-1));
		stage.setMinHeight(root.minHeight(-1));
	}

	public static void loadModalAndShow(Parent rootPane, String viewName) throws ViewLoadingException {

		Stage dialog = new Stage();
		loadScene(dialog, viewName);

		dialog.initOwner(rootPane.getScene().getWindow());
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.showAndWait();
	}

	public static <T> T getSceneController(){
		return loader.getController(); //para comunicación entre controladores
	}
}
