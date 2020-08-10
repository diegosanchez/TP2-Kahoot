package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.OptionGroup;

public class GroupChoiceTest {
	
	@Test
	public void opcionesCorrectasSumaUnPunto() {
		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		OptionGroup grupoPares = new OptionGroup("Pares");
		OptionGroup grupoImpares = new OptionGroup("Impares");

		GameOption opcionUno = new GameOption("1", "Impares");
		GameOption opcionDos = new GameOption("2", "Pares");
		GameOption opcionTres = new GameOption("3", "Impares");
		GameOption opcionCuatro = new GameOption("4", "Impares");

		listaOpciones.add(opcionUno);
		listaOpciones.add(opcionDos);
		listaOpciones.add(opcionTres);
		listaOpciones.add(opcionCuatro);

		GroupChoiceQuestion question = new GroupChoiceQuestion("Agrupar las opciones según corresponda.", listaOpciones);

		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionDos);
		listaOpcionesCorrectas.add(opcionTres);
		listaOpcionesCorrectas.add(opcionCuatro);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();				
		
		GameOption opcionElegidaUno = new GameOption("1", "Impares");
		GameOption opcionElegidaDos = new GameOption("2", "Pares");
		GameOption opcionElegidaTres = new GameOption("3", "Impares");
		GameOption opcionElegidaCuatro = new GameOption("4", "Impares");
		
		listaOpcionesElegidas.add(opcionElegidaUno);
		listaOpcionesElegidas.add(opcionElegidaDos);
		listaOpcionesElegidas.add(opcionElegidaTres);
		listaOpcionesElegidas.add(opcionElegidaCuatro);		
		
		assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
	}

	@Test
	public void gruposDevueltosPorLaPreguntaSonIgualesALosCreados() {
		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		String grupoPares = "Pares";
		String grupoImpares = "Impares";

		GameOption opcionUno = new GameOption("1", "Impares");
		GameOption opcionDos = new GameOption("2", "Pares");
		GameOption opcionTres = new GameOption("3", "Impares");
		GameOption opcionCuatro = new GameOption("4", "Pares");

		listaOpciones.add(opcionUno);
		listaOpciones.add(opcionDos);
		listaOpciones.add(opcionTres);
		listaOpciones.add(opcionCuatro);

		GroupChoiceQuestion question = new GroupChoiceQuestion("Agrupar las opciones según corresponda.", listaOpciones);

		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionDos);
		listaOpcionesCorrectas.add(opcionTres);
		listaOpcionesCorrectas.add(opcionCuatro);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		assertTrue(question.getOptionGroupList().contains(grupoPares));
		assertTrue(question.getOptionGroupList().contains(grupoImpares));		
	}
	
	@Test
	public void opcionesIncorrectasDevuelveCero() {
		List<GameOption> listaOpciones = new ArrayList<GameOption>();

		String grupoPares = "Pares";
		String grupoImpares = "Impares";

		GameOption opcionUno = new GameOption("1", "Impares");
		GameOption opcionDos = new GameOption("2", "Pares");
		GameOption opcionTres = new GameOption("3", "Impares");
		GameOption opcionCuatro = new GameOption("4", "Pares");

		listaOpciones.add(opcionUno);
		listaOpciones.add(opcionDos);
		listaOpciones.add(opcionTres);
		listaOpciones.add(opcionCuatro);

		GroupChoiceQuestion question = new GroupChoiceQuestion("Agrupar las opciones según corresponda.", listaOpciones);
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();

		listaOpcionesCorrectas.add(opcionUno);
		listaOpcionesCorrectas.add(opcionDos);
		listaOpcionesCorrectas.add(opcionTres);
		listaOpcionesCorrectas.add(opcionCuatro);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();				
		
		GameOption opcionElegidaUno = new GameOption("1", "Impares");
		GameOption opcionElegidaDos = new GameOption("2", "Impares");
		GameOption opcionElegidaTres = new GameOption("3", "Impares");
		GameOption opcionElegidaCuatro = new GameOption("4", "Pares");
		
		listaOpcionesElegidas.add(opcionElegidaUno);
		listaOpcionesElegidas.add(opcionElegidaDos);
		listaOpcionesElegidas.add(opcionElegidaTres);
		listaOpcionesElegidas.add(opcionElegidaCuatro);
		
		assertEquals(0, question.calculatePoints(listaOpcionesElegidas));
	}

}
