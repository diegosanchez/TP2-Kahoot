package edu.fiuba.algo3.constants;

import edu.fiuba.algo3.engine.questions.*;
import edu.fiuba.algo3.model.Question;

public enum QuestionType {
	MULTIPLE_CHOICE(MultipleChoiceQuestion.class), 
	MULTIPLE_CHOICE_WITH_PENALTY(MultipleChoiceWithPenaltyQuestion.class), 
	MULTIPLE_CHOICE_PARTIAL(MultipleChoicePartialQuestion.class), 
	TRUE_FALSE(TrueFalseQuestion.class), 
	TRUE_FALSE_WITH_PENALTY(TrueFalseWithPenaltyQuestion.class), 
	ORDERED_QUESTION(OrderedChoiceQuestion.class), 
	GROUP_CHOICE(GroupChoiceQuestion.class);
	
	private Class<? extends Question> questionClass;
	
	QuestionType(Class<? extends Question> questionClass) {
		this.questionClass = questionClass;
	}

	public Class<? extends Question> getQuestionClass() {
		return questionClass;
	}
	
	
}
