package edu.fiuba.algo3.loaders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.constants.Stylesheets;
import edu.fiuba.algo3.exceptions.StylesheetLoadingException;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class StylesheetLoaderTest {
	
	Logger logger = LoggerFactory.getLogger(StylesheetLoaderTest.class);
	
	@Test
	public void cargarUnaHojaDeEstilosInexistenteDebeTirarUnErrorTest() {
		assertThrows(StylesheetLoadingException.class, () -> {
		    StylesheetLoader.loadStylesheet(null, "test");
		});
	}
	
	@Test
	public void cargarUnaHojaDeEstilosExistenteDebeDevolverla() {
		Pane parent = new Pane();
		Scene scene = new Scene(parent);
		try {
			StylesheetLoader.loadStylesheet(scene, Stylesheets.QUESTIONS_CSS);
		} catch (StylesheetLoadingException e) {
			logger.error(e.getMessage(), e);
			fail();
		}
		assertEquals(1, scene.getStylesheets().size());
	}


}
