package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GearItemTest {

    @Test
    public void testCreateNormalGearWithWeight() {
        GearItem gi = new GearItem("helmet", 3, 12, HEALTH);
        assertEquals(3, gi.getWeight());
    }

    @Test
    public void testGearItemWeight() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(3, gi.getWeight());
    }

    @Test
    public void testGearItemNegativeWeight() {
        GearItem gi = new GearItem("Helmet", -3, 12, HEALTH);
        assertEquals(0, gi.getWeight());
    }

    @Test
    public void testGearItemHP() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(12, gi.getGearHP());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testGearItemNegativeHP() {
        GearItem gi = new GearItem("Helmet", 3, -12, HEALTH);
    }

    @Test
    public void testGearItemZeroHP() {
        GearItem gi = new GearItem("Helmet", 3, 0, HEALTH);
        assertEquals(0, gi.getGearHP());
    }

    @Test
    public void testGearGetEffectHealth() {
        GearItem gi = new GearItem("Helmet", 3, 12, HEALTH);
        assertEquals(HEALTH, gi.getEffect());
    }

    @Test
    public void testGearGetEffectMagic() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC);
        assertEquals(MAGIC, gi.getEffect());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testCreateGearWithoutEffects() {
        GearItem gi = new GearItem("Helmet", 3, 12, null);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testCreateGearWDescWithoutEffects() {
        GearItem gi = new GearItem("Helmet", 3, 12, null, "bad gear construction");
    }


    @Test
    public void testCreateWithoutDescription() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC);
        assertEquals("no description available", gi.getDescription());
    }

    @Test
    public void testCreateWithNullDescription() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC, null);
        assertEquals("no description available", gi.getDescription());
    }

    @Test
    public void testCreateWithDescription() {
        GearItem gi = new GearItem("Helmet", 3, 12, MAGIC, "a sparkeling rainbow-feather covered helmet with amazing defence powers");
        assertEquals("a sparkeling rainbow-feather covered helmet with amazing defence powers", gi.getDescription());

    }

    @Test
    public void testGearItemEqualsMethod(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "a sparkeling rainbow-feather covered helmet with amazing defence powers");
        GearItem p = g;
        assertEquals(true, g.equals(p));
    }

    @Test
    public void testGearItemInvalidEqualsMethodName(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("wrongname", 3, 12, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void testGearItemInvalidEqualsMethodWeigth(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("Helmet", 5, 12, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void testGearItemInvalidEqualsMethodGearHp(){
        GearItem g = new GearItem("Helmet", 3, 12, MAGIC, "this is described");
        GearItem p = new GearItem("Helmet", 3, 19, MAGIC, "this is described");
        assertEquals(false, g.equals(p));
    }

    @Test
    public void testGearItemEqualsMethodInvalidClass(){
       GearItem g = new GearItem("Helmet", 3, 15, MAGIC);
        WeaponItem w = new WeaponItem("sword", 3, 15);
//        assertEquals(false, g.equals(w));
        assertThat(g, not(equalTo(w)));
    }
}

