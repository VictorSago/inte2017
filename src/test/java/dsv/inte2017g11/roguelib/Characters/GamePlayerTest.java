package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Items.Effect;
import dsv.inte2017g11.roguelib.Items.GearItem;
import dsv.inte2017g11.roguelib.Items.Item;
import dsv.inte2017g11.roguelib.Items.PotionItem;
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

    //@TODO Finish the test
    @Test
    public void addToInventoryTest() {
        Item item1 = new GearItem("Plain Helm", 2, 10, Effect.HEALTH);
        Item item2 = new PotionItem("Felix felicis", 15, Effect.HEALTH);
        player.addToInventory(item1);
        player.addToInventory(item2);
        assertEquals(2, player.getAmountOfItems());
    }

    @Test
    public void getItemFromInventory() {
        Item item1 = new GearItem("Plain Helm", 2, 10, Effect.HEALTH);
        Item item2 = new PotionItem("Felix felicis", 15, Effect.HEALTH);
        player.addToInventory(item1);
        player.addToInventory(item2);
        Item item3= item2;
        assertEquals(item3, player.getFromInventory("felix felicis"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNonExistingItemFromInventory() {
        Item item1 = new GearItem("Plain Helm", 2, 10, Effect.HEALTH);
        Item item2 = new PotionItem("Felix felicis", 15, Effect.HEALTH);
        player.addToInventory(item1);
        Item item3= item2;
        assertEquals(item2, player.getFromInventory("felix felicis"));
    }
}
