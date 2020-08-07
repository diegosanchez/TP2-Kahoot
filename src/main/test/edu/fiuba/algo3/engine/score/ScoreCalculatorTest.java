package edu.fiuba.algo3.engine.score;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.engine.score.augmenters.ExclusivityMultiplier;
import edu.fiuba.algo3.engine.score.augmenters.ThreeMultiplier;
import edu.fiuba.algo3.model.Score;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Player;

public class ScoreCalculatorTest {
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");

		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		jugadorUno.answerQuestion(question, opcionJugadorUno);
		jugadorDos.answerQuestion(question, opcionJugadorDos);
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(1), jugadorDos.getScore());
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConMultiplicadorYTieneUnUsoMenosTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");

		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);

		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		jugadorUno.answerQuestion(question, opcionJugadorUno);
		jugadorDos.answerQuestionWithAugmenter(question, opcionJugadorDos, new ThreeMultiplier());
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(3), jugadorDos.getScore());
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYTieneUnUsoMenosTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");

		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);

		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		jugadorUno.answerQuestion(question, opcionJugadorUno);
		jugadorDos.answerQuestionWithAugmenter(question, opcionJugadorDos, new ExclusivityMultiplier());
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(2), jugadorDos.getScore());
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYAmbosContestanBienTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");

		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);

		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionFalse);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);

		jugadorUno.answerQuestionWithAugmenter(question, opcionJugadorUno, new ExclusivityMultiplier());
		jugadorDos.answerQuestionWithAugmenter(question, opcionJugadorDos, new ExclusivityMultiplier());
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(0), jugadorDos.getScore());
		assertEquals(1, jugadorUno.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}
	
	@Test
	public void calculoDePreguntaTrueFalseAsignaPuntosALosJugadoresConExclusividadYCuadriplicaElPuntajeTest() {		
		Player jugadorUno = new Player("JugadorUno");
		Player jugadorDos = new Player("JugadorDos");

		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);
		
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);
		
		question.setCorrectOption(opcionFalse);
		
		List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
		opcionJugadorUno.add(opcionTrue);
		List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
		opcionJugadorDos.add(opcionFalse);
		
		jugadorUno.answerQuestionWithAugmenter(question, opcionJugadorUno, new ExclusivityMultiplier());
		jugadorDos.answerQuestionWithAugmenter(question, opcionJugadorDos, new ExclusivityMultiplier());
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(4), jugadorDos.getScore());
		assertEquals(1, jugadorUno.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
	}

}
