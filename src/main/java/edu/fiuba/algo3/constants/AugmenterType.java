package edu.fiuba.algo3.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Score;

public enum AugmenterType {
	MULTIPLY_PER_TWO(TwoMultiplier.class, true, AugmenterUses.MULTIPLY_PER_TWO_USES, StringConstants.TWO_MULTIPLIER),
	MULTIPLY_PER_THREE(ThreeMultiplier.class, true, AugmenterUses.MULTIPLY_PER_THREE_USES, StringConstants.THREE_MULTIPLIER),
	EXCLUSIVITY(ExclusivityMultiplier.class, false, AugmenterUses.EXCLUSIVITY_USES, StringConstants.EXCLUSIVITY_MULTIPLIER);

	private ScoreAugmenter scoreAugmenter;
	private boolean forPenaltyQuestions;
	private int usesPerPlayer;
	private String labelString;
	
	private Logger logger = LoggerFactory.getLogger(AugmenterType.class);
	
	AugmenterType(Class<? extends ScoreAugmenter> scoreAugmenterClass, boolean forPenaltyQuestions,
				  int usesPerPlayer, String labelString){
		try {
			this.scoreAugmenter = scoreAugmenterClass.getDeclaredConstructor().newInstance();
			this.forPenaltyQuestions = forPenaltyQuestions;
			this.usesPerPlayer = usesPerPlayer;
			this.labelString = labelString;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
	
	public ScoreAugmenter getScoreAugmenter() {
		return this.scoreAugmenter;
	}

	public boolean isForPenaltyQuestions() {
		return forPenaltyQuestions;
	}

	public String getLabelString(){
		return labelString;
	}
	
	public int getUsesPerPlayer() {
		return this.usesPerPlayer;
	}

}
