package edu.fiuba.algo3.loaders;

import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.exceptions.FileNotFoundException;
import edu.fiuba.algo3.exceptions.StylesheetLoadingException;
import edu.fiuba.algo3.resources.ResourceFinder;
import javafx.scene.Scene;

public class StylesheetLoader {
	
	private static final String CSS_EXTENSION = ".css";
	
	public static void loadStylesheet(Scene scene, String stylesheetName) throws StylesheetLoadingException {
		try {
			String stylesheetPath = ResourceFinder.findResource(ResourceConstants.STYLES_PATH + stylesheetName + CSS_EXTENSION).toExternalForm();
			scene.getStylesheets().add(stylesheetPath);
		} catch (FileNotFoundException e) {			
			throw new StylesheetLoadingException(e.getMessage());
		}
	}

}
