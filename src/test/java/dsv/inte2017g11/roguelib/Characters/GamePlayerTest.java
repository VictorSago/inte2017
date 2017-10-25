package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Items.Effect;
import dsv.inte2017g11.roguelib.Items.*;
import dsv.inte2017g11.roguelib.Items.GearItem;
import dsv.inte2017g11.roguelib.Items.Item;
import dsv.inte2017g11.roguelib.Items.PotionItem;
import dsv.inte2017g11.roguelib.Maps.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GamePlayerTest {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;

    private GamePlayer player;
    private GameMap map = new GameMap(100,100);

    @Before
    public void setUp() throws Exception {
        player = new GamePlayer("Jane Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED,map);
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
        GamePlayer playerZoe = new GamePlayer("Zoe", testHealth,map);
        assertEquals("Zoe", playerZoe.getName());
        assertEquals(testHealth, playerZoe.getMaxHealth());
        assertTrue(playerZoe.getCurrentHealth() == playerZoe.getMaxHealth());
        assertEquals(AbstractCharacter.DEFAULT_SPEED, playerZoe.getSpeed());
        assertTrue(playerZoe.getStepsLeft() == playerZoe.getSpeed());
    }

    @Test
    public void creationWith2DefaultsTest() {
        GamePlayer playerJohn = new GamePlayer("John Doe",map);
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
        assertEquals(item2, player.getFromInventory("felix felicis"));
    }

    @Test
    public void testRemoveItemFromInventory(){
        Item item1 = new GearItem("Plain Helm", 2, 10, Effect.HEALTH);
        Item item2 = new PotionItem("Felix felicis", 15, Effect.HEALTH);
        player.addToInventory(item1);
        player.addToInventory(item2);
        player.throwItem("Plain Helm");
        assertEquals(1, player.getAmountOfItems());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWhenListIsEmpty(){
        assertEquals(0, player.getAmountOfItems());
        player.throwItem("nothing");
    }

    @Test
    public void testNoArmor(){
        assertEquals(0, player.getDefence());
    }

    @Test
    public void equipGearItem(){
        Item item1 = new GearItem("Plain Helm", 2, 10, Effect.HEALTH);
        Item item2 = new PotionItem("Felix felicis", 15, Effect.HEALTH);
        Item item3 = new GearItem("Shield", 9, 13, Effect.HEALTH);
        player.addToInventory(item1);
        player.addToInventory(item2);
        player.addToInventory(item3);
        player.equipItem("Shield");
        assertEquals(13, player.getDefence());
    }
    
    @Test
    public void printDecisionsTest(){
    	player.printDecisions();
    }
    
    @Test
    public void ticTest() {
    	assertTrue(player.tic(1));
    	assertTrue(player.tic(2));
    	assertTrue(player.tic(3));
    	assertTrue(player.tic(4));
    }
    
    @Test
    public void ticTestnegaTive() {
    	assertFalse(player.tic(-1));
    }
    @Test
    public void ticTest6() {
    	Item i = new WeaponItem("Fork",50,50);
    	GameMap gm = player.getMap();
    	gm.getTile(3, 3).addItem(i);
    	player.setPosition(3, 3);
    	assertEquals(0,player.getAmountOfItems());
    	player.tic(6);
    	assertEquals(1,player.getAmountOfItems());
    	
    }
    
    
    
}
