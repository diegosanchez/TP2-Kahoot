package edu.fiuba.algo3;

import java.io.InputStream;

public class ViewFinder {
	
	private static final String VIEW_PACKAGE = "view/";
	private static final String FXML_PREFIX = ".fxml";

	public static InputStream findView(String viewName) {
		return ViewFinder.class.getResourceAsStream(VIEW_PACKAGE + viewName + FXML_PREFIX);
	}
	
}
