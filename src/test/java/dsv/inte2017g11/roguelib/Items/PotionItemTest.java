package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PotionItemTest {

	@SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void createWithNoNamePotionTest() {
        PotionItem p = new PotionItem("", 0, HEALTH);
    }

	@SuppressWarnings("unused")
    @Test(expected = NullPointerException.class)
    public void createWithNullNamePotionTest() {
        PotionItem p = new PotionItem(null, 0, HEALTH);
    }

    @Test
    public void createPotionItemTest() {
        PotionItem p = new PotionItem("poison", 0, HEALTH);
        assertEquals("poison", p.getName());
    }

    @Test
    public void createPotionWithDescriptionTest() {
        PotionItem p = new PotionItem("poison", 0, HEALTH, "a black bubbling mud-like fluid");
        assertEquals("a black bubbling mud-like fluid", p.getDescription());
    }

    @Test
    public void createWithoutDescriptionGetInfoTest() {
        PotionItem p = new PotionItem("poison", 0, HEALTH);
        assertEquals("no description available", p.getDescription());
    }

    @Test
    public void createPotionWithNullDescriptionTest() {
        PotionItem p = new PotionItem("poison", 0, HEALTH, null);
        assertEquals("no description available", p.getDescription());
    }

    @Test
    public void potionGetPositivePowerTest() {
        PotionItem p = new PotionItem("poison", 10, HEALTH);
        assertEquals(10, p.getPower());
    }

    @Test
    public void potionGetNegativePowerTest() {
        PotionItem p = new PotionItem("poison", -10, HEALTH);
        assertEquals(-10, p.getPower());
    }

    @Test
    public void potionGetEffectTest() {
        PotionItem p = new PotionItem("poison", -10, HEALTH);
        assertEquals(HEALTH, p.getEffect());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidPotionWithoutEffectTest() {
        PotionItem p = new PotionItem("poison", 10, null);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidDescribedPotionWithoutEffectTest() {
        PotionItem p = new PotionItem("poison", 10, null, "bad potion construction");
    }

    @Test
    public void potionItemEqualsMethodValidTest(){
	    PotionItem p = new PotionItem("poison", 10, HEALTH, "bad potion construction");
        PotionItem q = p;
        assertEquals(true, p.equals(q));
    }

    @Test
    public void potionItemEqualsMethodInvalidNameTest(){
        PotionItem p = new PotionItem("poison", 10, HEALTH, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

    @Test
    public void potionItemEqualsMethodInvalidPowerTest(){
        PotionItem p = new PotionItem("felix felicis", -10, HEALTH, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

    @Test
    public void potionItemEqualsMethodInvalidEffectTest(){
        PotionItem p = new PotionItem("felix felicis", 10, MAGIC, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

    @Test
    public void potionItemEqualsMethodInvalidClassTest(){
        PotionItem p = new PotionItem("felix felicis", 10, MAGIC, "bad potion construction");
        WeaponItem w = new WeaponItem("sword", 3, 15);
//        assertEquals(false, p.equals(w));
        assertThat(p, not(equalTo(w)));
    }

}
