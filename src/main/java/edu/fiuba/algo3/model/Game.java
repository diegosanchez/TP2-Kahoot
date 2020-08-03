package edu.fiuba.algo3.model;

import edu.fiuba.algo3.engine.score.ScoreAugmenterFactory;
import edu.fiuba.algo3.engine.score.ScoreCalculator;
import edu.fiuba.algo3.engine.score.augmenters.ScoreAugmenter;

import java.util.Iterator;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private List<Question> questions;
	private Player currentPlayer;
	private Question currentQuestion;
	private Iterator<Player> playersIterator;
	private Iterator<Question> questionIterator;
	private boolean isOver;

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isOver(){
		return isOver;
	}

	public Question getCurrentQuestion(){
		return currentQuestion;
	}

	public void initPlayers(){
		playersIterator = players.iterator();
		currentPlayer = playersIterator.next();
	}

	public void start(){
		initPlayers();
		questionIterator = questions.iterator();
		currentQuestion = questionIterator.next();
		isOver = false;
	}

	public void nextTurn(List<GameOption> selectedOptions, String augmenterString){
		ScoreAugmenter selectedAugmenter = ScoreAugmenterFactory.
				createScoreAugmenter(augmenterString, currentQuestion, currentPlayer.getAugmentersUsesAvailable());

		currentPlayer.answerQuestionWithAugmenter(currentQuestion, selectedOptions, selectedAugmenter);

		if(playersIterator.hasNext()){
			currentPlayer = playersIterator.next();
		}
		else if(!isOver){
			ScoreCalculator.calculateAndAssignPoints(players.get(0), currentPlayer);

			if(questionIterator.hasNext()){
				currentQuestion = questionIterator.next();
				initPlayers();
			}
			else isOver = true;
		}
	}

	public Player getWinner() {
		if (players.get(0).getScore().getValue() > players.get(1).getScore().getValue()){
			return players.get(0);
		}
		return players.get(1);
	}

	public int getTurnCount(){
		return players.size() * questions.size();
	}
}
