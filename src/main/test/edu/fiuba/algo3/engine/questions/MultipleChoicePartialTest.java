package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;

public class MultipleChoicePartialTest {
	
	@Test
	public void opcionesCorrectasSumaUnPuntoCadaUna() {
		MultipleChoicePartialQuestion question = new MultipleChoicePartialQuestion("¿Que numeros son impares?");
		GameOption opcionUno = new GameOption("1");
		GameOption opcionTres = new GameOption("3");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionTres);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesElegidas.add(opcionUno);	
		listaOpcionesElegidas.add(opcionTres);
		
		assertEquals(2, question.calculatePoints(listaOpcionesElegidas));
	}
	
	@Test
	public void opcionIncorrectaDevuelve0() {
		MultipleChoicePartialQuestion question = new MultipleChoicePartialQuestion("¿Que numeros son impares?");
		GameOption opcionUno = new GameOption("1");
		GameOption opcionTres = new GameOption("3");
		GameOption opcionCuatro = new GameOption("4");
		
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionTres);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesElegidas.add(opcionTres);
		listaOpcionesElegidas.add(opcionCuatro);
		
		assertEquals(0, question.calculatePoints(listaOpcionesElegidas));
	}

}
