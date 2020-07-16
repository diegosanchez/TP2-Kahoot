package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;

public class MultipleChoicePenaltyTest {
	
	@Test
	public void opcionesCorrectasSumaUnPuntoCadaUna() {
		MultipleChoiceWithPenaltyQuestion question = new MultipleChoiceWithPenaltyQuestion();
		
		GameOption opcionUno = new GameOption("1");
		GameOption opcionDos = new GameOption("2");
		GameOption opcionTres = new GameOption("3");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionDos);
		listaOpcionesCorrectas.add(opcionTres);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesElegidas.add(opcionUno);				
		listaOpcionesElegidas.add(opcionDos);
		listaOpcionesElegidas.add(opcionTres);
		
		assertEquals(3, question.calculatePoints(listaOpcionesElegidas));
	}
	
	@Test
	public void opcionIncorrectaRestaUnPunto() {
		MultipleChoiceWithPenaltyQuestion question = new MultipleChoiceWithPenaltyQuestion();
		
		GameOption opcionUno = new GameOption("1");
		GameOption opcionDos = new GameOption("2");
		GameOption opcionTres = new GameOption("3");
		GameOption opcionCuatro = new GameOption("4");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionDos);
		listaOpcionesCorrectas.add(opcionTres);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesElegidas.add(opcionCuatro);
		
		assertEquals(-1, question.calculatePoints(listaOpcionesElegidas));
	}

}
