package edu.fiuba.algo3.display;

import java.io.InputStream;
import edu.fiuba.algo3.App;

public class ViewFinder {

	private static final String VIEW_PACKAGE = "/view/";
	private static final String FXML_PREFIX = ".fxml";

	public static InputStream findView(String viewName) {
		return App.class.getResourceAsStream(VIEW_PACKAGE + viewName + FXML_PREFIX);
	}

}
