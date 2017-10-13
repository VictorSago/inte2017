package dsv.inte2017g11.roguelib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameCharacterTest {

    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_SPEED = 10;

    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap(20, 10);
    }

    @Test
    public void nameTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        assertEquals("janedoe", player.getName());
    }

    @Test
    public void healthTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        assertEquals(100, player.getCurrentHealth());
    }

    @Test
    public void addHealthTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        player.hurtCharacter(22);
        assertEquals(78, player.getCurrentHealth());
        player.healCharacter(10);
        assertEquals(88, player.getCurrentHealth());
    }

    @Test
    public void additionalHealthAddedOverMaxTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        player.healCharacter(120);
        assertEquals(100, player.getCurrentHealth());
    }

    @Test
    public void removeHealthTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        player.hurtCharacter(12);
        assertEquals(88, player.getCurrentHealth());
    }

    @Test
    public void characterGameOverTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        player.hurtCharacter(120);
        assertEquals(-1, player.getCurrentHealth());
    }

    @Test
    public void speedTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        assertEquals(10, player.getSpeed());
    }

    @Test
    public void setNewSpeedTest() {
        GameCharacter player = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        player.setSpeed(5);
        assertEquals(5, player.getSpeed());
    }

/*
    @Test
    public void positionTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        Tile q = new Tile(0,0);
        assertEquals(true, q.equals(c.getPosition()));
    }
*/

    /*
    @Test
    public void validMoveDownTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        Tile q = new Tile(0,1);
        c.moveDown();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidMoveDownTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.setPosition(1,8);
        c.moveDown();

    }

    @Test
    public void validMoveUpTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.setPosition(1,1);
        Tile q = new Tile(1,0);
        c.moveUp();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidMoveUpTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.moveUp();
    }


    @Test
    public void validMoveRightTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.moveRight();
        Tile q = new Tile(1,0);
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidMoveRightTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.setPosition(0,8);
        c.moveRight();
    }

    @Test
    public void validMoveLeftTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.setPosition(1,1);
        Tile q = new Tile(0,1);
        c.moveLeft();
        assertEquals(true, q.equals(c.getPosition()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidMoveLeftTest() {
        GameCharacter c = new GameCharacter("janedoe", DEFAULT_HEALTH, DEFAULT_SPEED);
        c.moveLeft();
    }
    */
}
