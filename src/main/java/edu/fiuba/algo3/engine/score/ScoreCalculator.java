package edu.fiuba.algo3.engine.score;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.model.MatchResult;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;
import edu.fiuba.algo3.model.Score;

public class ScoreCalculator {
	
	private ScoreCalculator() {}
	
	private static void calculate(List<Player> players) {
		players.stream().forEach(playerOne -> {
			players.stream().forEach(playerTwo -> {
				if(!playerOne.equals(playerTwo)) {
					playerOne.updateScore(playerTwo.getScore());
				}
			});
		});
	}

	public static void calculateAndAssignPoints(Player ... players){
		calculate(Arrays.asList(players));
	}

}
