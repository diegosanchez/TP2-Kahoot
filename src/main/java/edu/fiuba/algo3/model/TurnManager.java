package edu.fiuba.algo3.model;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.ScoreCalculator;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TurnManager {

    private Game game;
    private Question currentQuestion;
    private Iterator<Player> playersIterator;
    private Iterator<Question> questionIterator;
    private HashMap<Player, MatchResult> playerResults;

    public TurnManager(Game game){
        this.game = game;
        questionIterator = game.getQuestions().iterator();
        currentQuestion = questionIterator.next();
        playerResults = new HashMap<Player, MatchResult>();
        initPlayers();
    }

    public String getCurrentPlayerName(){
        return game.getCurrentPlayer().getName();
    }

    public Question getCurrentQuestion(){
        return currentQuestion;
    }

    public Game getGame(){
        return game;
    }

    private void initPlayers(){
        playersIterator = game.getPlayers().iterator();
        game.setCurrentPlayer(playersIterator.next());
    }

    public void nextQuestion(List<GameOption> selectedOptions, AugmenterType selectedAugmenter){
        MatchResult result = new MatchResult(game.getCurrentPlayer(), selectedOptions, selectedAugmenter);
        playerResults.put(game.getCurrentPlayer(), result);

        if(playersIterator.hasNext()){
            game.setCurrentPlayer(playersIterator.next());
        }
        else if(questionIterator.hasNext()){
            MatchResult resultPlayerOne = playerResults.get(game.getPlayers().get(0));
            MatchResult resultPlayerTwo = playerResults.get(game.getPlayers().get(1));

            ScoreCalculator.calculateAndAssignPoints(resultPlayerOne, resultPlayerTwo, currentQuestion);
            currentQuestion = questionIterator.next();
            initPlayers();
        }

    }

    public boolean gameIsOver(){
        return !questionIterator.hasNext();
    }


}
