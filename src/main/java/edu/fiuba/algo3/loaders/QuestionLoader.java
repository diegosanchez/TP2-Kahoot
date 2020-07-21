package edu.fiuba.algo3.loaders;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import edu.fiuba.algo3.constants.QuestionType;
import edu.fiuba.algo3.exceptions.FileNotFoundException;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.resources.ResourceLoader;

public class QuestionLoader {
	
	private static final String TYPE = "type";
	private static final Gson gson = new Gson();
	
	public static List<Question> loadQuestions(String questionsPath) throws IOException, URISyntaxException, FileNotFoundException{
		String questionJson = ResourceLoader.loadTextFile(questionsPath);
		return parseToList(new Gson().fromJson(questionJson, List.class));		
	}
	
	private static <K, V> List<Question> parseToList(List<LinkedTreeMap<K,V>> list){
		List<Question> questionList = new ArrayList<Question>();
		for(LinkedTreeMap<K,V> element : list) {
			String type = element.get(TYPE).toString();
			Question question = (Question) gson.fromJson(gson.toJson(element), QuestionType.valueOf(type).getQuestionClass());
			questionList.add(question);
		}
		return questionList;
	}	

}
