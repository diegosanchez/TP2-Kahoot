package edu.fiuba.algo3.engine.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.OptionGroup;

public class GroupChoiceTest {
	
	@Test
	public void opcionesCorrectasSumaUnPunto() {
		GroupChoiceQuestion question = new GroupChoiceQuestion();
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		
		OptionGroup grupoPares = new OptionGroup("Pares");
		OptionGroup grupoImpares = new OptionGroup("Impares");
		
		GameOption opcionUno = new GameOption("1");
		GameOption opcionDos = new GameOption("2");
		GameOption opcionTres = new GameOption("3");
		GameOption opcionCuatro = new GameOption("4");
				
		grupoPares.addOption(opcionDos);
		grupoPares.addOption(opcionCuatro);
		
		grupoImpares.addOption(opcionUno);
		grupoImpares.addOption(opcionTres);
		
		listaOpcionesCorrectas.add(grupoPares);
		listaOpcionesCorrectas.add(grupoImpares);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		
		OptionGroup grupoParesElegidas = new OptionGroup("Pares");
		OptionGroup grupoImparesElegidas = new OptionGroup("Impares");
		
		grupoParesElegidas.addOption(opcionDos);
		grupoParesElegidas.addOption(opcionCuatro);
		
		grupoImparesElegidas.addOption(opcionUno);
		grupoImparesElegidas.addOption(opcionTres);
		
		listaOpcionesElegidas.add(grupoParesElegidas);
		listaOpcionesElegidas.add(grupoImparesElegidas);
		
		assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
	}

	@Test
	public void opcionesIncorrectasDevuelveCero() {
		GroupChoiceQuestion question = new GroupChoiceQuestion();
		List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
		
		OptionGroup grupoPares = new OptionGroup("Pares");
		OptionGroup grupoImpares = new OptionGroup("Impares");
		
		GameOption opcionUno = new GameOption("1");
		GameOption opcionDos = new GameOption("2");
		GameOption opcionTres = new GameOption("3");
		GameOption opcionCuatro = new GameOption("4");
				
		grupoPares.addOption(opcionDos);
		grupoPares.addOption(opcionCuatro);
		
		grupoImpares.addOption(opcionUno);
		grupoImpares.addOption(opcionTres);
		
		listaOpcionesCorrectas.add(grupoPares);
		listaOpcionesCorrectas.add(grupoImpares);
		
		question.setCorrectOptions(listaOpcionesCorrectas);
		
		List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
		
		OptionGroup grupoParesElegidas = new OptionGroup("Pares");
		OptionGroup grupoImparesElegidas = new OptionGroup("Impares");
		
		grupoParesElegidas.addOption(opcionUno);
		grupoParesElegidas.addOption(opcionCuatro);
		
		grupoImparesElegidas.addOption(opcionDos);
		grupoImparesElegidas.addOption(opcionTres);
		
		listaOpcionesElegidas.add(grupoParesElegidas);
		listaOpcionesElegidas.add(grupoImparesElegidas);
		
		assertEquals(0, question.calculatePoints(listaOpcionesElegidas));
	}

}
