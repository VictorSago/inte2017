package dsv.inte2017g11.roguelib;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_SPEED  = 10;

    private Character character;
    private GameMap testMap;

    @Before
    public void setUp() throws Exception {
        character = new Character("CharacterName", DEFAULT_HEALTH, DEFAULT_SPEED);
        testMap = new GameMap(50, 50);
        character.setMap(testMap);
    }

    @Test
    public void setPositionTest() {
        character.setPosition(10, 20);
        assertEquals(10, character.getPosX());
        assertEquals(20, character.getPosY());
    }

    @Test
    public void moveToTest() {
        character.setPosition(10, 20);
        character.move(25, 10);
        assertEquals(10+25, character.getPosX());
        assertEquals(20+10, character.getPosY());
    }
}
