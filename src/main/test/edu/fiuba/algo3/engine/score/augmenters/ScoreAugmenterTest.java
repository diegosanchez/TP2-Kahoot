package edu.fiuba.algo3.engine.score.augmenters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.constants.AugmenterType;
import edu.fiuba.algo3.model.Player;

public class ScoreAugmenterTest {
	
	@Test
	public void multiplicarPorDosTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.MULTIPLY_PER_TWO, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		int puntajeJugador = 2;
		int puntajeOponente = 3;
		ScoreAugmenter aumentador = new TwoMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(8, jugador.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_TWO));
	}
	
	@Test
	public void multiplicarPorTresTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.MULTIPLY_PER_THREE, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		int puntajeJugador = 2;
		int puntajeOponente = 3;
		ScoreAugmenter aumentador = new ThreeMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(10, jugador.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.MULTIPLY_PER_THREE));
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 2;
		int puntajeOponente = 0;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(8, jugador.getScore());
		assertEquals(6, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
				
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteBienTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 2;
		int puntajeOponente = 2;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(4, jugador.getScore());
		assertEquals(6, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
			
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteMalTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 0;
		int puntajeOponente = 0;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(4, jugador.getScore());
		assertEquals(6, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
			
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 0;
		int puntajeOponente = 2;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		
		assertEquals(4, jugador.getScore());
		assertEquals(10, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));	
	}
	
	@Test
	public void exclusividadJugadorContestaMalYOponenteBienYAmbosUsaronExclusividadTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");		
		oponente.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 0;
		int puntajeOponente = 2;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(oponente, jugador, puntajeOponente, puntajeJugador);
		
		assertEquals(4, jugador.getScore());
		assertEquals(14, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, oponente.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
			
	}
	
	@Test
	public void exclusividadJugadorContestaBienYOponenteMalYAmbosUsaronExclusividadTest(){
		Player jugador = new Player("jugador 1");
		jugador.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		Player oponente = new Player("jugador 2");		
		oponente.setNewAugmenter(AugmenterType.EXCLUSIVITY, 2);
		jugador.setScore(4);
		oponente.setScore(6);
		int puntajeJugador = 3;
		int puntajeOponente = 0;
		ScoreAugmenter aumentador = new ExclusivityMultiplier();
		aumentador.applyScoreAugmenter(jugador, oponente, puntajeJugador, puntajeOponente);
		aumentador.applyScoreAugmenter(oponente, jugador, puntajeOponente, puntajeJugador);
		
		assertEquals(16, jugador.getScore());
		assertEquals(6, oponente.getScore());
		assertEquals(1, jugador.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));
		assertEquals(1, oponente.getAugmentersUsesAvailable(AugmenterType.EXCLUSIVITY));		
	}
	


}
