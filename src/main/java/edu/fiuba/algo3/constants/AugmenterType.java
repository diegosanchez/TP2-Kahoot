package edu.fiuba.algo3.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Score;

public enum AugmenterType {
	MULTIPLY_PER_TWO(TwoMultiplier.class, true),
	MULTIPLY_PER_THREE(ThreeMultiplier.class, true),
	EXCLUSIVITY(ExclusivityMultiplier.class, false),
	NO_MULTIPLIER(NoMultiplier.class, true);

	private ScoreAugmenter scoreAugmenter;
	private boolean forPenaltyQuestions;
	
	private Logger logger = LoggerFactory.getLogger(AugmenterType.class);
	
	AugmenterType(Class<? extends ScoreAugmenter> scoreAugmenterClass, boolean forPenaltyQuestions){
		try {
			this.scoreAugmenter = scoreAugmenterClass.getDeclaredConstructor().newInstance();
			this.forPenaltyQuestions = forPenaltyQuestions;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
	
	public ScoreAugmenter getInstance() {
		return this.scoreAugmenter;
	}

	public boolean isForPenaltyQuestions() {
		return forPenaltyQuestions;
	}

	public void calculateForInstance(Score playerScore, Score opponentScore) {
		scoreAugmenter.applyScoreAugmenter(playerScore, opponentScore);
	}
}
