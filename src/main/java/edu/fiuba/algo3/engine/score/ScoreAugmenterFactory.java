package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Question;

public class ScoreAugmenterFactory {

    public static ScoreAugmenter createScoreAugmenter(String text, Question question){
        ScoreAugmenter augmenter = null;

        switch(text){
            case StringConstants.TWO_MULTIPLIER:
                if(question.hasPenalty()) augmenter = new TwoMultiplier();
                break;

            case StringConstants.THREE_MULTIPLIER:
                if(question.hasPenalty()) augmenter = new ThreeMultiplier();
                break;

            case StringConstants.EXCLUSIVITY_MULTIPLIER:
                if(!question.hasPenalty()) augmenter = new ExclusivityMultiplier();
        }

        return augmenter;
    }

    public static ScoreAugmenter createScoreAugmenter(String text, Question question, int exclusivityUses){
        ScoreAugmenter augmenter = new NoMultiplier();

        switch(text){
            case StringConstants.TWO_MULTIPLIER:
                if(question.hasPenalty()) augmenter = new TwoMultiplier();
                break;

            case StringConstants.THREE_MULTIPLIER:
                if(question.hasPenalty()) augmenter = new ThreeMultiplier();
                break;

            case StringConstants.EXCLUSIVITY_MULTIPLIER:
                if(!question.hasPenalty() && exclusivityUses > 0) augmenter = new ExclusivityMultiplier();
        }

        return augmenter;
    }
}
