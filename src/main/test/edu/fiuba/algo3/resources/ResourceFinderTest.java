package edu.fiuba.algo3.resources;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.exceptions.FileNotFoundException;

public class ResourceFinderTest {

	@Test
	public void cargarUnaRecursoInexistenteDebeTirarUnError() {
		assertThrows(FileNotFoundException.class, () -> {
		    ResourceFinder.findResource("");
		});
	}
}
