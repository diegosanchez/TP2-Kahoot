package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;

import java.util.Iterator;

public class GameManager {

    private Game game;
    private Question currentQuestion;
    private Iterator<Player> playersIterator;
    private Iterator<Question> questionIterator;

    public GameManager(Game game){
        this.game = game;
        questionIterator = game.getQuestions().iterator();
        currentQuestion = questionIterator.next();
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

    public void doNext(){
        if(playersIterator.hasNext()) game.setCurrentPlayer(playersIterator.next());
        else if(questionIterator.hasNext()){
            currentQuestion = questionIterator.next();
            initPlayers();
        }

    }

    public boolean gameIsOver(){
        return !questionIterator.hasNext();
    }


}
