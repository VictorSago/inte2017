package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.DAMAGE;
import static dsv.inte2017g11.roguelib.Items.Effect.MAGIC;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WeaponItemTest {

    @Test
    public void testCreateWeaponAndCheckAttributes(){
        WeaponItem w = new WeaponItem("Axe", 5, 14);
        assertEquals("Axe", w.getName());
        assertEquals(5, w.getWeight());
        assertEquals(14, w.getPower());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWeaponInvalidPowerValueZero(){
        WeaponItem w = new WeaponItem("Axe",5,0);
    }

    @SuppressWarnings("unused")
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
    public void getWeaponEffectTest(){
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

    @Test
    public void testWeaponItemEqualsMethodInvalidClass(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        PotionItem p = new PotionItem("Wolfsbane", 33, MAGIC);
//        assertEquals(false, w.equals(p));
        assertThat(w, not(equalTo(p)));
    }

    @Test
    public void testWeaponItemEqualsMethodInvalidName(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("SilverSword", 5, 25, "shiny!");
        assertEquals(false, w.equals(v));
    }


    @Test
    public void testWeaponItemEqualsMethodInvalidWeigth(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("Sword", 4, 25, "shiny!");
        assertEquals(false, w.equals(v));
    }

    @Test
    public void testWeaponItemEqualsMethodInvalidPower(){
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("Sword", 5, 15, "shiny!");
        assertEquals(false, w.equals(v));
    }

}
