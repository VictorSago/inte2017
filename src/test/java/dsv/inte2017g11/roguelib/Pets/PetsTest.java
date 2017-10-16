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

    @Test
    public void nameTest(){
        assertEquals("Mushuu", pet.getName());
    }

    @Test
    public void newNameTest(){
        pet.newName("Toothless");
        assertEquals("Toothless", pet.getName());
    }

    @Test
    public void twoPetsTest(){
        Pets pet2 = new Pets("Kilgarrah", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
        assertEquals("Kilgarrah", pet2.getName());
        assertEquals("Mushuu", pet.getName());
    }

    @Test
    public void damageTest(){
        pet.takeDamage(10);
        assertEquals(DEFAULT_TEST_HEALTH-10, pet.getCurrentHealth());
    }

    @Test
    public void maxHealthTest(){
        assertEquals(pet.getCurrentHealth(), pet.getMaxHealth());
    }

    @Test
    public void healTest(){
        pet.takeDamage(10);
        pet.heal(5);
        assertEquals(DEFAULT_TEST_HEALTH-5, pet.getCurrentHealth());
    }

    @Test
    public void healOverMaxTest(){
        pet.heal(5);
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
    }

    @Test
    public void killTest(){
        pet.takeDamage(DEFAULT_TEST_HEALTH);
        assertEquals(0, pet.getCurrentHealth());
        assertFalse(pet.isAvailable());
    }

    @Test
    public void overKillTest(){
        pet.takeDamage(DEFAULT_TEST_HEALTH+10);
        assertEquals(0,pet.getCurrentHealth());
    }

    @Test
    public void healDeadPetTest(){
        pet.takeDamage(DEFAULT_TEST_HEALTH);
        pet.heal(10);
        assertEquals(0, pet.getCurrentHealth());
    }

    @Test
    public void reviveDeadPetTest(){
        pet.takeDamage(DEFAULT_TEST_HEALTH);
        pet.revive();
        assertTrue(pet.isAvailable());
        assertEquals(10,pet.getCurrentHealth());
    }

    @Test
    public void reviveWithFullHealthTest(){
        pet.takeDamage(DEFAULT_TEST_HEALTH);
        pet.phoenixDown();
        assertEquals(pet.getMaxHealth(),pet.getCurrentHealth());
        assertTrue(pet.isAvailable());
    }

    @Test
    public void levelUpTest(){
        pet.levelUp();
        assertEquals(DEFAULT_TEST_HEALTH+10,pet.getMaxHealth());
        assertEquals(2,pet.getLevel());
    }
}
