package edu.fiuba.algo3.resources;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewNotFoundException;

public class ViewFinderTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewFinderTest.class);
	
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
			logger.error("View not found", e);
			fail();
		}
	}

}
