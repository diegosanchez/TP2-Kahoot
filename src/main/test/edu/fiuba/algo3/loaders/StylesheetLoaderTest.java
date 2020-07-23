package edu.fiuba.algo3.loaders;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.exceptions.StylesheetLoadingException;

public class StylesheetLoaderTest {
	
	@Test
	public void cargarUnaHojaDeEstilosInexistenteDebeTirarUnErrorTest() {
		assertThrows(StylesheetLoadingException.class, () -> {
		    StylesheetLoader.loadStylesheet(null, "test");
		});
	}

}
