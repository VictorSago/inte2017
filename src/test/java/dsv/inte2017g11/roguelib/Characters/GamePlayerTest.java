package dsv.inte2017g11.roguelib.Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GamePlayerTest {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;

    private GamePlayer player;

    @Before
    public void setUp() throws Exception {
        player = new GamePlayer("Jane Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
    }

    @Test
    public void creationTest() {
        assertEquals("Jane Doe", player.getName());
        assertEquals(DEFAULT_TEST_HEALTH, player.getMaxHealth());
        assertEquals(DEFAULT_TEST_HEALTH, player.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, player.getSpeed());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void creationWith1DefaultsTest() {
        int testHealth = 120;
        GamePlayer playerZoe = new GamePlayer("Zoe", testHealth);
        assertEquals("Zoe", playerZoe.getName());
        assertEquals(testHealth, playerZoe.getMaxHealth());
        assertTrue(playerZoe.getCurrentHealth() == playerZoe.getMaxHealth());
        assertEquals(AbstractCharacter.DEFAULT_SPEED, playerZoe.getSpeed());
        assertTrue(playerZoe.getStepsLeft() == playerZoe.getSpeed());
    }

    @Test
    public void creationWith2DefaultsTest() {
        GamePlayer playerJohn = new GamePlayer("John Doe");
        assertEquals("John Doe", playerJohn.getName());
        assertEquals(AbstractCharacter.DEFAULT_MAX_HEALTH, playerJohn.getMaxHealth());
        assertTrue(playerJohn.getCurrentHealth() == playerJohn.getMaxHealth());
        assertEquals(AbstractCharacter.DEFAULT_SPEED, playerJohn.getSpeed());
        assertTrue(playerJohn.getStepsLeft() == playerJohn.getSpeed());
    }

}
