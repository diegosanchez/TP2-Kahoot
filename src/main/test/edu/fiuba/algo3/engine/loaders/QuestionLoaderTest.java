package edu.fiuba.algo3.engine.loaders;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.QuestionType;
import edu.fiuba.algo3.constants.ResourceConstants;
import edu.fiuba.algo3.loaders.QuestionLoader;
import edu.fiuba.algo3.model.Question;

public class QuestionLoaderTest {
	
	@Test
	public void cargarListaDePreguntasDePruebaYComprobarElNumeroDeElementos() {
		try {
			List<Question> lista = QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_TEST_PATH);
			assertEquals(7, lista.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void cargarListaDePreguntasYComprobarQueHayaUnaDeCadaTipo() {
		try {
			List<Question> lista = QuestionLoader.loadQuestions(ResourceConstants.QUESTIONS_TEST_PATH);
			for(QuestionType type : QuestionType.values()) {
				List<Question> listaPreguntas = lista.stream().filter(elem -> elem.getType().equals(type)).collect(Collectors.toList());
				assertEquals(1, listaPreguntas.size());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
