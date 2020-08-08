package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.GameOption;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

import java.util.List;


public class GroupChoiceQuestionController extends GenericQuestionController{

    @FXML
    public GridPane gridPane;
	
    public void setUpView(){
        List<CheckBox> buttonList = (List) gridPane.getChildren();

        int i = 0;
        for (GameOption option : (gameController.getCurrentQuestion().getOptions())) {
            CheckBox button = buttonList.get(i);
            button.setText(option.getText());
            button.setOnAction(this::addAnswer);
            button.setVisible(true);
            i++;
        }
        while (i<6){
            CheckBox unusedButton = buttonList.get(i);
            unusedButton.setVisible(false);
            i++;
        }
    }
}
