package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void testTileCreate(){
        Tile p = new Tile(2);
        assertNotNull(p);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testTileInvalid(){
        Tile p = new Tile(-1);
    }
    
    @Test
    public void testGetTerrain(){
    	Tile p = new Tile(2);
    	assertEquals(2,p.getTerrain());
    }
    
    
    @Test
    public void testSetTerrain(){
    	Tile p = new Tile(2);
    	p.setTerrain(3);
    	assertEquals(3,p.getTerrain());
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetTerrainFail(){
    	Tile p = new Tile(2);
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
    public void testTileHashCode(){
        Tile p = new Tile(1);
        Tile q = new Tile(1);
        assertEquals(true, p.hashCode()==q.hashCode());
    }

    @Test
    public void testTileHashCodeFail(){
        Tile p = new Tile(4);
        Tile q = new Tile(2);
        assertEquals(false, p.hashCode()==q.hashCode());
    }

    @Test
    public void testTileEqualsMethod(){
        Tile p = new Tile(3);
        Tile q = new Tile(3);
        assertEquals(true, p.equals(q));
    }

    @Test
    public void testTileFalseEqualsMethod(){
        Tile p = new Tile(2);
        Tile q = new Tile(4);
        assertEquals(false, p.equals(q));
    }

    @Test
    public void testTileEqualsAnotherObject(){
        Tile p = new Tile(4);
        String s = "teststring";
        assertEquals(false, p.equals(s));
    }

}