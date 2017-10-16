package dsv.inte2017g11.roguelib.Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractCharacterTest {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;

    private AbstractCharacter player;

    @Before
    public void setUp() throws Exception {
        player = new AbstractCharacter("John Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
    }


    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
    }

    @Test
    public void creationWithDefaultSpeed() {
        AbstractCharacter playerJohn = new AbstractCharacter("John Doe", DEFAULT_TEST_HEALTH) {};
        assertEquals(DEFAULT_TEST_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(AbstractCharacter.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void creationWithDefaultParameters() {
        AbstractCharacter playerJohn = new AbstractCharacter("John Doe") {};
        assertEquals(AbstractCharacter.DEFAULT_MAX_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(AbstractCharacter.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void nameTest() {
        AbstractCharacter playerJane = new AbstractCharacter("janedoe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
        AbstractCharacter playerJohn = new AbstractCharacter("John Doe") {};
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
        int damage = 22;
        int heal = 10;
        player.hurtCharacter(damage);
        assertEquals(DEFAULT_TEST_HEALTH - damage, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
        player.healCharacter(heal);
        assertEquals(DEFAULT_TEST_HEALTH - (damage - heal), player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
    }

    @Test
    public void additionalHealthAddedOverMaxTest() {
        int heal = 120;
        player.healCharacter(heal);
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
    }

    @Test
    public void removeHealthTest() {
        int damage = 12;
        player.hurtCharacter(damage);
        assertEquals(DEFAULT_TEST_HEALTH - damage, player.getCurrentHealth());
    }

    @Test
    public void characterGameOverTest() {
        int damage = DEFAULT_TEST_HEALTH + 20;
        player.hurtCharacter(damage);
        assertEquals(-1, player.getCurrentHealth());
    }

    @Test
    public void speedTest() {
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void setNewSpeedTest() {
        int testSpeed = 5;
        player.setSpeed(testSpeed);
        assertEquals(testSpeed, player.getSpeed());
        assertEquals(testSpeed, player.getStepsLeft());
    }

    @Test
    public void setZeroSpeedTest() {
        player.setSpeed(0);
        assertEquals(0, player.getSpeed());
        assertEquals(0, player.getStepsLeft());
    }

    @Test
    public void setNegativeSpeedTest() {
        int negativeSpeed = -5;
        player.setSpeed(negativeSpeed);
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
