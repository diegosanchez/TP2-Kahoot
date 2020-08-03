package edu.fiuba.algo3.controller;

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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameController {

    private Game game;
    private Stage stage;
    
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
    
    public void play(Game game, Stage stage){
        this.game = game;
        this.stage = stage;

        game.start();
        setQuestionSceneView();
    }

    private void setQuestionSceneView(){
        try{
            SceneLoader.loadScene(stage, getCurrentQuestion().getView());
        } catch (ViewLoadingException e) {
        	logger.error("View not loaded", e);
            SceneLoader.loadErrorPage();
        }

        Scene scene = SceneLoader.getLoadedScene();

        try {
            StylesheetLoader.loadStylesheet(scene, Stylesheets.QUESTIONS_CSS);
        } catch (StylesheetLoadingException e1) {
        	logger.error("Stylesheet not loaded", e1);
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

    public void doNext(List<GameOption> selectedAnswers, String augmenterString){
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
        	logger.error("View not loaded", e);
        	SceneLoader.loadErrorPage();
        }

        ResultsViewController controller = SceneLoader.getSceneController();
        controller.initialize(game);
    }

}
