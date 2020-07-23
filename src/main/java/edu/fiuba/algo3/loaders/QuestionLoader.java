package edu.fiuba.algo3.loaders;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import edu.fiuba.algo3.constants.QuestionType;
import edu.fiuba.algo3.exceptions.QuestionsNotLoadedException;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.resources.ResourceLoader;

public class QuestionLoader {
	
	private static final String TYPE = "type";
	private static final Gson gson = new Gson();
	
	private QuestionLoader() {}
	
	public static List<Question> loadQuestions(String questionsPath) throws QuestionsNotLoadedException{
		String questionJson;
		List<Question> questions = null;
		try {
			questionJson = ResourceLoader.loadTextFile(questionsPath);
			questions = parseToList(new Gson().fromJson(questionJson, List.class));
		} catch (Exception ex) {			
			throw new QuestionsNotLoadedException(ex.getMessage());
		}
		if(questions == null) {
			throw new QuestionsNotLoadedException("Questions couldn't be loaded");
		}
		return questions;
	}
	
	private static <K, V> List<Question> parseToList(List<LinkedTreeMap<K,V>> list){
		List<Question> questionList = new ArrayList<>();
		for(LinkedTreeMap<K,V> element : list) {
			String type = element.get(TYPE).toString();
			Question question = (Question) gson.fromJson(gson.toJson(element), QuestionType.valueOf(type).getQuestionClass());
			questionList.add(question);
		}
		return questionList;
	}	

}
