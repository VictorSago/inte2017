package dsv.inte2017g11.roguelib.Maps;

import org.junit.Before;
import org.junit.Test;

import static dsv.inte2017g11.roguelib.Maps.Directions.*;

import static org.junit.Assert.*;

public class MapPathTest {

    private MapPath path;

    @Before
    public void setUp() throws Exception {
        path = new MapPath();
    }

    @Test
    public void emptyPathTest() {
        assertTrue(path.isEmpty());
    }

    @Test
    public void zeroPathLengthTest() {
        assertEquals(0, path.getPathLength());
    }

    @Test
    public void appendStepTest() {
        path.appendStep(DOWN);
        path.appendStep(RIGHT);
        path.appendStep(UP);
        path.appendStep(LEFT);
        assertEquals(4, path.getPathLength());
    }

    @Test
    public void appendNullTest() {
        assertFalse(path.appendStep(null));
        assertEquals(0, path.getPathLength());
    }

    @Test
    public void getNextStepFromEmptyQueueTest() {
        assertNull(path.getNextStep());
    }

    @Test
    public void getNextStepTest() throws Exception {
        Directions first = DOWN;
        Directions second = RIGHT;
        Directions third = UP;
        Directions fourth = LEFT;
        path.appendStep(first);
        path.appendStep(second);
        path.appendStep(third);
        path.appendStep(fourth);
        assertEquals(first, path.getNextStep());
        assertEquals(3, path.getPathLength());
        assertEquals(second, path.getNextStep());
        assertEquals(third, path.getNextStep());
        assertEquals(1, path.getPathLength());
        assertEquals(fourth, path.getNextStep());
        assertEquals(0, path.getPathLength());
        assertNull(path.getNextStep());
        assertEquals(0, path.getPathLength());
    }

}
