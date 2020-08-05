package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.resources.QuestionViewRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameController {
    
	@FXML
    public Label playerName;
    @FXML
    public Label playerScore;
    @FXML
    public Label questionText;
    @FXML
    public Button submitButton;    
    @FXML
    public Pane questionPane;

    private String augmenterString;
    
    private Game game;
    private Stage stage;
    private GenericQuestionController currentQuestionController;
    
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    public void addAugmenter(MouseEvent event){
        Label source = (Label) event.getSource();
        augmenterString = source.getText();
    }
    
    public void play(Game game, Stage stage){
        this.game = game;
        this.stage = stage;

        game.start();
        setQuestionSceneView();
    }

    private void setQuestionSceneView(){
        try{
        	String viewName = QuestionViewRouter.getViewByQuestionType(getCurrentQuestion().getType());
        	SceneLoader.loadInsidePane(questionPane, viewName);
        	currentQuestionController = SceneLoader.getCurrentSceneController();
        	currentQuestionController.initialize(this);
        } catch (ViewLoadingException e) {
        	logger.error("View not loaded", e);
            SceneLoader.loadErrorPage();
        }        
        updateBoard();
    }
    
    private void updateBoard() {
    	playerName.setText(getCurrentPlayer().getName());  
        playerScore.setText((Integer.toString(getCurrentPlayer().getScore().getValue())));
        questionText.setText(getCurrentQuestion().getText());
    }
    
    public Player getCurrentPlayer(){
        return this.game.getCurrentPlayer();
    }

    public Question getCurrentQuestion(){
        return this.game.getCurrentQuestion();
    }

    public void doNext(){
    	 game.nextTurn(currentQuestionController.getSelectedAnswers(), augmenterString);
         setQuestionSceneView();
         //submitButton.setVisible(false);
         
         if(game.isOver()) endGame();
    }
    
    private void endGame(){
        try{
            SceneLoader.loadScene(stage, Views.RESULTS_VIEW);
        } catch (ViewLoadingException e) {
        	logger.error("View not loaded", e);
        	SceneLoader.loadErrorPage();
        }

        ResultsViewController controller = SceneLoader.getCurrentSceneController();
        controller.initialize(game);
    }

}
