package edu.fiuba.algo3.entregas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.model.Score;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.engine.score.AugmenterCalculator;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Player;

import java.util.ArrayList;
import java.util.List;

public class EntregaCeroTest {

	/***
	 * Una Pregunta de Verdadero/Falso clásico puede crearse indicándole cual es la respuesta correcta
	 */
	@Test
	public void preguntaCorrectaSumaUnPuntoIncorrectaNoSumaNadaTest() {
		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");

		listaOpciones.add(opcionTrue);
		listaOpciones.add(opcionFalse);

		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?", listaOpciones);
		
		question.setCorrectOption(opcionFalse);
		
		assertEquals(1, question.calculatePoints(opcionFalse));
		assertEquals(0, question.calculatePoints(opcionTrue));
	}
	
	/***
	 * Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna correctamente puntos a los jugadores que respondieron correctamente
	 */
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

		jugadorUno.answerQuestion(question, opcionTrue);
		jugadorDos.answerQuestion(question, opcionFalse);
		AugmenterCalculator.calculateAndAssignPoints(jugadorUno, jugadorDos);

		assertEquals(new Score(0), jugadorUno.getScore());
		assertEquals(new Score(1), jugadorDos.getScore());
	}
}
