package edu.fiuba.algo3.model;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.ScoreCalculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private List<Question> questions;
	private Player currentPlayer;
	private Question currentQuestion;
	private Iterator<Player> playersIterator;
	private Iterator<Question> questionIterator;
	private HashMap<Player, MatchResult> playerResults;

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
		return (!playersIterator.hasNext() && !questionIterator.hasNext());
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
		playerResults = new HashMap<Player, MatchResult>();
	}

	public void nextTurn(List<GameOption> selectedOptions, AugmenterType selectedAugmenter){
		if(selectedAugmenter != null) currentPlayer.setNewAugmenter(selectedAugmenter, 2);

		MatchResult result = new MatchResult(currentPlayer, selectedOptions, selectedAugmenter);
		playerResults.put(currentPlayer, result);

		if(playersIterator.hasNext()) {
			currentPlayer = playersIterator.next();
		}else if(questionIterator.hasNext()){
			MatchResult resultPlayerOne = playerResults.get(players.get(0));
			MatchResult resultPlayerTwo = playerResults.get(players.get(1));

			ScoreCalculator.calculateAndAssignPoints(currentQuestion, resultPlayerOne, resultPlayerTwo);

			currentQuestion = questionIterator.next();
			initPlayers();
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
