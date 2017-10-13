package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionItemTester {


    @Test
    public void testCreatePotionItem(){
        PotionItem p = new PotionItem("poison", 0);
        assertEquals("poison",p.getName());
    }

    @Test
    public void testPotionGetPositivePower(){
        PotionItem p = new PotionItem("poison", 10);
        assertEquals(10, p.getPower());
    }

    @Test
    public void testPotionGetNegativePower(){
        PotionItem p = new PotionItem("poison", -10);
        assertEquals(-10, p.getPower());
    }

}
