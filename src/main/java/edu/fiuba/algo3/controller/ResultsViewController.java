package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.SystemInfo;

import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ResultsViewController {

    @FXML
    public Label playerWinner;

    @FXML
    public Label player1Name;

    @FXML
    public Label player2Name;

    @FXML
    public Label player1Score;

    @FXML
    public Label player2Score;

    @FXML
    public Button retryButton;

    @FXML
    public void doNext(ActionEvent event){
        //Deberia de empezar de nuevo el juego
    }

    public void initialize(Game game) {
        //Aqui deberia de haber una funcion que nos de el nombre del ganador
        //de la partida

        //playerWinner.setText(game.getWinner().getName);

        player1Name.setText(game.getPlayers().get(0).getName());
        player2Name.setText((game.getPlayers().get(1).getName());

        player1Score.setText(Integer.toString(game.getPlayers().get(0).getScore()));
        player2Score.setText(Integer.toString(game.getPlayers().get(1).getScore()));

    }
}
