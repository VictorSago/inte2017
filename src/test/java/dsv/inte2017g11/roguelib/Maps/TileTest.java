package dsv.inte2017g11.roguelib.Maps;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void tileCreationTest() {
        Tile p = new Tile(2, new ArrayList<>());
        assertNotNull(p);
    }
    
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidTerrainTest() {
        Tile p = new Tile(-1, new ArrayList<>());
    }
    
    @Test
    public void getTerrainTest() {
    	Tile p = new Tile(2, new ArrayList<>());
    	assertEquals(2, p.getTerrain());
    }
    
    
    @Test
    public void setTerrainTest() {
    	Tile p = new Tile(2, new ArrayList<>());
    	p.setTerrain(3);
    	assertEquals(3, p.getTerrain());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void setInvalidTerrainTest() {
    	Tile p = new Tile(2, new ArrayList<>());
    	p.setTerrain(-2);
    }

    /*@Test
    public void testTileCreateY(){
        Tile p = new Tile(2,4);
        assertEquals(4, p.getY());
    }*/

    /*@Test
    public void testTileCreateBoth(){
        Tile p = new Tile(8,10);
        assertEquals(8, p.getX());
        assertEquals(10, p.getY());
    }*/



    /*@Test(expected = IndexOutOfBoundsException.class)
    public void testTileInvalidYCoordinate(){
        Tile p = new Tile(10, -1000);
    }*/

    /*@Test
    public void testCoordinateIndexZero(){
        Tile p = new Tile(0,0);
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }*/

    @Test
    public void sameHashCodeTest() {
        Tile p = new Tile(1, new ArrayList<>());
        Tile q = new Tile(1, new ArrayList<>());
        assertTrue(p.hashCode() == q.hashCode());
    }

    @Test
    public void differentHashCodeTest() {
        Tile p = new Tile(4, new ArrayList<>());
        Tile q = new Tile(2, new ArrayList<>());
        assertFalse(p.hashCode() == q.hashCode());
    }

    @Test
    public void equalTilesTest() {
        Tile p = new Tile(3, new ArrayList<>());
        Tile q = new Tile(3, new ArrayList<>());
        assertTrue(p.equals(q));
    }

    @Test
    public void nonEqualTilesTest() {
        Tile p = new Tile(2, new ArrayList<>());
        Tile q = new Tile(4, new ArrayList<>());
        assertFalse(p.equals(q));
    }

    @Test
    public void nonEqualAnotherObjectTest() {
        Tile p = new Tile(4, new ArrayList<>());
        String s = "teststring";
        assertFalse(p.equals(s));
    }

}
