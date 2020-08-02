package edu.fiuba.algo3.engine.score;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.model.Score;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.MatchResult;
import edu.fiuba.algo3.model.Player;

public class ScoreCalculatorTest {
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionJugadorUno);
		MatchResult resultJugadorDos = jugadorDos.answerQuestion(opcionJugadorDos);
		ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(1), jugadorDos.getScore());
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConMultiplicadorYTieneUnUsoMenosTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");
		jugadorDos.setNewAugmenter(AugmenterType.MULTIPLY_PER_THREE, 2);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionJugadorUno);
		MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.MULTIPLY_PER_THREE);
		ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(3), jugadorDos.getScore());
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_THREE));
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYTieneUnUsoMenosTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");
		jugadorDos.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionJugadorUno);
		MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.EXCLUSIVITY);
		ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(2), jugadorDos.getScore());
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYAmbosContestanBienTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");
		jugadorUno.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		jugadorDos.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionFalse);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		MatchResult resultJugadorUno = jugadorUno.answerQuestionWithAugmenter(opcionJugadorUno, AugmenterType.EXCLUSIVITY);
		MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.EXCLUSIVITY);
		ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(0), jugadorDos.getScore());
		assertEquals(1, jugadorUno.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYCuadriplicaElPuntajeTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");
		jugadorUno.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		jugadorDos.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);
		
		MatchResult resultJugadorUno = jugadorUno.answerQuestionWithAugmenter(opcionJugadorUno, AugmenterType.EXCLUSIVITY);
		MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.EXCLUSIVITY);
		ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(4), jugadorDos.getScore());
		assertEquals(1, jugadorUno.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}

}
