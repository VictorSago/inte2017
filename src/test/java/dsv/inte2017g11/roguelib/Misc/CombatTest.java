package dsv.inte2017g11.roguelib.Misc;
import dsv.inte2017g11.roguelib.Characters.*;
import dsv.inte2017g11.roguelib.Maps.*;
import dsv.inte2017g11.roguelib.Misc.Combat;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {
	
	private static final int NOSLEEP = 0;
	
	GameMap map = new GameMap(100,100);
	AbstractCharacter a1 = new Monster("Gargoyle",80,3,map);
	AbstractCharacter a2 = new Monster("Basilisk",120,2,map);
	AbstractCharacter a3 = new Monster("Gargoyle",80,3,map);

	@Test
	public void fightTest() {
		assertFalse(Combat.fight(a1, a2,NOSLEEP));
		assertEquals(0,a1.getCurrentHealth());
		
	}
	@Test
	public void fightTest2() {
		assertTrue(Combat.fight(a2, a1,NOSLEEP));
		assertEquals(0,a1.getCurrentHealth());
		
	}
	@Test
	public void fightTest3() {
		assertTrue(Combat.fight(a1, a3,NOSLEEP));
		assertEquals(0,a3.getCurrentHealth());
		
	}
	@Test
	public void fightTest4() {
		assertTrue(Combat.fight(a3, a1,NOSLEEP));
		assertEquals(0,a1.getCurrentHealth());
		
	}

}
