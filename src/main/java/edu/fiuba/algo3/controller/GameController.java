package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.constants.Stylesheets;
import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.StylesheetLoadingException;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.loaders.StylesheetLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameController {

    private Game game;
    private Stage stage;

    public void play(Game game, Stage stage){
        this.game = game;
        this.stage = stage;

        game.start();
        setQuestionSceneView();
    }

    private void setQuestionSceneView(){
        try{
            SceneLoader.loadScene(stage, getCurrentQuestion().getView());
            //SceneLoader.loadScene(stage, Views.GENERIC_QUESTION_VIEW);
        } catch (ViewLoadingException e) {
            e.printStackTrace();
            SceneLoader.loadErrorPage();
        }

        Scene scene = SceneLoader.getLoadedScene();

        try {
            StylesheetLoader.loadStylesheet(scene, Stylesheets.QUESTIONS_CSS);
        } catch (StylesheetLoadingException e1) {
            e1.printStackTrace();
        }

        GenericQuestionController controller = SceneLoader.getSceneController();
        controller.initialize(this);
    }
    public Player getCurrentPlayer(){
        return this.game.getCurrentPlayer();
    }

    public Question getCurrentQuestion(){
        return this.game.getCurrentQuestion();
    }

    public void doNext(ArrayList<GameOption> selectedAnswers, String augmenterString){
        if(!game.isOver()){
            game.nextTurn(selectedAnswers, augmenterString);
            setQuestionSceneView();
        }
        else endGame();
    }

    private void endGame(){

        try{
            SceneLoader.loadScene(stage, Views.RESULTS_VIEW);
        } catch (ViewLoadingException e) {
            e.printStackTrace();
        }

        ResultsViewController controller = SceneLoader.getSceneController();
        controller.initialize(game);
    }

    public void initialize(){
        System.out.println("GameController load.");
    }
}
