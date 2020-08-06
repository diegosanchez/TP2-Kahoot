package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.GameOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

import java.util.List;


public class TrueFalseQuestionController extends GenericQuestionController {


    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public GridPane gridPane;
    @FXML
    public Label questionText;
    @FXML
    public Button submitButton;
    @FXML
    public RadioButton radioButton1;
    @FXML
    public RadioButton radioButton2;

    public void setUpView() {
        List<GameOption> options = getGameController().getCurrentQuestion().getOptions();
        radioButton1.setText(options.get(0).getText());
        radioButton2.setText(options.get(1).getText());
    }

    public void choiceOption(ActionEvent event) {
        selectedAnswers.clear();
        RadioButton source = (RadioButton) event.getSource();
        GameOption option = new GameOption(source.getText());

        selectedAnswers.add(option);
        submitButton.setVisible(true);
    }
}