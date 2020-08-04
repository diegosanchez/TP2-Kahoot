package edu.fiuba.algo3.loaders;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.exceptions.QuestionsNotLoadedException;
import edu.fiuba.algo3.model.Game;
import edu.fiuba.algo3.model.Player;

public class GameLoader {
	
	private GameLoader() {}
	
	private static final Logger logger = LoggerFactory.getLogger(GameLoader.class);

	public static Game loadGame(List<Player> players) {
		Game game = new Game();
		game.setPlayers(players);

		try {
			game.setQuestions(QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_PATH));
		} catch (QuestionsNotLoadedException ex) {
			logger.error("Question not loaded", ex);
			SceneLoader.loadErrorPage();
		}
		return game;
	}
}
