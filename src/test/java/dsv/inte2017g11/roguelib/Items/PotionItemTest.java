package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;
import static org.junit.Assert.assertEquals;

public class PotionItemTest {

	@SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNoNamePotion() {
        PotionItem p = new PotionItem("", 0, HEALTH);
    }

	@SuppressWarnings("unused")
    @Test(expected = NullPointerException.class)
    public void testCreateWithNullNamePotion() {
        PotionItem p = new PotionItem(null, 0, HEALTH);
    }

    @Test
    public void testCreatePotionItem() {
        PotionItem p = new PotionItem("poison", 0, HEALTH);
        assertEquals("poison", p.getName());
    }

    @Test
    public void testCreatePotionWithDescription() {
        PotionItem p = new PotionItem("poison", 0, HEALTH, "a black bubbling mud-like fluid");
        assertEquals("a black bubbling mud-like fluid", p.getDescription());
    }

    @Test
    public void testCreateWithoutDescriptionGetInfo() {
        PotionItem p = new PotionItem("poison", 0, HEALTH);
        assertEquals("no description available", p.getDescription());
    }

    @Test
    public void testCreatePotionWithNullDescription() {
        PotionItem p = new PotionItem("poison", 0, HEALTH, null);
        assertEquals("no description available", p.getDescription());
    }

    @Test
    public void testPotionGetPositivePower() {
        PotionItem p = new PotionItem("poison", 10, HEALTH);
        assertEquals(10, p.getPower());
    }

    @Test
    public void testPotionGetNegativePower() {
        PotionItem p = new PotionItem("poison", -10, HEALTH);
        assertEquals(-10, p.getPower());
    }

    @Test
    public void testPotionGetEffect() {
        PotionItem p = new PotionItem("poison", -10, HEALTH);
        assertEquals(HEALTH, p.getEffect());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPotionWithoutEffect() {
        PotionItem p = new PotionItem("poison", 10, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDescribedPotionWithoutEffect() {
        PotionItem p = new PotionItem("poison", 10, null, "bad potion construction");
    }

    @Test
    public void testPotionItemEqualsMethodValid(){
	    PotionItem p = new PotionItem("poison", 10, HEALTH, "bad potion construction");
        PotionItem q = p;
        assertEquals(true, p.equals(q));
    }

    @Test
    public void testPotionItemEqualsMethodInvalidName(){
        PotionItem p = new PotionItem("poison", 10, HEALTH, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

    @Test
    public void testPotionItemEqualsMethodInvalidPower(){
        PotionItem p = new PotionItem("felix felicis", -10, HEALTH, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

    @Test
    public void testPotionItemEqualsMethodInvalidEffect(){
        PotionItem p = new PotionItem("felix felicis", 10, MAGIC, "bad potion construction");
        PotionItem q = new PotionItem("felix felicis", 10, HEALTH, "bad potion construction");
        assertEquals(false, p.equals(q));
    }

}
