package edu.fiuba.algo3.engine.score.augmenters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Score;

public class ScoreAugmenterTest {
	
	@Test
	public void multiplicarPorDosTest(){
		Score puntajeJugador = new Score(0, 2);
		Score puntajeOponente = new Score(0, 3);
		ScoreAugmenter aumentador = new TwoMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(4, puntajeJugador.getQuestionScore());
	}
	
	@Test
	public void multiplicarPorTresTest(){
		Score puntajeJugador = new Score(0, 2);
		Score puntajeOponente = new Score(0, 3);
		ScoreAugmenter aumentador = new ThreeMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(6, puntajeJugador.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalTest(){
		Score puntajeJugador = new Score(0, 2);
		Score puntajeOponente = new Score( 0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(4, puntajeJugador.getQuestionScore());
		assertEquals(0, puntajeOponente.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteBienTest(){
		Score puntajeJugador = new Score(0, 2);
		Score puntajeOponente = new Score(0, 2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getQuestionScore());
		assertEquals(0, puntajeOponente.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteMalTest(){
		Score puntajeJugador = new Score(0);
		Score puntajeOponente = new Score(0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getQuestionScore());
		assertEquals(0, puntajeOponente.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienTest(){
		Score puntajeJugador = new Score( 0);
		Score puntajeOponente = new Score(0, 2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getQuestionScore());
		assertEquals(4, puntajeOponente.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienYAmbosUsaronExclusividadTest(){
		Score puntajeJugador = new Score(0);
		Score puntajeOponente = new Score(0, 2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(puntajeOponente, puntajeJugador);
		
		assertEquals(0, puntajeJugador.getQuestionScore());
		assertEquals(8, puntajeOponente.getQuestionScore());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalYAmbosUsaronExclusividadTest(){
		Score puntajeJugador = new Score(0, 2);
		Score puntajeOponente = new Score(0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(puntajeOponente, puntajeJugador);
		
		assertEquals(8, puntajeJugador.getQuestionScore());
		assertEquals(0, puntajeOponente.getQuestionScore());
	}
	


}
