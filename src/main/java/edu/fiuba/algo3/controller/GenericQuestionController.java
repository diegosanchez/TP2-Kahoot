package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GenericQuestionController {

    @FXML
    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public Label questionText;
    @FXML
    public Label questionType;
    @FXML
    public Button sumitButton;
    @FXML
    public VBox mainWindow;


    private Game localGame;
    int playerIndex;
    int questionIndex;

    public void play(Game game){
        localGame = game;
        localGame.setCurrentPlayer(localGame.getPlayers().get(playerIndex));

        playerName.setText(((localGame.getCurrentPlayer()).getName()));
        playerScore.setText(String.valueOf((localGame.getCurrentPlayer()).getScore()));
        questionType.setText(String.valueOf(localGame.getQuestions().get(questionIndex).getType()));
        questionText.setText(localGame.getQuestions().get(questionIndex).getText());
    }

    public void doSumit(ActionEvent event) {
        if(playerIndex == 0){
            //guardar respuesta player1
            nextPlayer();
        }else{
            //guardar respuesta player2
            showCorrectAnswer();
        }
    }

    private void nextPlayer(){
        playerIndex++;
        localGame.setCurrentPlayer(localGame.getPlayers().get(playerIndex));

        playerName.setText(((localGame.getCurrentPlayer()).getName()));
        playerScore.setText(String.valueOf((localGame.getCurrentPlayer()).getScore()));

    }

    private void showCorrectAnswer(){
        nextQuestion();
    }

    private void nextQuestion(){
        playerIndex = 0;
        if(questionIndex < (localGame.getQuestions().size() - 1)){
            questionIndex++;
            localGame.setCurrentPlayer(localGame.getPlayers().get(playerIndex));

            playerName.setText(((localGame.getCurrentPlayer()).getName()));
            playerScore.setText(String.valueOf((localGame.getCurrentPlayer()).getScore()));
            questionText.setText(localGame.getQuestions().get(questionIndex).getText());
        }else{
            System.out.println("Fin Del Juego");
            Stage stage = (Stage) mainWindow.getScene().getWindow();
            try{
                SceneLoader.loadScene(stage, Views.RESULTS_VIEW);
            } catch (ViewLoadingException e) {
                e.printStackTrace();
            }

            ResultsViewController controller = SceneLoader.getSceneController();
            controller.initialize(localGame);
        }

    }

    public void initialize(){
        System.out.println("GenericQuestionController load.");
        playerIndex = 0;
        questionIndex = 0;
    }
}
