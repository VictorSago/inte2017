package dsv.inte2017g11.roguelib.Misc;
import dsv.inte2017g11.roguelib.Characters.*;
import dsv.inte2017g11.roguelib.Maps.*;
import dsv.inte2017g11.roguelib.Misc.Combat;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {
	
	GameMap map = new GameMap(100,100);
	AbstractCharacter a1 = new Monster("Gargoyle",80,3,map);
	AbstractCharacter a2 = new Monster("Basilisk",120,2,map);

	@Test
	public void fightTest() {
		assertFalse(Combat.fight(a1, a2));
		assertEquals(0,a1.getCurrentHealth());
		
	}

}
