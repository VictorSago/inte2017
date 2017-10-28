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
        assertThat("x-coordinate is wrong", location.getX(), is(newX));
        assertThat("y-coordinate is wrong.", location.getY(), is(newY));
    }

    @Test
    public void setNewPositionFromAnotherLocationTest() {
        int newX = 25;
        int newY = 108;
        Location otherLoc = new Location(newX, newY);
        location.setXYPos(otherLoc);
        assertThat("x-coordinate is wrong", location.getX(), is(newX));
        assertThat("y-coordinate is wrong", location.getY(), is(newY));
    }

    @Test
    public void displaceTest() {
        int newX = 25;
        int newY = 108;
        location.displace(newX, newY);
        assertThat("Resulting x-coordinate is wrong", location.getX(), is(POS_X + newX));
        assertThat("Resulting y-coordinate is wrong", location.getY(), is(POS_Y + newY));
    }

    @Test
    public void addXYTest() {
        int deltaX = 10;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYNegativeXTest() {
        int deltaX = -10;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYNegativeYTest() {
        int deltaX = 10;
        int deltaY = -12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYNegativeXYTest() {
        int deltaX = -10;
        int deltaY = -12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYZeroXTest() {
        int deltaX = 0;
        int deltaY = 12;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X));
        assertThat(newLoc.getY(), is(POS_Y + deltaY));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYZeroYTest() {
        int deltaX = 10;
        int deltaY = 0;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X + deltaX));
        assertThat(newLoc.getY(), is(POS_Y));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void addXYZeroTest() {
        int deltaX = 0;
        int deltaY = 0;
        Location newLoc = location.addXY(deltaX, deltaY);
        assertThat(newLoc.getX(), is(POS_X));
        assertThat(newLoc.getY(), is(POS_Y));
        assertThat("Old Location x-coordinate has changed", location.getX(), is(POS_X));
        assertThat("Old Location y-coordinate has changed", location.getY(), is(POS_Y));
    }

    @Test
    public void equalsTest() {
        Location otherLoc = new Location(POS_X, POS_Y);
        assertThat(location, equalTo(otherLoc));
    }

    @Test
    public void equalsReflexivityTest() {
        assertThat(location, equalTo(location));
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
    public void notEqualsNull() {
        assertThat(location, not(equalTo(null)));
    }

    @Test
    public void hashCodeTest() {
        Location otherLoc = new Location(POS_X, POS_Y + 1);
        assertThat("HashCodes are not different.", location.hashCode(), not(equalTo(otherLoc.hashCode())));
    }

    @Test
    public void hashCodeTest2() {
        Location otherLoc = new Location(-POS_X, POS_Y);
        assertThat("HashCodes are not different.", location.hashCode(), not(equalTo(otherLoc.hashCode())));
    }

    @Test
    public void hashCodeTest3() {
        Location otherLoc = new Location(POS_X, -POS_Y);
        assertThat("HashCodes are not different.", location.hashCode(), not(equalTo(otherLoc.hashCode())));
    }

    @Test
    public void hashCodeTest4() {
        Location otherLoc = new Location(0, POS_Y);
        assertThat("HashCodes are not different.", location.hashCode(), not(equalTo(otherLoc.hashCode())));
    }

    @Test
    public void toStringTest() {
        assertThat(location.toString(), is("(" + POS_X + ", " + POS_Y + ")"));
    }
}
