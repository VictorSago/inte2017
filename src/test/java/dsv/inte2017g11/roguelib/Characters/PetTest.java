package dsv.inte2017g11.roguelib.Characters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetTest {

    private final int DEFAULT_TEST_HEALTH = 150;
    private final int DEFAULT_TEST_DAMAGE = 40;
    private final String DEFAULT_TEST_ELEMENT = "Fire";
    private Pet pet;

    @Before
    public void setUp() {
        pet = new Pet("Mushuu", DEFAULT_TEST_HEALTH, DEFAULT_TEST_DAMAGE, DEFAULT_TEST_ELEMENT) {};
    }

    @Test
    public void creationTest() {
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
        assertEquals(DEFAULT_TEST_DAMAGE, pet.getAttackValue());
    }

    @Test
    public void nameTest(){
        assertEquals("Mushuu", pet.getName());
    }

    @Test
    public void elementTest(){
        assertEquals("Fire", pet.getElement());
    }

    @Test
    public void newNameTest(){
        pet.newName("Toothless");
        assertEquals("Toothless", pet.getName());
    }

    @Test
    public void twoPetsTest(){
        Pet pet2 = new Pet("Kilgarrah", DEFAULT_TEST_HEALTH, DEFAULT_TEST_DAMAGE, DEFAULT_TEST_ELEMENT);
        assertEquals("Kilgarrah", pet2.getName());
        assertEquals("Mushuu", pet.getName());
    }

    @Test
    public void damageTest(){
        CombatSystem.takeDamage(10, DEFAULT_TEST_ELEMENT, pet);
        assertEquals(DEFAULT_TEST_HEALTH-10, pet.getCurrentHealth());
    }

    @Test
    public void calculateElementDamageSameElementFvFTest(){
        assertEquals(1, CombatSystem.calculateElementDamage(DEFAULT_TEST_ELEMENT, pet.getElement()), 0.0001);
    }

    @Test
    public void calculateElementDamageSameElementEvETest(){
        assertEquals(1, CombatSystem.calculateElementDamage("Earth", "Earth"), 0.0001);
    }

    @Test
    public void calculateElementDamageSameElementWvWTest(){
        assertEquals(1, CombatSystem.calculateElementDamage("Wind", "Wind"), 0.0001);
    }

    @Test
    public void calculateElementDamageDifferentElementWvFTest(){
        assertEquals(0.75, CombatSystem.calculateElementDamage("Wind", pet.getElement()),0.001);
    }

    @Test
    public void calculateElementDamageDifferentElementEvWTest(){
        assertEquals(0.75, CombatSystem.calculateElementDamage("Earth", "Wind"),0.001);
    }

    @Test
    public void calculateElementDamageDifferentElementEvFTest(){
        assertEquals(1.25, CombatSystem.calculateElementDamage("Earth", pet.getElement()),0.001);
    }

    @Test
    public void calculateElementDamageDifferentElementFvETest(){
        assertEquals(0.75, CombatSystem.calculateElementDamage("Fire", "Earth"),0.001);
    }

    @Test
    public void calculateElementDamageDifferentElementFvWTest(){
        assertEquals(1.25, CombatSystem.calculateElementDamage("Fire", "Wind"),0.001);
    }

    @Test
    public void calculateElementDamageDifferentElementWvETest(){
        assertEquals(1.25, CombatSystem.calculateElementDamage("Wind", "Earth"),0.001);
    }

    @Test
    public void maxHealthTest(){
        assertEquals(pet.getCurrentHealth(), pet.getMaxHealth());
    }

    @Test
    public void healTest(){
        CombatSystem.takeDamage(10,DEFAULT_TEST_ELEMENT, pet);
        CombatSystem.heal(5, pet);
        assertEquals(DEFAULT_TEST_HEALTH-5, pet.getCurrentHealth());
    }

    @Test
    public void healOverMaxTest(){
        CombatSystem.heal(5, pet);
        assertEquals(DEFAULT_TEST_HEALTH, pet.getCurrentHealth());
    }

    @Test
    public void damageNoElementTest(){
        AbstractCharacter gp = new GamePlayer("Jane Doe", DEFAULT_TEST_HEALTH);
        CombatSystem.takeDamage(10, DEFAULT_TEST_ELEMENT, gp);
        assertEquals(DEFAULT_TEST_HEALTH-10, gp.getCurrentHealth());
    }

    @Test
    public void killTest(){
        CombatSystem.takeDamage(DEFAULT_TEST_HEALTH, DEFAULT_TEST_ELEMENT, pet);
        assertEquals(0, pet.getCurrentHealth());
        assertFalse(pet.isAvailable());
    }

    @Test
    public void overKillTest(){
        CombatSystem.takeDamage(DEFAULT_TEST_HEALTH+10, DEFAULT_TEST_ELEMENT, pet);
        assertEquals(0,pet.getCurrentHealth());
    }

    @Test
    public void healDeadPetTest(){
        CombatSystem.takeDamage(DEFAULT_TEST_HEALTH, DEFAULT_TEST_ELEMENT, pet);
        CombatSystem.heal(10, pet);
        assertEquals(0, pet.getCurrentHealth());
    }

    @Test
    public void reviveDeadPetTest(){
        CombatSystem.takeDamage(DEFAULT_TEST_HEALTH, DEFAULT_TEST_ELEMENT, pet);
        CombatSystem.revive(pet);
        assertTrue(pet.isAvailable());
        assertEquals(10,pet.getCurrentHealth());
    }

    @Test
    public void reviveWithFullHealthTest(){
        CombatSystem.takeDamage(DEFAULT_TEST_HEALTH, DEFAULT_TEST_ELEMENT, pet);
        CombatSystem.phoenixDown(pet);
        assertEquals(pet.getMaxHealth(),pet.getCurrentHealth());
        assertTrue(pet.isAvailable());
    }

    @Test
    public void levelUpTest(){
        pet.levelUp();
        assertEquals(DEFAULT_TEST_HEALTH+10,pet.getMaxHealth());
        assertEquals(2,pet.getLevel());
        assertEquals(DEFAULT_TEST_DAMAGE+5,pet.getAttackValue());
    }

}
