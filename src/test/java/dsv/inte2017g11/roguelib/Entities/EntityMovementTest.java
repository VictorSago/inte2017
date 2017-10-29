package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Maps.GameMap;
import dsv.inte2017g11.roguelib.Maps.Location;
import dsv.inte2017g11.roguelib.Maps.MapLocation;
import dsv.inte2017g11.roguelib.Maps.MapPath;
import org.junit.Before;
import org.junit.Test;

import static dsv.inte2017g11.roguelib.Maps.Direction.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EntityMovementTest {

    private final int DEFAULT_TEST_HEALTH1 = 100;
    private final int DEFAULT_TEST_HEALTH2 = 60;
    private final int DEFAULT_TEST_SPEED1 = 10;
    private final int DEFAULT_TEST_SPEED2 = 15;
    private final int SIZE_X = 20;
    private final int SIZE_Y = 15;

    private int initialX, initialY;

    private GamePlayer player;
    private Pet kilgarrah;
    private Monster fluff;
    private GameMap map;

    @Before
    public void setUp() {
        initialX = SIZE_X / 2;
        initialY = SIZE_Y / 3;
        map = mock(GameMap.class);
        when(map.addEntity(any(AbstractEntity.class), any(Location.class))).thenReturn(null);
        when(map.getWidth()).thenReturn(SIZE_X);
        when(map.getHeight()).thenReturn(SIZE_Y);
        player = new GamePlayer("Arthur Dent", DEFAULT_TEST_HEALTH1, DEFAULT_TEST_SPEED1);
        kilgarrah = new Pet("Kilgarrah", DEFAULT_TEST_HEALTH2, DEFAULT_TEST_SPEED2);
        fluff = new Monster("Fluff", 2 * DEFAULT_TEST_HEALTH1, 2 * DEFAULT_TEST_SPEED1, 1, 20);
        player.setMapLocation(map, initialX, initialY);         // Calls map.addEntity(player, location) - must return NULL, Calls map.getWidth() & map.getHeight()
        kilgarrah.setMapLocation(map, initialX, initialY);
        fluff.setMapLocation(map, initialX, initialY);

    }

    @Test
    public void setMapLocationTest() {
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
    }

    @Test
    public void setMapLocationTest2() {
        int otherX = initialX - 2;
        int otherY = initialY + 1;
        MapLocation loc = new MapLocation(map, otherX, otherY);
        player.setMapLocation(loc);
        assertThat(player.getMapLocation(), equalTo(loc));
    }

    @Test
    public void setLocationWithMapTest() {
        int newX = 12;
        int newY = 9;
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        assertThat(player.getPosX(), is(initialX));
        assertThat(player.getPosY(), is(initialY));
        player.setLocation(newX, newY);
        assertThat(player.getPosX(), is(newX));
        assertThat(player.getPosY(), is(newY));
    }

    @Test(expected = NullPointerException.class)
    public void setLocationWithoutMapTest() {
        GamePlayer player2 = new GamePlayer("Ford Prefect");
        player2.setLocation(initialX, initialY);
    }

    @Test
    public void getMapLocationTest() {
        assertThat(player.getMapLocation(), equalTo(new MapLocation(map, initialX, initialY)));
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
    }

    @Test
    public void setFirstPositionTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        kilgarrah.setMapLocation(map, 0, 0);
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(0, kilgarrah.getPosY());
    }

    @Test
    public void setLastPositionTest() {
        int lastX = SIZE_X - 1;
        int lastY = SIZE_Y - 1;
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        fluff.setMapLocation(map, lastX, lastY);
        assertEquals(lastX, fluff.getPosX());
        assertEquals(lastY, fluff.getPosY());
    }

    @Test
    public void validMoveRightTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        player.move(RIGHT);
        assertEquals(initialX + 1, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        kilgarrah.move(LEFT);
        assertEquals(initialX - 1, kilgarrah.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        fluff.move(DOWN);
        assertEquals(initialY + 1, fluff.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        player.move(UP);
        assertEquals(initialY - 1, player.getPosY());
    }

    @Test
    public void stepsRemainingTest() {
        int expectedStepsRemaining = kilgarrah.getStepsRemaining();
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        assertEquals(DEFAULT_TEST_SPEED2, kilgarrah.getStepsRemaining());
        kilgarrah.move(RIGHT);
        expectedStepsRemaining--;
        assertEquals(expectedStepsRemaining, kilgarrah.getStepsRemaining());
        kilgarrah.move(LEFT);
        kilgarrah.move(UP);
        kilgarrah.move(DOWN);
        expectedStepsRemaining -= 3;
        assertEquals(expectedStepsRemaining, kilgarrah.getStepsRemaining());
    }

    @Test
    public void resetStepsTest() {
        int expectedStepsLeft = fluff.getStepsRemaining();
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
        fluff.move(LEFT);
        fluff.move(UP);
        fluff.resetSteps();
        assertEquals(expectedStepsLeft, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveRightTest() {
        int lastX = SIZE_X - 1;
        when(map.isValidPosition(lastX, initialY)).thenReturn(true);
        player.setMapLocation(map, lastX, initialY);
        player.move(RIGHT);
        assertEquals(SIZE_X - 1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void invalidMoveLeftTest() {
        when(map.isValidPosition(0, initialY)).thenReturn(true);
        kilgarrah.setMapLocation(map, 0, initialY);
        kilgarrah.move(LEFT);
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(DEFAULT_TEST_SPEED2, kilgarrah.getStepsRemaining());
    }

    @Test
    public void invalidMoveDownTest() {
        int lastY = SIZE_Y - 1;
        when(map.isValidPosition(initialX, lastY)).thenReturn(true);
        fluff.setMapLocation(map, initialX, lastY);
        fluff.move(DOWN);
        assertEquals(map.getHeight() - 1, fluff.getPosY());
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveUpTest() {
        when(map.isValidPosition(initialX, 0)).thenReturn(true);
        player.setMapLocation(map, initialX, 0);
        player.move(UP);
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void simpleMoveSequenceTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        player.move(DOWN, DOWN, RIGHT);
        int expectedX = initialX + 1;
        int expectedY = initialY + 2;
        int expectedStepsRemaining = DEFAULT_TEST_SPEED1 - 3;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsRemaining, player.getStepsRemaining());
    }

    @Test
    public void moveTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        player.setMapLocation(map, initialX, initialY);
        MapPath path = new MapPath();
        path.appendStep(DOWN);
        path.appendStep(RIGHT);
        path.appendStep(UP);
        path.appendStep(UP);
        path.appendStep(RIGHT);
        int expectedX = initialX + 2;
        int expectedY = initialY + 1 - 2;
        int expectedStepsRemaining = DEFAULT_TEST_SPEED1 - path.getPathLength();
        path = player.move(path);
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsRemaining, player.getStepsRemaining());
        assertEquals(0, path.getPathLength());
    }

    @Test
    public void moveLongerThanMaxStepsTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP, UP, UP, LEFT, LEFT);
        int expectedX = initialX + 3;
        int expectedY = initialY + 3 - 4;
        int expectedStepsRemaining = 0;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsRemaining, player.getStepsRemaining());
    }

    @Test
    public void setNewSpeedAfterMoveTest() {
        when(map.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        when(map.isValidPosition(any(Location.class))).thenReturn(true);
        when(map.isFreePosition(any(Location.class))).thenReturn(true);
    	int testSpeed = 5;
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP);
        player.setMaxSpeed(testSpeed);
        assertEquals(testSpeed, player.getMaxSpeed());
        assertEquals(0, player.getStepsRemaining());
    }
}
