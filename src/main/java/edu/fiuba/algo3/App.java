package edu.fiuba.algo3;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        
		try {			
			VBox root = loader.load(ViewFinder.findView("MainView"));
			Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("TP2 Kahoot");
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch();
    }

}