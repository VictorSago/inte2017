package dsv.inte2017g11.roguelib.Maps;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MapLocationTest {

    private final int POS_X = 100;
    private final int POS_Y = 60;
    private final int SIZE_X = 200;
    private final int SIZE_Y = 150;

    private MapLocation location;
    private GameMap map;

    @Before
    public void setUp() {
        map = new GameMap(SIZE_X, SIZE_Y);
        location = new MapLocation(map, POS_X, POS_Y);
    }

    @Test
    public void setNewValidPositionTest() {
        int newX = 55;
        int newY = 18;
        location.setXYPos(newX, newY);
        assertThat(location.getX(), is(newX));
        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewXTooBigPositionTest() {
        int newX = SIZE_X;
        int newY = 108;
        location.setXYPos(newX, newY);
//        assertThat(location.getX(), is(SIZE_X - 1));
//        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewXTooSmallPositionTest() {
        int newX = -POS_X;
        int newY = 108;
        location.setXYPos(newX, newY);
//        assertThat(location.getX(), is(0));
//        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewYTooBigPositionTest() {
        int newX = 25;
        int newY = SIZE_Y;
        location.setXYPos(newX, newY);
//        assertThat(location.getX(), is(newX));
//        assertThat(location.getY(), is(SIZE_Y - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewYTooSmallPositionTest() {
        int newX = 25;
        int newY = -POS_Y;
        location.setXYPos(newX, newY);
//        assertThat(location.getX(), is(newX));
//        assertThat(location.getY(), is(0));
    }

    @Test
    public void setNewValidMapPositionTest() {
        int newMapSizeX = 300;
        int newMapSizeY = 80;
        int newX = 108;
        int newY = 12;
        location.setMapXYPos(new GameMap(newMapSizeX, newMapSizeY), newX, newY);
        assertThat(location.getX(), is(newX));
        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewXTooBigMapPositionTest() {
        int newMapSizeX = 300;
        int newMapSizeY = 80;
        int newX = newMapSizeX;
        int newY = 108;
        location.setMapXYPos(new GameMap(newMapSizeX, newMapSizeY), newX, newY);
//        assertThat(location.getX(), is(newMapSizeX - 1));
//        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewXTooSmallMapPositionTest() {
        int newMapSizeX = 300;
        int newMapSizeY = 80;
        int newX = -POS_X;
        int newY = 108;
        location.setMapXYPos(new GameMap(newMapSizeX, newMapSizeY), newX, newY);
//        assertThat(location.getX(), is(0));
//        assertThat(location.getY(), is(newY));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewYTooBigMapPositionTest() {
        int newMapSizeX = 300;
        int newMapSizeY = 80;
        int newX = 25;
        int newY = newMapSizeY;
        location.setMapXYPos(new GameMap(newMapSizeX, newMapSizeY), newX, newY);
//        assertThat(location.getX(), is(newX));
//        assertThat(location.getY(), is(newMapSizeY - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNewYTooSmallMapPositionTest() {
        int newMapSizeX = 300;
        int newMapSizeY = 80;
        int newX = 25;
        int newY = -POS_Y;
        location.setMapXYPos(new GameMap(newMapSizeX, newMapSizeY), newX, newY);
//        assertThat(location.getX(), is(newX));
//        assertThat(location.getY(), is(0));
    }

    @Test
    public void addXYTest() {
        int x = 25;
        int y = 12;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addNegativeXTest() {
        int x = -25;
        int y = 12;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addNegativeYTest() {
        int x = 25;
        int y = -12;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addNegativeXYTest() {
        int x = -25;
        int y = -12;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addZeroXTest() {
        int x = 0;
        int y = 12;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addZeroYTest() {
        int x = 25;
        int y = 0;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X + x));
        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test
    public void addZeroXYTest() {
        int x = 0;
        int y = 0;
        location.addXY(x, y);
        assertThat(location.getX(), is(POS_X));
        assertThat(location.getY(), is(POS_Y));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addXTooBigTest() {
        int x = SIZE_X - POS_X;
        int y = 12;
        location.addXY(x, y);
//        assertThat(location.getX(), is(SIZE_X - 1));
//        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addXTooSmallTest() {
        int x = -2 * POS_X;
        int y = 12;
        location.addXY(x, y);
//        assertThat(location.getX(), is(0));
//        assertThat(location.getY(), is(POS_Y + y));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addYTooBigTest() {
        int x = 25;
        int y = SIZE_Y + POS_Y;
        location.addXY(x, y);
//        assertThat(location.getX(), is(POS_X + x));
//        assertThat(location.getY(), is(SIZE_Y - 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addYTooSmallTest() {
        int x = 25;
        int y = -2 * POS_Y;
        location.addXY(x, y);
//        assertThat(location.getX(), is(POS_X + x));
//        assertThat(location.getY(), is(0));
    }

    @Test
    public void displaceTest() {
        int deltaX = 11;
        int deltaY = -2;
        Location newLoc = location.displace(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceBigXTest() {
        int deltaX = SIZE_X;
        int deltaY = 12;
        Location newLoc = location.displace(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceBigNegativeXTest() {
        int deltaX = -SIZE_X;
        int deltaY = 12;
        Location newLoc = location.displace(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceBigYTest() {
        int deltaX = 12;
        int deltaY = SIZE_Y;
        Location newLoc = location.displace(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceBigNegativeYTest() {
        int deltaX = 12;
        int deltaY = -SIZE_Y;
        Location newLoc = location.displace(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceOnMapTest() {
        int deltaX = 10;
        int deltaY = 12;
        MapLocation newLoc = location.displaceOnMap(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceToOutsideRightMapBoundaryTest() {
        int deltaX = SIZE_X - POS_X;
        int deltaY = 12;
        MapLocation newLoc = location.displaceOnMap(deltaX, deltaY);
        assertThat(newLoc.getX(), is(SIZE_X - 1));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceToOutsideLeftMapBoundaryTest() {
        int deltaX = -SIZE_X;
        int deltaY = 12;
        MapLocation newLoc = location.displaceOnMap(deltaX, deltaY);
        assertThat(newLoc.getX(), is(0));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceToOutsideBottomMapBoundaryTest() {
        int deltaX = 10;
        int deltaY = SIZE_Y - POS_Y;
        MapLocation newLoc = location.displaceOnMap(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
//        assertThat(newLoc.getY(), is(SIZE_Y - 1));
    }

    @Test
    public void displaceToOutsideTopMapBoundaryTest() {
        int deltaX = 10;
        int deltaY = -SIZE_Y;
        MapLocation newLoc = location.displaceOnMap(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(0));
    }

    @Test
    public void equalsTest() {
        MapLocation otherLoc = new MapLocation(map, POS_X, POS_Y);
        assertThat(location, equalTo(otherLoc));
    }

    @Test
    public void notEqualsDifferentXCoordinatesTest() {
        MapLocation otherLoc = new MapLocation(map, POS_X + 1, POS_Y);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsDifferentYCoordinatesTest() {
        MapLocation otherLoc = new MapLocation(map, POS_X, POS_Y - 1);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsDifferentXYCoordinatesTest() {
        MapLocation otherLoc = new MapLocation(map, POS_X - 1, POS_Y + 1);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsDifferentMapsTest() {
        MapLocation otherLoc = new MapLocation(new GameMap(SIZE_X, SIZE_Y), POS_X, POS_Y);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsToOtherObjectTest() {
        assertThat(location, not(equalTo("some String")));
    }

    @Test
    public void toStringTest() {
        assertThat(location.toString(), is("GameMap{" + SIZE_X + "x" + SIZE_Y + "}(" + POS_X + ", " + POS_Y + ")"));
    }

}
