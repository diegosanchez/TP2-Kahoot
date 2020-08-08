package edu.fiuba.algo3.engine.score.augmenters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Score;

public class ScoreAugmenterTest {
	
	@Test
	public void multiplicarPorDosTest(){
		Score puntajeJugador = new Score(2);
		Score puntajeOponente = new Score(3);
		ScoreAugmenter aumentador = new TwoMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(4, puntajeJugador.getValue());
	}
	
	@Test
	public void multiplicarPorTresTest(){
		Score puntajeJugador = new Score(2);
		Score puntajeOponente = new Score(3);
		ScoreAugmenter aumentador = new ThreeMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(6, puntajeJugador.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalTest(){
		Score puntajeJugador = new Score(2);
		Score puntajeOponente = new Score( 0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(4, puntajeJugador.getValue());
		assertEquals(0, puntajeOponente.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteBienTest(){
		Score puntajeJugador = new Score(2);
		Score puntajeOponente = new Score(2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getValue());
		assertEquals(0, puntajeOponente.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteMalTest(){
		Score puntajeJugador = new Score(0);
		Score puntajeOponente = new Score(0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getValue());
		assertEquals(0, puntajeOponente.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienTest(){
		Score puntajeJugador = new Score( 0);
		Score puntajeOponente = new Score(2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		
		assertEquals(0, puntajeJugador.getValue());
		assertEquals(4, puntajeOponente.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienYAmbosUsaronExclusividadTest(){
		Score puntajeJugador = new Score(0);
		Score puntajeOponente = new Score(2);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(puntajeOponente, puntajeJugador);
		
		assertEquals(0, puntajeJugador.getValue());
		assertEquals(8, puntajeOponente.getValue());
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalYAmbosUsaronExclusividadTest(){
		Score puntajeJugador = new Score(2);
		Score puntajeOponente = new Score(0);
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(puntajeOponente, puntajeJugador);
		
		assertEquals(8, puntajeJugador.getValue());
		assertEquals(0, puntajeOponente.getValue());
	}
	


}
