package dsv.inte2017g11.roguelib.Characters;
import dsv.inte2017g11.roguelib.Maps.Tile;
import dsv.inte2017g11.roguelib.Maps.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MonsterTests {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 20;
    private GameMap map = new GameMap(100,100);

    private Monster m;
    private Monster m2;
    private FlyingMonster m3;



    @Before
    public void setUp() {
        m = new Monster("Unicorn", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20,map) {};
        m2 = new Monster("Fluff", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20,map) {};
        m3 = new FlyingMonster("Fluff", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20,map) {};

    }

    @Test
    public void creationTest() {
        assertEquals("Unicorn", m.getName());
        assertEquals(DEFAULT_TEST_HEALTH, m.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, m.getSpeed());
    }

    @Test
    public void typeTest() {
        assertEquals(1, m.getType());
    }

    @Test
    public void attackTest() {
        ArrayList<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
        characters.add(m);characters.add(m2);
        Tile t = new Tile(1, characters);

        m.attack(t);
        assertEquals(180, m2.getCurrentHealth());
    }

    @Test
    public void flyTest() {
        assertEquals(true, m3.fly());
    }



}
