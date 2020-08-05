package edu.fiuba.algo3.resources;

import edu.fiuba.algo3.constants.QuestionType;
import edu.fiuba.algo3.constants.Views;

public class QuestionViewRouter {
	
	private QuestionViewRouter() {}
	
	public static String getViewByQuestionType(QuestionType questionType) {
		
		switch(questionType) {
			case MULTIPLE_CHOICE:  
			case MULTIPLE_CHOICE_WITH_PENALTY:
			case MULTIPLE_CHOICE_PARTIAL:
				return Views.MULTIPLE_CHOICE_QUESTION_VIEW;
			case TRUE_FALSE:
			case TRUE_FALSE_WITH_PENALTY:
				return Views.TRUE_FALSE_QUESTION_VIEW;
			case ORDERED_QUESTION:
				return Views.ORDERED_CHOICE_QUESTION_VIEW;
			case GROUP_CHOICE:
				return Views.GROUP_CHOICE_QUESTION_VIEW;
			default:
				return Views.ERROR_VIEW;
		}
	}

}
