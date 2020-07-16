package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;

public class TrueFalseTest {
	
	@Test
	public void preguntaCorrectaSumaUnPuntoIncorrectaNoSumaNadaTest() {
		TrueFalseQuestion question = new TrueFalseQuestion();
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionFalse);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesElegidas.add(opcionFalse);
		
		assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
		listaOpcionesElegidas.clear();
		listaOpcionesElegidas.add(opcionTrue);
		assertEquals(0, question.calculatePoints(listaOpcionesElegidas));
	}
	
	@Test
	public void preguntaCorrectaSumaUnPuntoIncorrectaRestaTest() {
		TrueFalseWithPenaltyQuestion question = new TrueFalseWithPenaltyQuestion();
		
		GameOption opcionTrue = new GameOption("True");
		GameOption opcionFalse = new GameOption("False");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionFalse);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesElegidas.add(opcionFalse);
		
		assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
		listaOpcionesElegidas.clear();
		listaOpcionesElegidas.add(opcionTrue);
		assertEquals(-1, question.calculatePoints(listaOpcionesElegidas));
		
	}
	
}
