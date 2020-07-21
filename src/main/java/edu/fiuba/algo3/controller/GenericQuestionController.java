package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GenericQuestionController {

    @FXML
    public TextField textField;

    @FXML
    public Button nextButton;

    @FXML
    public Text text;

    private Game game;
    private ArrayList<Player> players;

    @FXML
    public void doNext(ActionEvent event){

        if(!textField.getText().isEmpty()){

            players.add(new Player(textField.getText()));

            if(text.getText().equals("Jugador 1")){
                textField.clear();
                text.setText("Jugador 2");
                nextButton.setText("Jugar");
            }
            else if(nextButton.getText().equals("Jugar")){
                game.setPlayers(players);
                /*
                * La idea sería seguir con algo así
                * */
                //Stage stage = (Stage) text.getScene().getWindow();
                //SceneLoader.loadScene(stage, Views.QUESTION_VIEW);

                //QuestionController controller = (QuestionController) SceneLoader.getSceneController();
                //controller.play(game);
            }
        }
    }

    public void initialize() {
        game = new Game();
        players = new ArrayList<>();
    }
}
