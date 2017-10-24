package dsv.inte2017g11.roguelib.Engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {
	
	Engine e = new Engine("Anders",100,200);

	@Test
	public void newEngineTest() {
		assertNotNull(e);
	}
	
	@Test
	public void mapTest() {
		
		assertNotNull(e.getMap());
	}
	
	@Test
	public void mapTest2() {
	
		assertEquals(e.getMap(),e.getMap());
	}
	
	@Test
	public void getGamePlayer() {
		assertNotNull(e.getGamePlayer());
	}
	
	@Test
	public void getGamePlayer2() {
		assertEquals(e.getGamePlayer(),e.getGamePlayer());
	}
	
	@Test
	public void runBool() {
		assertNotNull(e.getRun());
	}
	
	

}
