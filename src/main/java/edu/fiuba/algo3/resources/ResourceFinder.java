package edu.fiuba.algo3.resources;

import java.net.URL;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.exceptions.FileNotFoundException;

public class ResourceFinder {

	public static URL findResource(String resourcePath) throws FileNotFoundException {
		URL viewUrl = App.class.getResource(ResourceConstants.RESOURCES_ROOT_PATH + resourcePath);
		if(viewUrl == null) {
			throw new FileNotFoundException("File: " + resourcePath + " was not found in path: " + ResourceFinder.getAbsolutePath());
		}
		return viewUrl;
	}
	
	public static URL getAbsolutePath() {
		return App.class.getResource(ResourceConstants.RESOURCES_ROOT_PATH);
	}
	
}
