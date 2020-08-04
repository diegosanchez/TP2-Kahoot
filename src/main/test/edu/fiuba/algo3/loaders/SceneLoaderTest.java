package edu.fiuba.algo3.loaders;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.exceptions.ViewLoadingException;

public class SceneLoaderTest {
	

	@Test
	public void cargarUnaEscenaInexistenteDebeTirarUnErrorTest() {
		assertThrows(ViewLoadingException.class, () -> {
		    SceneLoader.loadScene(null, "");
		});
	}
}
