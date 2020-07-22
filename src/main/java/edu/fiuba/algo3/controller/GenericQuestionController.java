package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public Button abandonButton;

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

    public void doSumitPlayer1(ActionEvent event) {
        //guardar respuesta player1
        nextPlayer();

        showCorrectAnswer();
    }

    public void doAbandon(ActionEvent event) {
        localGame.getCurrentPlayer().setScore(-1);//cuando anden los puntaje settear a 0
        endGame();
    }
    private void nextPlayer(){
        localGame.setCurrentPlayer(localGame.getPlayers().get(1));
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
            endGame();
        }

    }

    private void endGame(){
        Stage stage = (Stage) sumitButton.getScene().getWindow();
        try{
            SceneLoader.loadScene(stage, Views.RESULTS_VIEW);
        } catch (ViewLoadingException e) {
            e.printStackTrace();
        }

        ResultsViewController controller = SceneLoader.getSceneController();
        controller.initialize(localGame);
    }

    public void initialize(){
        System.out.println("GenericQuestionController load.");
        playerIndex = 0;
        questionIndex = 0;
    }
}
