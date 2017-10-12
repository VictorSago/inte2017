package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void testTileCreate(){
        Tile p = new Tile();
        assertNotNull(p);
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
    public void testTileInvalidXCoordinate(){
        Tile p = new Tile(-1,2);
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
        Tile p = new Tile();
        Tile q = new Tile();
        assertEquals(true, p.hashCode()==q.hashCode());
    }

    /*@Test
    public void testTileHashCodeOnInvertedCoordinateValues(){
        Tile p = new Tile(4,2);
        Tile q = new Tile(2,4);
        assertEquals(false, p.hashCode()==q.hashCode());
    }*/

    @Test
    public void testTileEqualsMethod(){
        Tile p = new Tile();
        Tile q = new Tile();
        assertEquals(true, p.equals(q));
    }

    /*@Test
    public void testTileFalseEqualsMethod(){
        Tile p = new Tile (2,4);
        Tile q = new Tile(4,2);
        assertEquals(false, p.equals(q));
    }*/

    @Test
    public void testTileEqualsAnotherObject(){
        Tile p = new Tile();
        GameMap m = new GameMap(2);
        assertEquals(false, p.equals(m));
    }

}