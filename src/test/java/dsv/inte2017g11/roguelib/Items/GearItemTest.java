package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;
import static org.junit.Assert.assertEquals;

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

}
