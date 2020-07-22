package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.QuestionLoader;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

                //game.setCurrentPlayer(game.getPlayers().get(0));
                
                try{
                    game.setQuestions(QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_PATH));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Stage stage = (Stage) text.getScene().getWindow();

                try{
                    SceneLoader.loadScene(stage, Views.GENERIC_QUESTION_VIEW);
                } catch (ViewLoadingException e) {
                	e.printStackTrace();
        			SceneLoader.loadErrorPage();
                }

                GenericQuestionController controller = SceneLoader.getSceneController();
                controller.play(game);
            }
        }
    }

    public void initialize() {
        game = new Game();
        players = new ArrayList<>();
    }
}
