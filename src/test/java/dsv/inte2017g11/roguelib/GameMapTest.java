package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameMapTest {
    @Test
    public void testMapCreateWithSize(){
        GameMap m = new GameMap(8);
        assertEquals(8, m.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidSize(){
        GameMap m = new GameMap(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapCreateWithZeroValue(){
        GameMap m = new GameMap(0);
    }

    @Test
    public void testGameMapBasicPosition(){
        GameMap m = new GameMap(4);
        Tile q = new Tile(2,2);
        assertEquals(true, q.equals(m.getPosition(2,2)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidPositionOverIndex(){
        GameMap m = new GameMap(4);
        m.getPosition(8,2);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidPositionUnderIndex(){
        GameMap m = new GameMap(4);
        m.getPosition(-1,8);
    }
}
