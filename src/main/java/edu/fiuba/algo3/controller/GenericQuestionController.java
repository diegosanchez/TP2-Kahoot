package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.TurnManager;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.GameOption;

import edu.fiuba.algo3.model.Question;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;


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

    private TurnManager manager;
    private ArrayList<GameOption> selectedAnswers;
    private AugmenterType augmenterType = null;

    public void play(Game game){
        manager = new TurnManager(game);
        repaint();
    }

    private void setSceneQuestion(Question question) {
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
            Button button = buttonList.get(i);
            button.setVisible(true);
            button.setText(option.getText());
            button.setOnAction((event)-> addAnswer(event));
            i++;
        }
    }

    public void doAbandon(ActionEvent event) {
        manager.getGame().getCurrentPlayer().getScore().setValue(-1);;//cuando anden los puntajes settear a 0 o mandar al ResultsControler el otro player
        endGame();
    }

    public void addAnswer(ActionEvent event){
        Button source = (Button) event.getSource();
        GameOption option = new GameOption(source.getText());
        sumitButton.setVisible(true);

        if(!selectedAnswers.contains(option)){
            selectedAnswers.add(option);
            source.setVisible(false);
        }

    }

    private void repaint(){
        sumitButton.setVisible(false);
        playerName.setText(manager.getCurrentPlayerName());
        questionText.setText(manager.getCurrentQuestion().getText());
        setSceneQuestion(manager.getCurrentQuestion());
    }

    public void doNext(){
        if(!manager.gameIsOver()){
            manager.nextQuestion(selectedAnswers, augmenterType);
            repaint();

            selectedAnswers = new ArrayList<GameOption>();
            augmenterType = null;
        }
        else endGame();
    }

    private void endGame(){
        Stage stage = (Stage) sumitButton.getScene().getWindow();
        try{
            SceneLoader.loadScene(stage, Views.RESULTS_VIEW);
        } catch (ViewLoadingException e) {
            e.printStackTrace();
        }

        ResultsViewController controller = SceneLoader.getSceneController();
        controller.initialize(manager.getGame());
    }

    public void initialize(){
        System.out.println("GenericQuestionController load.");
        selectedAnswers = new ArrayList<GameOption>();
    }
}
