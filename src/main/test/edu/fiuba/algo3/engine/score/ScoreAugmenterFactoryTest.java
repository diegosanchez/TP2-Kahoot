package edu.fiuba.algo3.engine.score;

import edu.fiuba.algo3.constants.StringConstants;
import edu.fiuba.algo3.engine.questions.TrueFalseQuestion;
import edu.fiuba.algo3.engine.questions.TrueFalseWithPenaltyQuestion;
import edu.fiuba.algo3.engine.score.augmenters.*;
import edu.fiuba.algo3.model.GameOption;
import edu.fiuba.algo3.model.Player;
import edu.fiuba.algo3.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreAugmenterFactoryTest {
    @Test
    public void aumentadorDobleParaPreguntaSinPenalidadDevuelveNullTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?", listaOpciones);
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.TWO_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDobleParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?", listaOpciones);
        TwoMultiplier multiplier = new TwoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.TWO_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorTripleParaPreguntaSinPenalidadDevuelveNullTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?", listaOpciones);
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.THREE_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorTripleParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?", listaOpciones);
        ThreeMultiplier multiplier = new ThreeMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.THREE_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDeExclusividadParaPreguntaConPenalidadDevuelveNullTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?", listaOpciones);
        NoMultiplier multiplier = new NoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.EXCLUSIVITY_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }

    @Test
    public void aumentadorDeExclusividadParaPreguntaSinPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?", listaOpciones);
        ExclusivityMultiplier multiplier = new ExclusivityMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(StringConstants.EXCLUSIVITY_MULTIPLIER, question);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorDobleConJugadorParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?", listaOpciones);
        Player player = new Player("Jugador");
        TwoMultiplier multiplier = new TwoMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.TWO_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorTripleConJugadorParaPreguntaConPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseWithPenaltyQuestion("Cuanto es dos mas dos?", listaOpciones);
        Player player = new Player("Jugador");
        ThreeMultiplier multiplier = new ThreeMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.THREE_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    @Test
    public void aumentadorExclusividadConJugadorParaPreguntaSinPenalidadSeInicializaCorrectamenteTest(){
        List<GameOption> listaOpciones = new ArrayList<GameOption>();

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        listaOpciones.add(opcionTrue);
        listaOpciones.add(opcionFalse);
        Question question = new TrueFalseQuestion("Cuanto es dos mas dos?", listaOpciones);
        Player player = new Player("Jugador");
        ExclusivityMultiplier multiplier = new ExclusivityMultiplier();

        ScoreAugmenter augmenter = ScoreAugmenterFactory.createScoreAugmenter(player, question, StringConstants.EXCLUSIVITY_MULTIPLIER);

        Assertions.assertEquals(multiplier.getAugmenterType(), augmenter.getAugmenterType());
    }
    
    

}
