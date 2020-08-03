package edu.fiuba.algo3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.exceptions.QuestionsNotLoadedException;
import edu.fiuba.algo3.loaders.QuestionLoader;

public class GameTest {

	 @Test
	 public void pasarDeTurnoCambiaElJugadorTest() {
		 Game game = new Game();
		 Player jugadorUno = new Player("Jugador uno");
		 Player jugadorDos = new Player("Jugador dos");
		 List<Player> lista = new ArrayList<>();
		 lista.add(jugadorUno);
		 lista.add(jugadorDos);
		 game.setPlayers(lista);		 		 
		 try {
			game.setQuestions(QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_TEST_PATH));
		 } catch (QuestionsNotLoadedException e) {
			fail();
		 }
		 game.start();
		 assertEquals(jugadorUno, game.getCurrentPlayer());
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 assertEquals(jugadorDos, game.getCurrentPlayer());
	 }
	 
	 @Test
	 public void iniciarJuegoSeleccionaPreguntaInicialTest() {
		 Game game = new Game();
		 Player jugadorUno = new Player("Jugador uno");
		 Player jugadorDos = new Player("Jugador dos");
		 List<Player> lista = new ArrayList<>();
		 lista.add(jugadorUno);
		 lista.add(jugadorDos);
		 game.setPlayers(lista);
		 List<Question> questions = null;
		 try {
			questions = QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_TEST_PATH);		 
			game.setQuestions(questions);
		 } catch (QuestionsNotLoadedException e) {
			fail();
		 }
		 game.start();
		 assertEquals(questions.get(0), game.getCurrentQuestion());
	 }
	 
	 @Test
	 public void iterarTodasLasPreguntasFinalizaElJuegoTest() {
		 Game game = new Game();
		 Player jugadorUno = new Player("Jugador uno");
		 Player jugadorDos = new Player("Jugador dos");
		 List<Player> lista = new ArrayList<>();
		 lista.add(jugadorUno);
		 lista.add(jugadorDos);
		 game.setPlayers(lista);
		 List<Question> questions = new ArrayList<>();
		 questions.add(new TrueFalseQuestion("¿1 es mayor a 2?"));
		 game.setQuestions(questions);
		 game.start();
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 assertTrue(game.isOver());
	 }
	 
	 @Test
	 public void unJugadorConMasPuntajeQueElOtroResultaGanadorTest() {
		 Game game = new Game();
		 Player jugadorUno = new Player("Jugador uno");
		 jugadorUno.setScore(new Score(100));
		 Player jugadorDos = new Player("Jugador dos");
		 jugadorDos.setScore(new Score(50));
		 List<Player> lista = new ArrayList<>();
		 lista.add(jugadorUno);
		 lista.add(jugadorDos);
		 game.setPlayers(lista);
		 List<Question> questions = new ArrayList<>();
		 questions.add(new TrueFalseQuestion("¿1 es mayor a 2?"));
		 game.setQuestions(questions);
		 game.start();
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 assertEquals(jugadorUno, game.getWinner());
	 }
}
