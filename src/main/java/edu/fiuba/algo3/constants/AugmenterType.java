package edu.fiuba.algo3.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Score;

public enum AugmenterType {
	MULTIPLY_PER_TWO(TwoMultiplier.class, true, AugmenterUses.MULTIPLY_PER_TWO_USES),
	MULTIPLY_PER_THREE(ThreeMultiplier.class, true, AugmenterUses.MULTIPLY_PER_THREE_USES),
	EXCLUSIVITY(ExclusivityMultiplier.class, false, AugmenterUses.EXCLUSIVITY_USES),
	NO_MULTIPLIER(NoMultiplier.class, true, 1);

	private ScoreAugmenter scoreAugmenter;
	private boolean forPenaltyQuestions;
	private int usesPerPlayer;
	
	private Logger logger = LoggerFactory.getLogger(AugmenterType.class);
	
	AugmenterType(Class<? extends ScoreAugmenter> scoreAugmenterClass, boolean forPenaltyQuestions, int usesPerPlayer){
		try {
			this.scoreAugmenter = scoreAugmenterClass.getDeclaredConstructor().newInstance();
			this.forPenaltyQuestions = forPenaltyQuestions;
			this.usesPerPlayer = usesPerPlayer;
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
	
	public int getUsesPerPlayer() {
		return this.usesPerPlayer;
	}

	public void calculateForInstance(Score playerScore, Score opponentScore) {
		scoreAugmenter.applyScoreAugmenter(playerScore, opponentScore);
	}	
}
