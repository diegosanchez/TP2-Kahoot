package edu.fiuba.algo3.engine.score;

import java.util.List;

import edu.fiuba.algo3.model.MatchResult;

public class ScoreCalculator {
	
	private ScoreCalculator(){}
	
	public static void calculateRoundEndResults(List<MatchResult> matchResults) {
		calculateAugmenters(matchResults);
		sumMatchScore(matchResults);
	}
	
	private static void calculateAugmenters(List<MatchResult> matchResults) {
		matchResults.stream().forEach(result -> {
			result.applyScoreAugmenter(matchResults);
		});
	}
	
	private static void sumMatchScore(List<MatchResult> matchResults) {
		matchResults.stream().forEach(
			MatchResult::sumMatchScoreToPlayer
		);
	}

}
