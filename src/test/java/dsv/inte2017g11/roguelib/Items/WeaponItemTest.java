package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.DAMAGE;
import static org.junit.Assert.assertEquals;

public class WeaponItemTest {

    @Test
    public void testCreateWeaponAndCheckAttributes(){
        WeaponItem w = new WeaponItem("Axe", 5, 14);
        assertEquals("Axe", w.getName());
        assertEquals(5, w.getWeight());
        assertEquals(14, w.getPower());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWeaponInvalidPowerValueZero(){
        WeaponItem w = new WeaponItem("Axe",5,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWeaponInvalidPowerValueNegative(){
        WeaponItem w = new WeaponItem("Axe",5,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateWeaponWDescInvalidPowerValue(){
        WeaponItem w = new WeaponItem("Sword", 5, -1, "bad weapon construction");
        assertEquals("no description available", w.getDescription());
    }

    @Test
    public void getWeaponEffect(){
        WeaponItem w = new WeaponItem("Axe", 5, 14);
        assertEquals(DAMAGE, w.getEffect());
    }

    @Test
    public void testCreateWeaponItemWithDescription(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "Magic silver sword");
        assertEquals("Magic silver sword", w.getDescription());
    }

    @Test
    public void testCreateWeaponItemWithoutDescription(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, null);
        assertEquals("no description available", w.getDescription());
    }

    @Test
    public void testWeaponItemEqualsMethodValid(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = w;
        assertEquals(true, w.equals(v));
    }

}