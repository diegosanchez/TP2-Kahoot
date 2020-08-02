package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.Stylesheets;
import edu.fiuba.algo3.exceptions.StylesheetLoadingException;
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

public class PlayerNameController{

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
        GameController controller = new GameController();
        controller.play(GameLoader.loadGame(players), stage);
    }

    public void initialize(){
        System.out.println("PlayerNameController load.");
        players = new ArrayList<>();
    }
}
