package edu.fiuba.algo3.loaders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.exceptions.ViewLoadingException;
import javafx.stage.Stage;

public class SceneLoaderTest {
	

	@Test
	public void cargarUnaEscenaInexistenteDebeTirarUnErrorTest() {
		assertThrows(ViewLoadingException.class, () -> {
		    SceneLoader.loadScene(null, "");
		});
	}
}
