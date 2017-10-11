package dsv.inte2017g11.roguelib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    GameMap m;

    @Before
    public void executeBeforeEachTest(){
        m = new GameMap(8);
    }

    @Test
    public void testCharacterName(){
        Character player = new Character("janedoe", m);
        assertEquals("janedoe", player.getName());
    }

    @Test
    public void testCharacterHealth(){
        Character player = new Character("janedoe", m);
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testCharacterAddHealth(){
        Character player = new Character("janedoe", m);
        player.hurtCharacter(22);
        assertEquals(78, player.getHealth());
        player.healCharacter(10);
        assertEquals(88, player.getHealth());
    }

    @Test
    public void testCharacterAdditionalHealthAddedOverMax(){
        Character player = new Character("janedoe", m);
        player.healCharacter(120);
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testCharacterRemoveHealth(){
        Character player = new Character("janedoe", m);
        player.hurtCharacter(12);
        assertEquals(88, player.getHealth());
    }

    @Test
    public void testCharacterGameOver(){
        Character player = new Character("janedoe", m);
        player.hurtCharacter(120);
        assertEquals(-1, player.getHealth());
    }

    @Test
    public void testCharacterSpeedValue(){
        Character player = new Character("janedoe", m);
        assertEquals(1,player.getSpeed());
    }

    @Test
    public void testCharacterSetNewSpeedValue(){
        Character player = new Character("janedoe", m);
        player.setSpeed(5);
        assertEquals(5, player.getSpeed());
    }

    @Test
    public void testCharacterPosition(){
        Character c = new Character("janedoe", m);
        Tile q = new Tile(0,0);
        assertEquals(true, q.equals(c.getPosition()));
    }


    @Test
    public void testCharacterValidMoveDown(){
        Character c = new Character("janedoe", m);
        Tile q = new Tile(0,1);
        c.moveDown();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCharacterInvalidMoveDown(){
        Character c = new Character("janedoe", m);
        c.setPosition(1,8);
        c.moveDown();

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCharacterMoveUpInvalidTile(){
        Character c = new Character("janedoe", m);
        c.moveUp();
    }

    @Test
    public void testCharacterValidMoveUp(){
        Character c = new Character("janedoe", m);
        c.setPosition(1,1);
        Tile q = new Tile(1,0);
        c.moveUp();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test
    public void testCharacterValidMoveRight(){
        Character c = new Character("janedoe", m);
        c.moveRight();
        Tile q = new Tile(1,0);
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCharacterInvalidMoveRight(){
        Character c = new Character("janedoe", m);
        c.setPosition(0,8);
        c.moveRight();
    }

    @Test
    public void testCharacterValidMoveLeft(){
        Character c = new Character("janedoe", m);
        c.setPosition(1,1);
        Tile q = new Tile(0,1);
        c.moveLeft();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testCharacterInvalidMoveLeft(){
        Character c = new Character("janedoe", m);
        c.moveLeft();
    }
}
