package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;

import java.util.HashMap;

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

    public static ScoreAugmenter createScoreAugmenter(String text, Question question,
                       Player player){

        ScoreAugmenter augmenter = new NoMultiplier();

        if(text != null){
            switch(text){
                case StringConstants.TWO_MULTIPLIER:
                    if(question.hasPenalty() && player.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_TWO) > 0)
                        augmenter = new TwoMultiplier();
                    break;

                case StringConstants.THREE_MULTIPLIER:
                    if(question.hasPenalty() && player.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_THREE) > 0)
                        augmenter = new ThreeMultiplier();
                    break;

                case StringConstants.EXCLUSIVITY_MULTIPLIER:
                    if(!question.hasPenalty() && player.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY) > 0)
                        augmenter = new ExclusivityMultiplier();
            }
        }

        return augmenter;
    }
}
