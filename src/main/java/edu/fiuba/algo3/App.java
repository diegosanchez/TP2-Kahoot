package edu.fiuba.algo3;

import java.io.IOException;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.display.SceneLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {        
		try {						
			SceneLoader.loadScene(stage, Views.MAIN_VIEW);
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