package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.GameOption;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;


public class MultipleChoiceQuestionController extends GenericQuestionController{


    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public VBox vBoxChecks;
    @FXML
    public Label questionText;
    @FXML
    public Button submitButton;

    public void setUpView(){
        List<CheckBox> buttonList = (List) vBoxChecks.getChildren();

        int i = 0;
        for (GameOption option : (getGameController().getCurrentQuestion().getOptions())) {
            CheckBox button = buttonList.get(i);
            button.setText(option.getText());
            button.setOnAction(this::addAnswer);
            i++;
        }
        while (i<5){
            CheckBox unusedButton = buttonList.get(i);
            unusedButton.setVisible(false);
            i++;
        }
    }
}
