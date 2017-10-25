package dsv.inte2017g11.roguelib.Entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetTest {

    private final int DEFAULT_TEST_HEALTH = 150;
    private final int DEFAULT_TEST_SPEED = 40;

    private Pet pet;

    @Before
    public void setUp() {
        pet = new Pet("Mushuu", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
    }

    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
        assertEquals(DEFAULT_TEST_SPEED, pet.getSpeed());
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
        Pet pet2 = new Pet("Kilgarrah", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED);
        assertEquals("Kilgarrah", pet2.getName());
        assertEquals("Mushuu", pet.getName());
    }

    @Test
    public void damageTest(){
        pet.damage(10);
        assertEquals(DEFAULT_TEST_HEALTH - 10, pet.getCurrentHealth());
    }

    @Test
    public void maxHealthTest(){
        assertEquals(pet.getCurrentHealth(), pet.getMaxHealth());
    }

    @Test
    public void healTest(){
        pet.damage(10);
        pet.heal(5);
        assertEquals(DEFAULT_TEST_HEALTH - 5, pet.getCurrentHealth());
    }

    @Test
    public void healOverMaxTest(){
        pet.heal(5);
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
    }

    @Test
    public void killTest(){
        pet.damage(DEFAULT_TEST_HEALTH);
        assertEquals(0, pet.getCurrentHealth());
        assertFalse(pet.isAlive());
    }

    @Test
    public void overKillTest(){
        pet.damage(DEFAULT_TEST_HEALTH+10);
        assertEquals(0, pet.getCurrentHealth());
    }

    @Test
    public void healDeadPetTest(){
        pet.damage(DEFAULT_TEST_HEALTH);
        pet.heal(10);
        assertEquals(0, pet.getCurrentHealth());
    }

    @Test
    public void reviveDeadPetTest(){
        pet.damage(DEFAULT_TEST_HEALTH);
        pet.revive();
        assertTrue(pet.isAlive());
        assertEquals(10, pet.getCurrentHealth());
    }

    @Test
    public void reviveWithFullHealthTest(){
        pet.damage(DEFAULT_TEST_HEALTH);
        pet.phoenixDown();
        assertEquals(pet.getMaxHealth(), pet.getCurrentHealth());
        assertTrue(pet.isAlive());
    }

    @Test
    public void levelUpTest(){
        pet.levelUp();
        assertEquals(DEFAULT_TEST_HEALTH + 10, pet.getMaxHealth());
        assertEquals(2, pet.getLevel());
    }

}
