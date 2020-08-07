package edu.fiuba.algo3.model;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.score.AugmenterCalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game {
	
	private List<Player> players;
	private List<Question> questions;
	private Player currentPlayer;
	private Question currentQuestion;
	private Iterator<Player> playersIterator;
	private Iterator<Question> questionIterator;
	private List<MatchResult> matchResults;
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

	public void newRound(){
		playersIterator = players.iterator();
		currentPlayer = playersIterator.next();
		matchResults = new ArrayList<>();
	}

	public void start(){
		newRound();
		questionIterator = questions.iterator();
		currentQuestion = questionIterator.next();
		isOver = false;
	}

	public void nextTurn(List<GameOption> selectedOptions, String augmenterString){
		Score matchScore = new Score(currentQuestion.calculatePoints(selectedOptions));
		AugmenterType selectedAugmenter = AugmenterType.valueOf(augmenterString);
		matchResults.add(new MatchResult(currentPlayer, selectedAugmenter, matchScore));
		
		if(playersIterator.hasNext()){
			currentPlayer = playersIterator.next();
		}
		else if(!isOver){
			AugmenterCalculator.calculateAndAssignPoints(matchResults);

			if(questionIterator.hasNext()){
				currentQuestion = questionIterator.next();
				newRound();
			}
			else isOver = true;
		}
	}

	public Player getWinner() {
		if (players.get(0).getScore().getValue() == players.get(1).getScore().getValue()){
			return null;
		};
		if (players.get(0).getScore().getValue() > players.get(1).getScore().getValue()){
			return players.get(0);
		}
		return players.get(1);
	}

	public int getTurnCount(){
		return players.size() * questions.size();
	}
}
