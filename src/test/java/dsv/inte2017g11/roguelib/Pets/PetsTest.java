package dsv.inte2017g11.roguelib.Pets;

import dsv.inte2017g11.roguelib.Pets.Pets;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetsTest {

    private final int DEFAULT_TEST_HEALTH = 150;
    private final int DEFAULT_TEST_SPEED = 40;

    private Pets pet;

    @Before
    public void setUp() {
        pet = new Pets("Mushuu", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
    }


    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, pet.getCurrentSpeed());
    }
}
