package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.GameLoader;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import javafx.application.Application;
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
		} catch (ViewLoadingException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        launch();
    }

}