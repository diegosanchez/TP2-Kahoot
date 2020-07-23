package edu.fiuba.algo3.resources;

import java.net.URL;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.exceptions.FileNotFoundException;
import edu.fiuba.algo3.exceptions.ViewNotFoundException;

public class ViewFinder {

	private static final String VIEW_PACKAGE = "view/";
	private static final String FXML_PREFIX = ".fxml";

	private ViewFinder() {}
	
	public static URL findView(String viewName) throws ViewNotFoundException {
		try {
			return ResourceFinder.findResource(VIEW_PACKAGE + viewName + FXML_PREFIX);
		} catch (FileNotFoundException e) {
			throw new ViewNotFoundException("View: " + viewName + " was not found in path: " + ViewFinder.getAbsoluteViewPath());
		}
		
	}
	
	public static URL getAbsoluteViewPath() {
		return App.class.getResource(VIEW_PACKAGE);
	}

}
