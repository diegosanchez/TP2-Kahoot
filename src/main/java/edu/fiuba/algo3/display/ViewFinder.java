package edu.fiuba.algo3.display;

import java.net.URL;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.exceptions.ViewNotFoundException;

public class ViewFinder {

	private static final String VIEW_PACKAGE = "/view/";
	private static final String FXML_PREFIX = ".fxml";

	public static URL findView(String viewName) throws ViewNotFoundException {
		URL viewUrl = App.class.getResource(VIEW_PACKAGE + viewName + FXML_PREFIX);
		if(viewUrl == null) {
			throw new ViewNotFoundException("View: " + viewName + " was not found in path: " + ViewFinder.getAbsoluteViewPath());
		}
		return viewUrl;
	}
	
	public static URL getAbsoluteViewPath() {
		return App.class.getResource(VIEW_PACKAGE);
	}

}
