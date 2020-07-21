package edu.fiuba.algo3.resources;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import edu.fiuba.algo3.exceptions.FileNotFoundException;

public class ResourceLoader {

	public static String loadTextFile(String resourcePath) throws IOException, URISyntaxException, FileNotFoundException {
		return new String(Files.readAllBytes(Paths.get(ResourceFinder.findResource(resourcePath).toURI())));
	}
	
}
