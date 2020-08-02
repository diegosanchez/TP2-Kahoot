package edu.fiuba.algo3.entregas;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.engine.questions.*;
import edu.fiuba.algo3.engine.score.ScoreCalculator;
import edu.fiuba.algo3.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntregaDosTest {

    /***
     * Una Pregunta de Múltiple Choice con penalidad puede crearse indicándole cuales son las opciones correctas
     */
    @Test
    public void opcionesCorrectasEnMCconPenalidadSumaUnPuntoCadaUna() {
        MultipleChoiceWithPenaltyQuestion question = new MultipleChoiceWithPenaltyQuestion("¿Que numeros son impares?");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionTres = new GameOption("3");

        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionTres);

        question.setCorrectOptions(listaOpcionesCorrectas);

        List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
        listaOpcionesElegidas.add(opcionUno);
        listaOpcionesElegidas.add(opcionTres);

        assertEquals(2, question.calculatePoints(listaOpcionesElegidas));
    }

    /***
     * Una Pregunta de Group Choice puede crearse indicándole cuales son las opciones correctas
     */
    @Test
    public void opcionesCorrectasSumaUnPunto() {
        GroupChoiceQuestion question = new GroupChoiceQuestion("Agrupar las opciones según corresponda.");
        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();

        OptionGroup grupoPares = new OptionGroup("Pares");
        OptionGroup grupoImpares = new OptionGroup("Impares");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionDos = new GameOption("2");
        GameOption opcionTres = new GameOption("3");
        GameOption opcionCuatro = new GameOption("4");

        opcionDos.setOptionGroup(grupoPares);
        opcionCuatro.setOptionGroup(grupoPares);

        opcionUno.setOptionGroup(grupoImpares);
        opcionTres.setOptionGroup(grupoImpares);

        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcionTres);
        listaOpcionesCorrectas.add(opcionCuatro);

        question.setCorrectOptions(listaOpcionesCorrectas);

        List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();

        GameOption opcionElegidaUno = new GameOption("1");
        GameOption opcionElegidaDos = new GameOption("2");
        GameOption opcionElegidaTres = new GameOption("3");
        GameOption opcionElegidaCuatro = new GameOption("4");

        opcionElegidaUno.setOptionGroup(grupoImpares);
        opcionElegidaDos.setOptionGroup(grupoPares);
        opcionElegidaTres.setOptionGroup(grupoImpares);
        opcionElegidaCuatro.setOptionGroup(grupoPares);

        listaOpcionesElegidas.add(opcionElegidaUno);
        listaOpcionesElegidas.add(opcionElegidaDos);
        listaOpcionesElegidas.add(opcionElegidaTres);
        listaOpcionesElegidas.add(opcionElegidaCuatro);

        assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
    }

    /***
     * Una Pregunta de Ordered Choice puede crearse indicándole cuales son las opciones correctas
     */
    @Test
    public void opcionesEnOrdenCorrectoSumaUnPunto() {
        OrderedChoiceQuestion question = new OrderedChoiceQuestion("Ordenar los numeros de menor a mayor");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionDos = new GameOption("2");
        GameOption opcionTres = new GameOption("3");

        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcionTres);

        question.setCorrectOptions(listaOpcionesCorrectas);

        List<GameOption> listaOpcionesElegidas = new ArrayList<GameOption>();
        listaOpcionesElegidas.add(opcionUno);
        listaOpcionesElegidas.add(opcionDos);
        listaOpcionesElegidas.add(opcionTres);

        assertEquals(1, question.calculatePoints(listaOpcionesElegidas));
    }

    /***
     * Una Pregunta de Multiple Choice con penalidad recibe una lista de respuestas y asigna
     * correctamente puntos a los jugadores que respondieron correctamente
     */
    @Test
    public void calculoDePreguntaMultipleChoiceAsignaPuntosALosJugadoresTest() {
        Player jugadorUno = new Player("JugadorUno");
        Player jugadorDos = new Player("JugadorDos");

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("¿Que numeros son impares?");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionDos = new GameOption("2");
        GameOption opcionTres = new GameOption("3");

        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionTres);

        question.setCorrectOptions(listaOpcionesCorrectas);

        List<GameOption> opcionesJugadorUno = new ArrayList<GameOption>();
        opcionesJugadorUno.add(opcionUno);
        opcionesJugadorUno.add(opcionTres);

        List<GameOption> opcionesJugadorDos = new ArrayList<GameOption>();
        opcionesJugadorDos.add(opcionUno);
        opcionesJugadorDos.add(opcionDos);

        MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionesJugadorUno);
        MatchResult resultJugadorDos = jugadorDos.answerQuestion(opcionesJugadorDos);
        ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

        assertEquals(new Score(1), jugadorUno.getScore());
        assertEquals(new Score(0), jugadorDos.getScore());
    }

    /***
     * Una Pregunta de Group Choice recibe una lista de respuestas y asigna
     * correctamente puntos a los jugadores que respondieron en el orden correcto las opciones.
     */
    @Test
    public void calculoDePreguntaGroupChoiceAsignaPuntosALosJugadoresTest() {
        Player jugadorUno = new Player("JugadorUno");
        Player jugadorDos = new Player("JugadorDos");

        GroupChoiceQuestion question = new GroupChoiceQuestion("Agrupar las opciones según corresponda.");
        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();

        OptionGroup grupoPares = new OptionGroup("Pares");
        OptionGroup grupoImpares = new OptionGroup("Impares");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionDos = new GameOption("2");
        GameOption opcionTres = new GameOption("3");
        GameOption opcionCuatro = new GameOption("4");

        opcionDos.setOptionGroup(grupoPares);
        opcionCuatro.setOptionGroup(grupoPares);

        opcionUno.setOptionGroup(grupoImpares);
        opcionTres.setOptionGroup(grupoImpares);

        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcionTres);
        listaOpcionesCorrectas.add(opcionCuatro);

        question.setCorrectOptions(listaOpcionesCorrectas);

        //Opciones elegidas por Jugador 1
        List<GameOption> opcionesJugadorUno = new ArrayList<GameOption>();
        GameOption opcionElegidaJ1Uno = new GameOption("1");
        GameOption opcionElegidaJ1Dos = new GameOption("2");
        GameOption opcionElegidaJ1Tres = new GameOption("3");
        GameOption opcionElegidaJ1Cuatro = new GameOption("4");

        opcionElegidaJ1Uno.setOptionGroup(grupoImpares);
        opcionElegidaJ1Dos.setOptionGroup(grupoPares);
        opcionElegidaJ1Tres.setOptionGroup(grupoImpares);
        opcionElegidaJ1Cuatro.setOptionGroup(grupoPares);

        opcionesJugadorUno.add(opcionElegidaJ1Uno);
        opcionesJugadorUno.add(opcionElegidaJ1Dos);
        opcionesJugadorUno.add(opcionElegidaJ1Tres);
        opcionesJugadorUno.add(opcionElegidaJ1Cuatro);

        //Opciones elegidas por Jugador 2
        List<GameOption> opcionesJugadorDos = new ArrayList<GameOption>();
        GameOption opcionElegidaJ2Uno = new GameOption("1");
        GameOption opcionElegidaJ2Dos = new GameOption("2");
        GameOption opcionElegidaJ2Tres = new GameOption("3");
        GameOption opcionElegidaJ2Cuatro = new GameOption("4");

        opcionElegidaJ2Uno.setOptionGroup(grupoImpares);
        opcionElegidaJ2Dos.setOptionGroup(grupoPares);
        opcionElegidaJ2Tres.setOptionGroup(grupoPares);
        opcionElegidaJ2Cuatro.setOptionGroup(grupoPares);

        opcionesJugadorDos.add(opcionElegidaJ2Uno);
        opcionesJugadorDos.add(opcionElegidaJ2Dos);
        opcionesJugadorDos.add(opcionElegidaJ2Tres);
        opcionesJugadorDos.add(opcionElegidaJ2Cuatro);

        MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionesJugadorUno);
        MatchResult resultJugadorDos = jugadorDos.answerQuestion(opcionesJugadorDos);
        ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

        assertEquals(new Score(1), jugadorUno.getScore());
        assertEquals(new Score(0), jugadorDos.getScore());
    }

    /***
     * Una Pregunta de Ordered Choice recibe una lista de respuestas y asigna
     * correctamente puntos a los jugadores que respondieron en el orden correcto las opciones.
     */
    @Test
    public void calculoDePreguntaOrderedChoiceAsignaPuntosALosJugadoresTest() {
        Player jugadorUno = new Player("JugadorUno");
        Player jugadorDos = new Player("JugadorDos");

        OrderedChoiceQuestion question = new OrderedChoiceQuestion("Ordenar los numeros de menor a mayor");

        GameOption opcionUno = new GameOption("1");
        GameOption opcionDos = new GameOption("2");
        GameOption opcionTres = new GameOption("3");

        List<GameOption> listaOpcionesCorrectas = new ArrayList<GameOption>();
        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcionTres);

        question.setCorrectOptions(listaOpcionesCorrectas);

        List<GameOption> opcionesJugadorUno = new ArrayList<GameOption>();
        opcionesJugadorUno.add(opcionUno);
        opcionesJugadorUno.add(opcionDos);
        opcionesJugadorUno.add(opcionTres);

        List<GameOption> opcionesJugadorDos = new ArrayList<GameOption>();
        opcionesJugadorDos.add(opcionUno);
        opcionesJugadorDos.add(opcionTres);
        opcionesJugadorDos.add(opcionDos);

        MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionesJugadorUno);
        MatchResult resultJugadorDos = jugadorDos.answerQuestion(opcionesJugadorDos);
        ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

        assertEquals(new Score(1), jugadorUno.getScore());
        assertEquals(new Score(0), jugadorDos.getScore());
    }

    /***
     * Una Pregunta de Verdadero/Falso con Penalidad es contestada correctamente por jugador que utiliza
     * un multiplicador x2 y se asigna correctamente 2 veces el valor de la respuesta correcta.
     */

    @Test
    public void calculoDePreguntaTrueFalseAsignaPuntosAlJugadorConMultiplicadorx2YTieneUnUsoMenosTest() {
        Player jugadorUno = new Player("JugadorUno");
        Player jugadorDos = new Player("JugadorDos");
        jugadorDos.setNewAugmenter(AugmenterType.MULTIPLY_PER_TWO, 2);

        TrueFalseWithPenaltyQuestion question = new TrueFalseWithPenaltyQuestion("¿1 es mayor que 2?");

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        question.setCorrectOption(opcionFalse);

        List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
        opcionJugadorUno.add(opcionTrue);
        List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
        opcionJugadorDos.add(opcionFalse);

        MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionJugadorUno);
        MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.MULTIPLY_PER_TWO);
        ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

        assertEquals(new Score(-1), jugadorUno.getScore());
        assertEquals(new Score(2), jugadorDos.getScore());
        assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_TWO));
    }

    /***
     * Una Pregunta de Verdadero/Falso clasico es contestada correctamente por jugador que utiliza
     * un multiplicador x3 y se asigna correctamente 3 veces el valor de la respuesta correcta.
     */

    @Test
    public void calculoDePreguntaTrueFalseAsignaPuntosAlJugadorConMultiplicadorx3YTieneUnUsoMenosTest() {
        Player jugadorUno = new Player("JugadorUno");
        Player jugadorDos = new Player("JugadorDos");
        jugadorDos.setNewAugmenter(AugmenterType.MULTIPLY_PER_THREE, 2);

        TrueFalseWithPenaltyQuestion question = new TrueFalseWithPenaltyQuestion("¿1 es mayor que 2?");

        GameOption opcionTrue = new GameOption("True");
        GameOption opcionFalse = new GameOption("False");

        question.setCorrectOption(opcionFalse);

        List<GameOption> opcionJugadorUno = new ArrayList<GameOption>();
        opcionJugadorUno.add(opcionTrue);
        List<GameOption> opcionJugadorDos = new ArrayList<GameOption>();
        opcionJugadorDos.add(opcionFalse);

        MatchResult resultJugadorUno = jugadorUno.answerQuestion(opcionJugadorUno);
        MatchResult resultJugadorDos = jugadorDos.answerQuestionWithAugmenter(opcionJugadorDos, AugmenterType.MULTIPLY_PER_THREE);
        ScoreCalculator.calculateAndAssignPoints(question, resultJugadorUno, resultJugadorDos);

        assertEquals(new Score(-1), jugadorUno.getScore());
        assertEquals(new Score(3), jugadorDos.getScore());
        assertEquals(1, jugadorDos.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_THREE));
    }

}
