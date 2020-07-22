package edu.fiuba.algo3.loaders;

import java.util.List;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.exceptions.QuestionsNotLoadedException;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;

public class GameLoader {

	public static Game loadGame(List<Player> players) {
		Game game = new Game();
		game.setPlayers(players);
		game.setCurrentPlayer(players.get(0));
		try {
			game.setQuestions(QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_PATH));
		} catch (QuestionsNotLoadedException ex) {
			ex.printStackTrace();
		}
		return game;
	}
}
