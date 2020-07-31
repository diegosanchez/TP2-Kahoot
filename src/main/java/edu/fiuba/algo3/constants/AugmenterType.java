package edu.fiuba.algo3.constants;

import edu.fiuba.algo3.engine.score.augmenters.*;

public enum AugmenterType {
	MULTIPLY_PER_TWO(TwoMultiplier.class, true),
	MULTIPLY_PER_THREE(ThreeMultiplier.class, true),
	EXCLUSIVITY(ExclusivityMultiplier.class, false);
		
	private ScoreAugmenter scoreAugmenter;
	private boolean forPenaltyQuestions;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	AugmenterType(Class scoreAugmenterClass, boolean forPenaltyQuestions){
		try {
			this.scoreAugmenter = (ScoreAugmenter) scoreAugmenterClass.getDeclaredConstructor().newInstance();
			this.forPenaltyQuestions = forPenaltyQuestions;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ScoreAugmenter getInstance() {
		return this.scoreAugmenter;
	}

	public boolean isForPenaltyQuestions() {
		return forPenaltyQuestions;
	}
}
