package edu.fiuba.algo3.engine.loaders;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.exceptions.ViewLoadingException;
import edu.fiuba.algo3.loaders.SceneLoader;

public class SceneLoaderTest {

	@Test
	public void cargarUnaEscenaInexistenteDebeTirarUnError() {
		assertThrows(ViewLoadingException.class, () -> {
		    SceneLoader.loadScene(null, "");
		});
	}
	
}
