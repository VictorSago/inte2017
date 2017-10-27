package dsv.inte2017g11.roguelib.Maps;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocationTest {

    private final int POS_X = 100;
    private final int POS_Y = 60;

    private Location location;

    @Before
    public void setUp() {
        location = new Location(POS_X, POS_Y);
    }

    @Test
    public void setNewPositionTest() {
        int newX = 25;
        int newY = 108;
        location.setXYPos(newX, newY);
        assertThat(location.getX(), is(newX));
        assertThat(location.getY(), is(newY));
    }

    @Test
    public void addXYTest() {
        int newX = 25;
        int newY = 108;
        location.displace(newX, newY);
        assertThat(location.getX(), is(POS_X + newX));
        assertThat(location.getY(), is(POS_Y + newY));
    }

    @Test
    public void displaceTest() {
        int deltaX = 10;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceNegativeXTest() {
        int deltaX = -10;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceNegativeYTest() {
        int deltaX = 10;
        int deltaY = -12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceNegativeXYTest() {
        int deltaX = -10;
        int deltaY = -12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceZeroXTest() {
        int deltaX = 0;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
    }

    @Test
    public void displaceZeroYTest() {
        int deltaX = 10;
        int deltaY = 0;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y));
    }

    @Test
    public void displaceZeroTest() {
        int deltaX = 0;
        int deltaY = 0;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X));
        assertThat(newLoc.getY(), is(POS_Y));
    }

    @Test
    public void equalsTest() {
        Location otherLoc = new Location(POS_X, POS_Y);
        assertThat(location, equalTo(otherLoc));
    }

    @Test
    public void notEqualsXTest() {
        Location otherLoc = new Location(POS_X + 1, POS_Y);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsYTest() {
        Location otherLoc = new Location(POS_X, POS_Y - 1);
        assertThat(location, not(equalTo(otherLoc)));
    }

    @Test
    public void notEqualsToOtherObjectTest() {
        assertThat(location, not(equalTo("some String")));
    }

    @Test
    public void toStringTest() {
        assertThat(location.toString(), is("(" + POS_X + ", " + POS_Y + ")"));
    }
}
