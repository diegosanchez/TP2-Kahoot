package edu.fiuba.algo3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerPaneController {
    @FXML
    public Label playerName;
    @FXML
    public Label playerScore;

    public void initialize(GameController gamecontroller){
        playerName.setText(gamecontroller.getCurrentPlayer().getName());
        playerScore.setText(String.valueOf(gamecontroller.getCurrentPlayer().getScore().getValue()));
    }

}
