package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GearItemTest {

    @Test
    public void testCreateNormalGearItem(){
        GearItem gi = new GearItem("Helmet");
        assertEquals("Helmet", gi.getName());
    }

    @Test
    public void testCreateNormalGearWithWeigth(){
        GearItem gi = new GearItem("helmet", 3);
        assertEquals(3, gi.getWeigth());
    }

    @Test
    public void testGetItemEffect(){
        GearItem gi = new GearItem("Helmet");
        assertEquals(20, gi.getEffect());
    }


}
