package edu.fiuba.algo3.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fiuba.algo3.engine.score.augmenters.*;

public enum AugmenterType {
	MULTIPLY_PER_TWO(TwoMultiplier.class),
	MULTIPLY_PER_THREE(ThreeMultiplier.class),
	EXCLUSIVITY(ExclusivityMultiplier.class),
	NO_MULTIPLIER(NoMultiplier.class);

	private ScoreAugmenter scoreAugmenter;
	
	private Logger logger = LoggerFactory.getLogger(AugmenterType.class);
	
	AugmenterType(Class<? extends ScoreAugmenter> scoreAugmenterClass){
		try {
			this.scoreAugmenter = scoreAugmenterClass.getDeclaredConstructor().newInstance();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
	
	public ScoreAugmenter getScoreAugmenter() {
		return this.scoreAugmenter;
	}

}
