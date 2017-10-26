package dsv.inte2017g11.roguelib.Entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractEntityTest {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;

    private AbstractEntity player;

    @Before
    public void setUp() throws Exception {
        player = new AbstractEntity("John Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
    }


    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
    }

    @Test
    public void creationWithDefaultSpeed() {
        AbstractEntity playerJohn = new AbstractEntity("John Doe", DEFAULT_TEST_HEALTH) {};
        assertEquals(DEFAULT_TEST_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(AbstractEntity.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void creationWithDefaultParameters() {
        AbstractEntity playerJohn = new AbstractEntity("John Doe") {};
        assertEquals(AbstractEntity.DEFAULT_MAX_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(AbstractEntity.DEFAULT_SPEED, playerJohn.getSpeed());
    }

    @Test
    public void nameTest() {
        AbstractEntity playerJane = new AbstractEntity("janedoe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
        AbstractEntity playerJohn = new AbstractEntity("John Doe") {};
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
        player.damage(damage);
        assertEquals(DEFAULT_TEST_HEALTH - damage, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
        player.heal(heal);
        assertEquals(DEFAULT_TEST_HEALTH - (damage - heal), player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
    }

    @Test
    public void additionalHealthAddedOverMaxTest() {
        int heal = 120;
        player.heal(heal);
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
    }

    @Test
    public void removeHealthTest() {
        int damage = 12;
        player.damage(damage);
        assertEquals(DEFAULT_TEST_HEALTH - damage, player.getCurrentHealth());
    }

    @Test
    public void characterGameOverTest() {
        int damage = DEFAULT_TEST_HEALTH + 20;
        player.damage(damage);
        assertEquals(0, player.getCurrentHealth());
    }

    @Test
    public void speedTest() {
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsRemaining());
    }

    @Test
    public void setNewSpeedTest() {
        int testSpeed = 5;
        player.setSpeed(testSpeed);
        assertEquals(testSpeed, player.getSpeed());
        assertEquals(testSpeed, player.getStepsRemaining());
    }

    @Test
    public void setZeroSpeedTest() {
        player.setSpeed(0);
        assertEquals(0, player.getSpeed());
        assertEquals(0, player.getStepsRemaining());
    }

    @Test
    public void setNegativeSpeedTest() {
        int negativeSpeed = -5;
        player.setSpeed(negativeSpeed);
        assertEquals(0, player.getSpeed());
        assertEquals(0, player.getStepsRemaining());
    }


    @Test
    public void getMap() {
        assertNull(player.getMap());
    }

/*
    @Test
    public void setPosition() {
        assertFalse(player.setLocation(3, 5));
    }
*/

/*

    @Test
    public void getPosition() throws Exception {
        assertEquals(0, player.getPosX());
        assertEquals(0, player.getPosY());
//        assertTrue(player.getPosition() < 0);
    }
*/

}
