package edu.fiuba.algo3.resources;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewNotFoundException;

public class ViewFinderTest {
	
	@Test
	public void cargarUnaVistaInexistenteDebeTirarUnErrorTest() {
		assertThrows(ViewNotFoundException.class, () -> {
		    ViewFinder.findView("");
		});
	}
	
	@Test
	public void cargarVistaPrincipalTest() {
		 try {
			assertNotNull(ViewFinder.findView(Views.MAIN_VIEW));
		} catch (ViewNotFoundException e) {
			e.printStackTrace();
		}
	}

}
