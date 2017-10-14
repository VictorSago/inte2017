package dsv.inte2017g11.roguelib.Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameCharacterTest {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;

    private GameCharacter player;

    @Before
    public void setUp() {
        player = new GameCharacter("John Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
    }


    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
    }

    @Test
    public void creationWithDefaultSpeed() {
        GameCharacter playerJohn = new GameCharacter("John Doe", DEFAULT_TEST_HEALTH);
        assertEquals(DEFAULT_TEST_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(GameCharacter.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void creationWithDefaultParameters() {
        GameCharacter playerJohn = new GameCharacter("John Doe");
        assertEquals(GameCharacter.DEFAULT_MAX_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(GameCharacter.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void nameTest() {
        GameCharacter playerJane = new GameCharacter("janedoe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
        GameCharacter playerJohn = new GameCharacter("John Doe");
        assertEquals("janedoe", playerJane.getName());
        assertEquals("John Doe", playerJohn.getName());
    }

    @Test
    public void healthTest() {
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
        assertTrue(player.getCurrentHealth() == player.getMaxHealth());
    }

    @Test
    public void addHealthTest() {
        player.hurtCharacter(22);
        assertEquals(DEFAULT_TEST_HEALTH-22, player.getCurrentHealth());
        player.healCharacter(10);
        assertEquals(DEFAULT_TEST_HEALTH-12, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
    }

    @Test
    public void additionalHealthAddedOverMaxTest() {
        player.healCharacter(120);
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
    }

    @Test
    public void removeHealthTest() {
        player.hurtCharacter(12);
        assertEquals(DEFAULT_TEST_HEALTH-12, player.getCurrentHealth());
    }

    @Test
    public void characterGameOverTest() {
        player.hurtCharacter((DEFAULT_TEST_HEALTH+20));
        assertEquals(-1, player.getCurrentHealth());
    }

    @Test
    public void speedTest() {
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void setNewSpeedTest() {
        player.setSpeed(5);
        assertEquals(5, player.getSpeed());
        assertEquals(5, player.getStepsLeft());
    }

    @Test
    public void setZeroSpeedTest() {
        player.setSpeed(0);
        assertEquals(0, player.getSpeed());
        assertEquals(0, player.getStepsLeft());
    }

    @Test
    public void setNegativeSpeedTest() {
        player.setSpeed(-5);
        assertEquals(0, player.getSpeed());
        assertEquals(0, player.getStepsLeft());
    }


    @Test
    public void getMap() {
        assertNull(player.getMap());
    }

    @Test
    public void setPosition() {
        assertFalse(player.setPosition(3, 5));
    }


    @Test
    public void getPosition() throws Exception {
        assertEquals(0, player.getPosX());
        assertEquals(0, player.getPosY());
        assertTrue(player.getPosition() < 0);
    }

}
