package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.engine.score.ScoreAugmenterFactory;
import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;
import edu.fiuba.algo3.model.GameOption;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.*;


public abstract class GenericQuestionController {


    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public GridPane gridPane;
    @FXML
    public Label questionText;
    @FXML
    public Button submitButton;

    private GameController gameController;
    private ArrayList<GameOption> selectedAnswers;
    private AugmenterType augmenterType;


    public abstract void setUpView();

    public void addAnswer(ActionEvent event){
        CheckBox source = (CheckBox) event.getSource();
        GameOption option = new GameOption(source.getText());

        selectedAnswers.add(option);
        source.setOnAction((e)-> undoAnswer(event));
        submitButton.setVisible(true);
    }
     public void undoAnswer(ActionEvent event){
         CheckBox source = (CheckBox) event.getSource();
         GameOption option = new GameOption(source.getText());
         selectedAnswers.remove(option);
         source.setOnAction((e)-> addAnswer(event));

     }

    public void addAugmenter(MouseEvent event){
        Label source = (Label) event.getSource();
        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(source.getText(), gameController.getCurrentQuestion());

        if(augmenter != null) augmenterType = augmenter.getAugmenterType();
    }

    public void doNext(){
        gameController.doNext(selectedAnswers, augmenterType);
    }

    public GameController getGameController(){
        return this.gameController;
    }

    public void initialize(GameController controller){
        System.out.println("GenericQuestionController load.");
        selectedAnswers = new ArrayList<>();
        augmenterType = null;

        this.gameController = controller;
        playerName.setText(gameController.getCurrentPlayer().getName());
        playerScore.setText((Integer.toString(gameController.getCurrentPlayer().getScore().getValue())));
        questionText.setText(gameController.getCurrentQuestion().getText());

        setUpView();
    }
}
