package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.QuestionLoader;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.resources.ResourceFinder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class PlayerNameController{

    @FXML
    public TextField textField;

    @FXML
    public Button nextButton;

    @FXML
    public Text text;

    private Game game;
    private ArrayList<Player> players;

    @FXML
    public void initialAction(ActionEvent event){

        if(!textField.getText().isEmpty()) {
            players.add(new Player(textField.getText()));
            textField.clear();
            text.setText("Jugador 2");
            nextButton.setText("Jugar");
            nextButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    finalAction(actionEvent);
                }
            });
        }
    }

    @FXML
    public void finalAction(ActionEvent event){
        if(!textField.getText().isEmpty()) {
            players.add(new Player(textField.getText()));
            nextScene();
        }
    }

    public void nextScene(){
        game.setPlayers(players);

        try{
            game.setQuestions(QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_PATH));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Stage stage = (Stage) text.getScene().getWindow();

        try{
            SceneLoader.loadScene(stage, Views.GENERIC_QUESTION_VIEW);
        } catch (ViewLoadingException e) {
            e.printStackTrace();
            SceneLoader.loadErrorPage();
        }

        GenericQuestionController controller = SceneLoader.getSceneController();
        Scene scene = SceneLoader.getLoadedScene();

        File styles = new File(ResourceConstants.STYLES_ROOT_PATH + "questions.css");
        scene.getStylesheets().add("file:///" + styles.getAbsolutePath().replace("\\", "/"));

        controller.play(game);

    }

    public void initialize() {
        System.out.println("PlayerNameController load.");
        game = new Game();
        players = new ArrayList<>();
    }
}
