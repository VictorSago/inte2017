package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Maps.*;

import org.junit.Before;
import org.junit.Test;

import static dsv.inte2017g11.roguelib.Maps.Direction.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class EntityOnMapTest {

    private final int DEFAULT_TEST_HEALTH1 = 100;
    private final int DEFAULT_TEST_HEALTH2 = 60;
    private final int DEFAULT_TEST_SPEED1 = 10;
    private final int DEFAULT_TEST_SPEED2 = 15;
    private final int SIZE_X = 20;
    private final int SIZE_Y = 15;

    private AbstractEntity player;
    private Pet kilgarrah;
    private Monster fluff;
    private GameMap map;

    @Before
    public void setUp() throws Exception {
        player = new AbstractEntity("Jane Doe", DEFAULT_TEST_HEALTH1, DEFAULT_TEST_SPEED1) {};
        kilgarrah = new Pet("Kilgarrah", DEFAULT_TEST_HEALTH2, DEFAULT_TEST_SPEED2);
        fluff = new Monster("Fluff", 2 * DEFAULT_TEST_HEALTH1, 2 * DEFAULT_TEST_SPEED1, 1, 20);
        map = new GameMap(SIZE_X, SIZE_Y);
    }

    @Test
    public void setMapLocationTest() {
        int initialX = 10;
        int initialY = 5;
        player.setMapLocation(map, initialX, initialY);
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
    }

    @Test
    public void setMapLocationTest2() {
        int initialX = 10;
        int initialY = 5;
        MapLocation loc = new MapLocation(map, initialX, initialY);
        player.setMapLocation(loc);
        assertThat(player.getMapLocation(), equalTo(loc));
        assertThat(player.getMap(), sameInstance(map));
    }

    @Test
    public void setLocationWithMapTest() {
        int initialX = 10;
        int initialY = 5;
        int newX = 12;
        int newY = 9;
        player.setMapLocation(map, initialX, initialY);
        assertThat(player.getPosX(), is(initialX));
        assertThat(player.getPosY(), is(initialY));
        assertThat(player.getMap(), sameInstance(map));
        player.setLocation(newX, newY);
        assertThat(player.getPosX(), is(newX));
        assertThat(player.getPosY(), is(newY));
        assertThat(player.getMap(), sameInstance(map));
    }

    @Test(expected = NullPointerException.class)
    public void setLocationWithoutMapTest() {
        int initialX = 10;
        int initialY = 5;
        player.setLocation(initialX, initialY);
    }

    @Test
    public void getMapLocationTest() {
        int initialX = 10;
        int initialY = 5;
        player.setMapLocation(map, initialX, initialY);
        assertThat(player.getMapLocation(), equalTo(new MapLocation(map, initialX, initialY)));
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
    }

    @Test
    public void setFirstPositionTest() {
        kilgarrah.setMapLocation(map, 0, 0);
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(0, kilgarrah.getPosY());
    }

    @Test
    public void setLastPositionTest() {
        int initialX = SIZE_X - 1;
        int initialY = SIZE_Y - 1;
        fluff.setMapLocation(map, initialX, initialY);
        assertEquals(initialX, fluff.getPosX());
        assertEquals(initialY, fluff.getPosY());
    }

    @Test
    public void validMoveRightTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        player.move(RIGHT);
        assertEquals(initialX + 1, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        kilgarrah.setMapLocation(map, initialX, initialY);
        kilgarrah.move(LEFT);
        assertEquals(initialX - 1, kilgarrah.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        fluff.setMapLocation(map, initialX, initialY);
        fluff.move(DOWN);
        assertEquals(initialY + 1, fluff.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        player.move(UP);
        assertEquals(initialY - 1, player.getPosY());
    }

    @Test
    public void stepsLeftTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int expectedStepsLeft = kilgarrah.getStepsRemaining();
        kilgarrah.setMapLocation(map, initialX, initialY);
        assertEquals(DEFAULT_TEST_SPEED2, kilgarrah.getStepsRemaining());
        kilgarrah.move(RIGHT);
        expectedStepsLeft--;
        assertEquals(expectedStepsLeft, kilgarrah.getStepsRemaining());
        kilgarrah.move(LEFT);
        kilgarrah.move(UP);
        kilgarrah.move(DOWN);
        expectedStepsLeft -= 3;
        assertEquals(expectedStepsLeft, kilgarrah.getStepsRemaining());
    }

    @Test
    public void resetStepsTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int expectedStepsLeft = fluff.getStepsRemaining();
        fluff.setMapLocation(map, initialX, initialY);
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
        fluff.move(LEFT);
        fluff.move(UP);
        fluff.resetSteps();
        assertEquals(expectedStepsLeft, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveRightTest() {
        int initialX = SIZE_X - 1;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        player.move(RIGHT);
        assertEquals(map.getWidth() - 1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void invalidMoveLeftTest() {
        int initialX = 0;
        int initialY = SIZE_Y / 3;
        kilgarrah.setMapLocation(map, initialX, initialY);
        kilgarrah.move(LEFT);
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(DEFAULT_TEST_SPEED2, kilgarrah.getStepsRemaining());
    }

    @Test
    public void invalidMoveDownTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y - 1;
        fluff.setMapLocation(map, initialX, initialY);
        fluff.move(DOWN);
        assertEquals(map.getHeight() - 1, fluff.getPosY());
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveUpTest() {
        int initialX = SIZE_X / 2;
        int initialY = 0;
        player.setMapLocation(map, initialX, initialY);
        player.move(UP);
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void simpleMoveSequenceTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT);
        int expectedX = initialX + 1;
        int expectedY = initialY + 2;
        int expectedStepsLeft = DEFAULT_TEST_SPEED1 - 3;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsRemaining());
    }

    @Test
    public void moveTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        MapPath path = new MapPath();
        path.appendStep(DOWN);
        path.appendStep(RIGHT);
        path.appendStep(UP);
        path.appendStep(UP);
        path.appendStep(RIGHT);
        int expectedX = initialX + 2;
        int expectedY = initialY + 1 - 2;
        int expectedStepsLeft = DEFAULT_TEST_SPEED1 - path.getPathLength();
        path = player.move(path);
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsRemaining());
        assertEquals(0, path.getPathLength());
    }

    @Test
    public void moveLongerThanMaxStepsTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setMapLocation(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP, UP, UP, LEFT, LEFT);
        int expectedX = initialX + 3;
        int expectedY = initialY + 3 - 4;
        int expectedStepsLeft = 0;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsRemaining());
    }
    
    @Test
    public void setNewSpeedAfterMoveTest() {
    	int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int testSpeed = 5;
        player.setMapLocation(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP);
        player.setMaxSpeed(testSpeed);
        assertEquals(testSpeed, player.getMaxSpeed());
        assertEquals(0, player.getStepsRemaining());
    }
}
