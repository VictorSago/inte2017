package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {

    private final int SIZE_X = 15;
    private final int SIZE_Y = 10;

    @Test
    public void mapCreationTest() {
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertEquals(SIZE_X * SIZE_Y, m.getSize());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidSizeXCreation() {
		GameMap m = new GameMap(-1, SIZE_Y);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidSizeYCreation() {
        GameMap m = new GameMap(SIZE_X, -1);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void creationWithZeroValueX() {
        GameMap m = new GameMap(0, SIZE_Y);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void creationWithZeroValueY() {
        GameMap m = new GameMap(SIZE_X, 0);
    }

    /*
    @Test
    public void testGameMapBasicPosition() {
        GameMap m = new GameMap(4);
        Tile q = new Tile(2,2);
        assertEquals(true, q.equals(m.getTile(2,2)));
    }
    */

    /*
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidPositionOverIndex() {
        GameMap m = new GameMap(4);
        m.getTile(8,2);
    }
    */

    /*
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidPositionUnderIndex() {
        GameMap m = new GameMap(4);
        m.getTile(-1,8);
    }
    */
}
