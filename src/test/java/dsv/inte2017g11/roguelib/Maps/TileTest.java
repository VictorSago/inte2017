package dsv.inte2017g11.roguelib.Maps;
import dsv.inte2017g11.roguelib.Characters.*;
import dsv.inte2017g11.roguelib.Items.*;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TileTest {
	Item i = new WeaponItem("Axe",30,30);
	Tile tile = new Tile();
	GameMap map = new GameMap(50,50);
	AbstractCharacter a1 = new Monster("Zombie",40,1,map);
	
	
	@Test
	public void newTileTest(){
		Tile t = new Tile();
		assertNotNull(t);
	}
	@Test
	public void newTileWithCharactersTest(){
		Tile t = new Tile(new ArrayList<AbstractCharacter>());
		assertNotNull(t);
	}
	@Test
	public void setItemTest(){
		tile.addItem(i);
		assertNotNull(tile.getItem());
	}
	@Test
	public void removeItemTest(){
		tile.addItem(i);
		assertNotNull(tile.getItem());
		tile.removeItem();
		assertNull(tile.getItem());
	}
	@Test
	public void setCharacterTest(){
		tile.addCharacter(a1);
		assertNotNull(tile.getCharacter());
	}
	@Test
	public void removeCharacterTest(){
		tile.addCharacter(a1);
		assertNotNull(tile.getCharacter());
		tile.removeCharacter();
		assertNull(tile.getCharacter());
	}
	
	@Test
	public void getCharacters(){
		assertNotNull(tile.getCharacters());
	}
	@Test
	public void getId(){
		assertNotNull(tile.getId());
	}
	@Test
	public void hashCodeTest(){
		int i = tile.getId();
		i = i*59;
		assertEquals(i,tile.hashCode());
	}
	@Test
	public void equalsTest(){
		Tile other = new Tile();
		assertFalse(other.equals(tile));
	}
	@Test
	public void equalsTest2(){
		String str = "lala";
		assertFalse(tile.equals(str));
	}
	@Test
	public void equalsTest3(){
		
		assertTrue(tile.equals(tile));
	}
	
	
}
