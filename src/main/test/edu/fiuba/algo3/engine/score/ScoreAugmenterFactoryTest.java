package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.engine.questions.TrueFalseWithPenaltyQuestion;
import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreAugmenterFactoryTest {
    @Test
    public void aumentadorDobleParaPreguntaSinPenalidadDevuelveNullTest(){
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?");
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.TWO_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDobleParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?");
        TwoMultiplier multiplier = new TwoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.TWO_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorTripleParaPreguntaSinPenalidadDevuelveNullTest(){
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?");
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.THREE_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorTripleParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?");
        ThreeMultiplier multiplier = new ThreeMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.THREE_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDeExclusividadParaPreguntaConPenalidadDevuelveNullTest(){
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?");
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.EXCLUSIVITY_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDeExclusividadParaPreguntaSinPenalidadSeInicializaCorrectamenteTest(){
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?");
        ExclusivityMultiplier multiplier = new ExclusivityMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.EXCLUSIVITY_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorDobleConJugadorParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?");
        Player player = new Player("Jugador");
        TwoMultiplier multiplier = new TwoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.TWO_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorTripleConJugadorParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?");
        Player player = new Player("Jugador");
        ThreeMultiplier multiplier = new ThreeMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.THREE_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorExclusividadConJugadorParaPreguntaSinPenalidadSeInicializaCorrectamenteTest(){
    	Question question = new TrueFalseQuestion("Cuanto es dos mas dos?");
        Player player = new Player("Jugador");
        ExclusivityMultiplier multiplier = new ExclusivityMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.EXCLUSIVITY_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    

}
