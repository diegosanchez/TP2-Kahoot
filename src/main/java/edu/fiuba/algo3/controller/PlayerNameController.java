package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.Stylesheets;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.StylesheetLoadingException;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.GameLoader;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.loaders.StylesheetLoader;
import edu.fiuba.algo3.model.Player;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerNameController{
	
	private static final Logger logger = LoggerFactory.getLogger(PlayerNameController.class);

    @FXML
    public TextField textField;

    @FXML
    public Button nextButton;

    @FXML
    public Text text;

    private ArrayList<Player> players;

    @FXML
    public void initialAction(){

        if(!textField.getText().isEmpty()) {
            players.add(new Player(textField.getText()));
            textField.clear();
            text.setText("Jugador 2");
            nextButton.setText("Jugar");
            nextButton.setOnAction((event)-> finalAction());
        }
    }

    @FXML
    public void finalAction(){
        if(!textField.getText().isEmpty()) {
            players.add(new Player(textField.getText()));
            nextScene();
        }
    }

    public void nextScene(){
        Stage stage = (Stage) text.getScene().getWindow();
        try {
			SceneLoader.loadScene(stage, Views.GAME_VIEW);
			Scene scene = SceneLoader.getCurrentLoadedScene();
	        StylesheetLoader.loadStylesheet(scene, Stylesheets.QUESTIONS_CSS);
		} catch (ViewLoadingException e) {
			logger.error("View not found", e);
			SceneLoader.loadErrorPage();
			stage.show();
		}catch (StylesheetLoadingException e1) {
        	logger.error("Stylesheet not loaded", e1);
        }
        
        GameController controller = SceneLoader.getCurrentSceneController();
        controller.play(GameLoader.loadGame(players), stage);
    }

    public void initialize(){
        players = new ArrayList<>();
    }
}
