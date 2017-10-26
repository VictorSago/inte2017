package dsv.inte2017g11.roguelib.Items;

import org.junit.Test;

import static dsv.inte2017g11.roguelib.Items.Effect.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WeaponItemTest {

    @Test
    public void createWeaponAndCheckAttributesTest(){
        WeaponItem w = new WeaponItem("Axe", 5, 14);
        assertEquals("Axe", w.getName());
        assertEquals(5, w.getWeight());
        assertEquals(14, w.getPower());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void createWeaponInvalidPowerValueZeroTest(){
        WeaponItem w = new WeaponItem("Axe",5,0);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void createWeaponInvalidPowerValueNegativeTest(){
        WeaponItem w = new WeaponItem("Axe",5,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWeaponWDescInvalidPowerValueTest() {
        WeaponItem w = new WeaponItem("Sword", 5, -1, "bad weapon construction");
        assertEquals("no description available", w.getDescription());
    }

    @Test
    public void getWeaponEffectTest() {
        WeaponItem w = new WeaponItem("Axe", 5, 14);
        assertEquals(DAMAGE, w.getEffect());
    }

    @Test
    public void createWeaponItemWithDescriptionTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "Magic silver sword");
        assertEquals("Magic silver sword", w.getDescription());
    }

    @Test
    public void createWeaponItemWithoutDescriptionTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, null);
        assertEquals("no description available", w.getDescription());
    }

    @Test
    public void weaponItemEqualsMethodValidTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = w;
        assertEquals(true, w.equals(v));
    }

    @Test
    public void weaponItemEqualsMethodInvalidClassTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        PotionItem p = new PotionItem("Wolfsbane", 33, MAGIC);
//        assertEquals(false, w.equals(p));
        assertThat(w, not(equalTo(p)));
    }

    @Test
    public void weaponItemEqualsMethodInvalidNameTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("SilverSword", 5, 25, "shiny!");
        assertEquals(false, w.equals(v));
    }


    @Test
    public void weaponItemEqualsMethodInvalidWeightTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("Sword", 4, 25, "shiny!");
        assertEquals(false, w.equals(v));
    }

    @Test
    public void weaponItemEqualsMethodInvalidPowerTest() {
        WeaponItem w = new WeaponItem("Sword", 5, 25, "shiny!");
        WeaponItem v = new WeaponItem("Sword", 5, 15, "shiny!");
        assertEquals(false, w.equals(v));
    }

}
