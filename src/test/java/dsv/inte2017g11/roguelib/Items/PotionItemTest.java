package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;
import static dsv.inte2017g11.roguelib.Items.Effect.*;
import static org.junit.Assert.assertEquals;

public class PotionItemTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNoNamePotion() {
        PotionItem p = new PotionItem("", 0, HEALTH);
    }

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

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPotionWithoutEffect() {
        PotionItem p = new PotionItem("poison", 10, null);
    }

}
