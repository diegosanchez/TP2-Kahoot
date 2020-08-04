package edu.fiuba.algo3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.exceptions.QuestionsNotLoadedException;
import edu.fiuba.algo3.loaders.QuestionLoader;

public class GameTest {

	private Game game;
	private Player jugadorUno;
	private Player jugadorDos;
	private List<Question> questions;

	/*
	 * Ver preguntas en archivo 'preguntas-test.json'
	 * */

	@BeforeEach
	public void setUp(){
		game = new Game();
		jugadorUno = new Player("Jugador uno");
		jugadorDos = new Player("Jugador dos");

		try {
			questions = QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_TEST_PATH);
		} catch (QuestionsNotLoadedException e) {
			fail();
		}

		game.setPlayers(Arrays.asList(jugadorUno, jugadorDos));
		game.setQuestions(questions);
		game.start();
	}

	 @Test
	 public void pasarDeTurnoCambiaElJugadorTest() {
		 assertEquals(jugadorUno, game.getCurrentPlayer());
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 assertEquals(jugadorDos, game.getCurrentPlayer());
	 }
	 
	 @Test
	 public void iniciarJuegoSeleccionaPreguntaInicialTest() {
		 game.start();
		 assertEquals(questions.get(0), game.getCurrentQuestion());
	 }
	 
	 @Test
	 public void iterarTodasLasPreguntasFinalizaElJuegoTest() {
		 List<Question> questions = new ArrayList<>();
		 questions.add(new TrueFalseQuestion("¿1 es mayor a 2?"));
		 questions.add(new TrueFalseQuestion("¿1 es mayor a 2?"));
		 game.setQuestions(questions);
		 game.start();
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 game.nextTurn(new ArrayList<GameOption>(), StringConstants.TWO_MULTIPLIER);
		 assertTrue(game.isOver());
	 }
	 
	 @Test
	 public void unJugadorConMasPuntajeQueElOtroResultaGanadorTest() {
		 Game game = new Game();		 
		 Player jugadorUno = Mockito.mock(Player.class);
		 Player jugadorDos = Mockito.mock(Player.class);
		 Mockito.when(jugadorUno.getScore()).thenReturn(new Score(100));
		 Mockito.when(jugadorDos.getScore()).thenReturn(new Score(50));
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

	@Test
	public void ambosJugadoresRespondenTodoMalYLosPuntajesSonMenosUnoTest(){
		while(!game.isOver()) game.nextTurn(new ArrayList(), null);

		for(Player player : game.getPlayers()){
			Assertions.assertEquals(new Score(-1), player.getScore());
		}
	}

	@Test
	public void ambosJugadoresRespondenTodoBienYLosPuntajesSonNueveTest(){
		while(!game.isOver())
			game.nextTurn(game.getCurrentQuestion().getCorrectOptions(), "");

		for(Player player : game.getPlayers()){
			Assertions.assertEquals(new Score(9), player.getScore());
		}
	}

	@Test
	public void ambosJugadoresAgotanSuExclusividadYNoGananPuntajeEnLasPrimerasDosPreguntasTest(){

		while(!game.isOver()){
			game.nextTurn(game.getCurrentQuestion().getCorrectOptions(), StringConstants.EXCLUSIVITY_MULTIPLIER);
		}

		for(Player player : game.getPlayers()){
			Assertions.assertEquals(new Score(6), player.getScore());
		}
	}

	@Test
	public void juegoCompletoSinMultiplicadoresTest(){

		List<List<GameOption>> respuestasJugador1 = Arrays.asList(
				Arrays.asList(new GameOption("3"), new GameOption("4")), // suma cero
				Arrays.asList(new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("1"), new GameOption("2")), // suma cero
				Arrays.asList(), // suma cero
				Arrays.asList(new GameOption("Verdadero")), // suma uno
				Arrays.asList(new GameOption("Falso")), // resta uno
				Arrays.asList() // suma cero
		);

		List<List<GameOption>> respuestasJugador2 = Arrays.asList(
				Arrays.asList(new GameOption("2"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("1"), new GameOption("2")), // suma cero
				Arrays.asList(new GameOption("1"), new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("Verdadero")), // suma uno
				Arrays.asList(new GameOption("Falso")), // resta uno
				Arrays.asList() // suma cero
		);

		Iterator<List<GameOption>> iterador1 = respuestasJugador1.iterator();
		Iterator<List<GameOption>> iterador2 = respuestasJugador2.iterator();

		while(!game.isOver()){
			if(game.getCurrentPlayer().equals(jugadorUno))
				game.nextTurn(iterador1.next(), null);
			else
				game.nextTurn(iterador2.next(), "");
		}

		Assertions.assertEquals(new Score(1), jugadorUno.getScore());
		Assertions.assertEquals(new Score(3), jugadorDos.getScore());
	}

	@Test
	public void juegoCompletoConMultiplicadoresTest(){

		List<List<GameOption>> respuestasJugador1 = Arrays.asList(
				Arrays.asList(new GameOption("3"), new GameOption("4")), // suma cero
				Arrays.asList(new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("1"), new GameOption("2")), // suma cero
				Arrays.asList(), // suma cero
				Arrays.asList(new GameOption("Verdadero")), // suma uno
				Arrays.asList(new GameOption("Falso")), // resta uno
				Arrays.asList() // suma cero
		);

		List<String> multiplicadoresJugador1 = Arrays.asList("", StringConstants.TWO_MULTIPLIER, "",
				StringConstants.EXCLUSIVITY_MULTIPLIER, StringConstants.TWO_MULTIPLIER, StringConstants.THREE_MULTIPLIER, "");

		List<List<GameOption>> respuestasJugador2 = Arrays.asList(
				Arrays.asList(new GameOption("2"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("1"), new GameOption("2")), // suma cero
				Arrays.asList(new GameOption("1"), new GameOption("2"), new GameOption("3"), new GameOption("4")), // suma uno
				Arrays.asList(new GameOption("Verdadero")), // suma uno
				Arrays.asList(new GameOption("Falso")), // resta uno
				Arrays.asList() // suma cero
		);

		List<String> multiplicadoresJugador2 = Arrays.asList(StringConstants.EXCLUSIVITY_MULTIPLIER, "", "",
				StringConstants.EXCLUSIVITY_MULTIPLIER, StringConstants.THREE_MULTIPLIER, StringConstants.TWO_MULTIPLIER, "");

		Iterator<List<GameOption>> iterador1 = respuestasJugador1.iterator();
		Iterator<List<GameOption>> iterador2 = respuestasJugador2.iterator();
		Iterator<String> multiplicadores1 = multiplicadoresJugador1.iterator();
		Iterator<String> multiplicadores2 = multiplicadoresJugador2.iterator();

		while(!game.isOver()){
			if(game.getCurrentPlayer().equals(jugadorUno))
				game.nextTurn(iterador1.next(), multiplicadores1.next());
			else
				game.nextTurn(iterador2.next(), multiplicadores2.next());
		}

		Assertions.assertEquals(new Score(0), jugadorUno.getScore());
		Assertions.assertEquals(new Score(6), jugadorDos.getScore());
	}
}
