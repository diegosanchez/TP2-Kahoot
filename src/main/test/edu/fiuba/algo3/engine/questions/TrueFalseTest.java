package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;

public class TrueFalseTest {
	
	@Test
	public void preguntaCorrectaSumaUnPuntoIncorrectaNoSumaNadaTest() {
		TrueFalseQuestion question = new TrueFalseQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		assertEquals(1, question.calculatePoints(opcionFalse));
		assertEquals(0, question.calculatePoints(opcionTrue));
	}
	
	@Test
	public void preguntaCorrectaSumaUnPuntoIncorrectaRestaTest() {
		TrueFalseWithPenaltyQuestion question = new TrueFalseWithPenaltyQuestion("¿1 es mayor que 2?");
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		question.setCorrectOption(opcionFalse);
		
		assertEquals(1, question.calculatePoints(opcionFalse));
		assertEquals(-1, question.calculatePoints(opcionTrue));
		
	}
	
}
