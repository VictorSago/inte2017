package dsv.inte2017g11.roguelib.Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTests {

    private final int DEFAULT_TEST_HEALTH = 200;
    private final int DEFAULT_TEST_SPEED = 10;

    private Monster m;
    private Monster m2;
    private FlyingMonster m3;

    @Before
    public void setUp() {
        m = new Monster("Unicorn", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20) {};
        m2 = new Monster("Fluff", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20) {};
        m3 = new FlyingMonster("Fluff", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED, 1, 20) {};

    }

    @Test
    public void creationTest() {
        assertEquals("Unicorn", m.getName());
        assertEquals(DEFAULT_TEST_HEALTH, m.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, m.getSpeed());
    }

    @Test
    public void attackTest() {
        m.attack(m2);
        assertEquals(180, m2.getCurrentHealth());
    }

    @Test
    public void flyTest() {
        assertEquals(true, m3.fly());
    }



}
