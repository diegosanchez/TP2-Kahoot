package edu.fiuba.algo3.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.Views;
import edu.fiuba.algo3.engine.questions.GroupChoiceQuestion;
import edu.fiuba.algo3.engine.questions.MultipleChoiceQuestion;
import edu.fiuba.algo3.engine.questions.OrderedChoiceQuestion;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.model.GameOption;

public class QuestionViewRouterTest {
	
	@Test
	public void traerViewDePreguntaPorTipoTest() {
		GroupChoiceQuestion groupChoiceQuestion = new GroupChoiceQuestion("Agrupar las opciones según corresponda.", new ArrayList<GameOption>());
		assertEquals(Views.GROUP_CHOICE_QUESTION_VIEW, QuestionViewRouter.getViewByQuestionType(groupChoiceQuestion.getType()));
		
		MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion("Agrupar las opciones según corresponda.", new ArrayList<GameOption>());
		assertEquals(Views.MULTIPLE_CHOICE_QUESTION_VIEW, QuestionViewRouter.getViewByQuestionType(multipleChoiceQuestion.getType()));
		
		TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion("Agrupar las opciones según corresponda.", new ArrayList<GameOption>());
		assertEquals(Views.TRUE_FALSE_QUESTION_VIEW, QuestionViewRouter.getViewByQuestionType(trueFalseQuestion.getType()));
		
		OrderedChoiceQuestion orderedChoiceQuestion = new OrderedChoiceQuestion("Agrupar las opciones según corresponda.", new ArrayList<GameOption>());
		assertEquals(Views.ORDERED_CHOICE_QUESTION_VIEW, QuestionViewRouter.getViewByQuestionType(orderedChoiceQuestion.getType()));
		
	}

}
