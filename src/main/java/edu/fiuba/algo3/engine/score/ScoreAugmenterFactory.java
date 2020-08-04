package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScoreAugmenterFactory {

    public static ScoreAugmenter createScoreAugmenter(String text, Question question){
        ScoreAugmenter augmenter = new NoMultiplier();

        for(AugmenterType type : AugmenterType.values()){
            if(type.getLabelString().equals(text)){
                if(question.hasPenalty() == type.isForPenaltyQuestions())
                    augmenter = type.getScoreAugmenter();
                break;
            }
        }

        return augmenter;
    }

    public static ScoreAugmenter createScoreAugmenter(Player player, Question question, String text){
        ScoreAugmenter augmenter = new NoMultiplier();

        for(AugmenterType type : AugmenterType.values()){
            if(type.getLabelString().equals(text)){
                if(question.hasPenalty() == type.isForPenaltyQuestions() && player.getAugmentersUsesAvailable(type) > 0)
                    augmenter = type.getScoreAugmenter();
                    break;
            }
        }

        return augmenter;
    }
}
