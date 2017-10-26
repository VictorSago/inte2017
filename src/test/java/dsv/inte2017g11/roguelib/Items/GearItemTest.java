package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class GearItemTest {

    @Test
    public void createNormalGearWithWeightTest() {
        GearItem gi = new GearItem("helmet", 3, 12, HEALTH);
        assertEquals(3, gi.getWeight());
    }

    @Test
    public void gearItemWeightTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(3, gi.getWeight());
    }

    @Test
    public void gearItemNegativeWeightTest() {
        GearItem gi = new GearItem("Helmet", -3, 12, HEALTH);
        assertEquals(0, gi.getWeight());
    }

    @Test
    public void gearItemHPTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(12, gi.getGearHP());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void gearItemNegativeHPTest() {
        GearItem gi = new GearItem("Helmet", 3, -12, HEALTH);
    }

    @Test
    public void gearItemZeroHPTest() {
        GearItem gi = new GearItem("Helmet", 3, 0, HEALTH);
        assertEquals(0, gi.getGearHP());
    }

    @Test
    public void gearGetEffectHealthTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(HEALTH, gi.getEffect());
    }

    @Test
    public void gearGetEffectMagicTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC);
        assertEquals(MAGIC, gi.getEffect());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void createGearWithoutEffectsTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, null);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void createGearWDescWithoutEffectsTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, null, "bad gear construction");
    }


    @Test
    public void createWithoutDescriptionTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC);
        assertEquals("no description available", gi.getDescription());
    }

    @Test
    public void createWithNullDescriptionTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC, null);
        assertEquals("no description available", gi.getDescription());
    }

    @Test
    public void createWithDescriptionTest() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC, "a sparkeling rainbow-feather covered helmet with amazing defence powers");
        assertEquals("a sparkeling rainbow-feather covered helmet with amazing defence powers", gi.getDescription());

    }

    @Test
    public void gearItemEqualsMethodTest(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "a sparkeling rainbow-feather covered helmet with amazing defence powers");
        GearItem p = g;
        assertEquals(true, g.equals(p));
    }

    @Test
    public void gearItemInvalidEqualsMethodNameTest(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("wrongname", 3, 12, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void gearItemInvalidEqualsMethodWeightTest(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("Helmet", 5, 12, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void gearItemInvalidEqualsMethodGearHpTest(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("Helmet", 3, 19, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void gearItemEqualsMethodInvalidClassTest(){
       GearItem g = new GearItem("Helmet", 3, 15, MAGIC);
        WeaponItem w = new WeaponItem("sword", 3, 15);
//        assertEquals(false, g.equals(w));
        assertThat(g, not(equalTo(w)));
    }
}

