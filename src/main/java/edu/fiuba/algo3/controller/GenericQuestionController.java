package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.FileNotFoundException;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Player;

import edu.fiuba.algo3.model.Question;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import edu.fiuba.algo3.resources.ResourceFinder;
import edu.fiuba.algo3.resources.ResourceLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Iterator;
import java.io.File;
import java.util.List;


public class GenericQuestionController {

    @FXML
    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public GridPane gridPane;
    @FXML
    public Label questionText;
    @FXML
    public Label questionType;
    @FXML
    public Button sumitButton;
    @FXML
    public Button abandonButton;

    private Game localGame;
    private Question question;
    Iterator<Player> playersIterator;
    Iterator<Question> questionIterator;

    public void play(Game game){
        localGame = game;
        questionIterator = localGame.getQuestions().iterator();
        question = questionIterator.next();

        setFirstPlayer();
        setScenePlayer();
        setSceneQuestion();
    }

    private void setFirstPlayer(){
        playersIterator = localGame.getPlayers().iterator();
        localGame.setCurrentPlayer(playersIterator.next());
    }

    private void setScenePlayer(){
        playerName.setText(((localGame.getCurrentPlayer()).getName()));
        //playerScore.setText(String.valueOf((localGame.getCurrentPlayer()).getScore()));
    }
    private void setSceneQuestion() {
        Iterator<GameOption> iteratorOptions = question.getOptions().iterator();
        GameOption gameOption = iteratorOptions.next();

        //questionType.setText(String.valueOf(question.getType()));
        questionText.setText(question.getText());
        List<Button> buttonList = (List) gridPane.getChildren();

        for (Button button : buttonList) {
            button.setVisible(false);
        }
        int i = 0;
        for (GameOption option : (question.getOptions())) {
            buttonList.get(i).setVisible(true);
            buttonList.get(i).setText(option.getText());
            i++;
        }
    }

    public void doAbandon(ActionEvent event) {
        localGame.getCurrentPlayer().setScore(-1);//cuando anden los puntajes settear a 0 o mandar al ResultsControler el otro player
        endGame();
    }

    public void doSumitPlayer1(ActionEvent event) {
        //guardar respuesta player1
        nextPlayerView();

    }
    public void doSumitPlayer2(ActionEvent event) {
        //guardar respuesta player2
        showCorrectAnswer();

    }

    private void nextPlayerView(){
        localGame.setCurrentPlayer(playersIterator.next());
        setScenePlayer();
        sumitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                doSumitPlayer2(actionEvent);
            }
        });
    }

    private void showCorrectAnswer(){
        //mostrar respuestas correctas
        nextQuestion();
    }


    private void nextQuestion(){
        if(questionIterator.hasNext()){

            question = questionIterator.next();

            setFirstPlayer();
            setScenePlayer();
            setSceneQuestion();
            sumitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    doSumitPlayer1(actionEvent);
                }
            });
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
    }
}
