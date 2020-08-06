package edu.fiuba.algo3.constants;

import static edu.fiuba.algo3.constants.Views.*;

public class QuestionViewType {

	public static String getView(QuestionType type) {
		switch (type){

			case MULTIPLE_CHOICE:
				return MULTIPLE_CHOICE_QUESTION_VIEW;

			case MULTIPLE_CHOICE_WITH_PENALTY:
				return MULTIPLE_CHOICE_QUESTION_VIEW;

			case MULTIPLE_CHOICE_PARTIAL:
				return MULTIPLE_CHOICE_QUESTION_VIEW;

			case TRUE_FALSE:
				return TRUE_FALSE_QUESTION_VIEW;

			case TRUE_FALSE_WITH_PENALTY:
				return TRUE_FALSE_QUESTION_VIEW;

			case ORDERED_QUESTION:
				return ORDERED_CHOICE_QUESTION_VIEW;

			case GROUP_CHOICE:
				return GROUP_CHOICE_QUESTION_VIEW;

			default:
				return ERROR_VIEW;
		}
	}
}
