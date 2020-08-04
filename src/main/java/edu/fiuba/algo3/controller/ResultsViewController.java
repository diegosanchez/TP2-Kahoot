package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ResultsViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResultsViewController.class);

    @FXML
    public Label playerWinner;

    @FXML
    public Label announcer;

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
    public Button closeButton;

    @FXML
    public void doRestart(ActionEvent event){
        Stage stage = (Stage) retryButton.getScene().getWindow();
        try{
            SceneLoader.loadScene(stage, Views.PLAYER_NAME_VIEW);
        }catch (ViewLoadingException e){
        	logger.error("View not loaded", e);
        }
    }

    @FXML
    public void doClose(ActionEvent event){
        Stage stage = (Stage) retryButton.getScene().getWindow();
        stage.close();
    }

    public void initialize(Game game) {
        Player winner = game.getWinner();

        if(winner == null){
            playerWinner.setVisible(false);
            announcer.setText("EMPATE");
        }
        else{
            playerWinner.setText(winner.getName());
        }


        player1Name.setText(game.getPlayers().get(0).getName());
        player2Name.setText((game.getPlayers().get(1).getName()));

        player1Score.setText(Integer.toString(game.getPlayers().get(0).getScore().getValue()));
        player2Score.setText(Integer.toString(game.getPlayers().get(1).getScore().getValue()));

    }
}
