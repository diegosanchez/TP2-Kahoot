package edu.fiuba.algo3.constants;

import edu.fiuba.algo3.engine.questions.*;

public enum QuestionType {
	MULTIPLE_CHOICE(MultipleChoiceQuestion.class), 
	MULTIPLE_CHOICE_WITH_PENALTY(MultipleChoiceWithPenaltyQuestion.class), 
	MULTIPLE_CHOICE_PARTIAL(MultipleChoicePartialQuestion.class), 
	TRUE_FALSE(TrueFalseQuestion.class), 
	TRUE_FALSE_WITH_PENALTY(TrueFalseWithPenaltyQuestion.class), 
	ORDERED_QUESTION(OrderedChoiceQuestion.class), 
	GROUP_CHOICE(GroupChoiceQuestion.class);
	
	private Class questionClass;
	
	QuestionType(Class questionClass) {
		this.setQuestionClass(questionClass);
	}

	public Class getQuestionClass() {
		return questionClass;
	}

	public void setQuestionClass(Class questionClass) {
		this.questionClass = questionClass;
	}
	
	
	
	
}
