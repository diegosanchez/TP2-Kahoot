package edu.fiuba.algo3.resources;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.exceptions.ViewNotFoundException;

public class ViewFinderTest {
	
	@Test
	public void cargarUnaVistaInexistenteDebeTirarUnError() {
		assertThrows(ViewNotFoundException.class, () -> {
		    ViewFinder.findView("");
		});
	}

}
