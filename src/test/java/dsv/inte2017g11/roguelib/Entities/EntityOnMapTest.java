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

    private int initialX, initialY;

    private GamePlayer player;
    private Pet kilgarrah;
    private Monster fluff;
    private GameMap map;

    @Before
    public void setUp() {
        initialX = SIZE_X / 2;
        initialY = SIZE_Y / 3;
        map = new GameMap(SIZE_X, SIZE_Y);
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
        MapLocation loc = new MapLocation(map, otherX, otherY);   // Calls map.getWidth() & map.getHeight()
        player.setMapLocation(loc);                                     // Calls map.equals(map)
        assertThat(player.getMapLocation(), equalTo(loc));
        assertThat(player.getMap(), sameInstance(map));                 // Won't make sense with mocked map
    }

    @Test
    public void setLocationWithMapTest() {
        int newX = 12;
        int newY = 9;
        assertThat(player.getPosX(), is(initialX));
        assertThat(player.getPosY(), is(initialY));
        assertThat(player.getMap(), sameInstance(map));                 // Won't make sense with mocked map
        player.setLocation(newX, newY);                                 // Calls map.isValidPosition(newX, newY) - return true
        assertThat(player.getPosX(), is(newX));
        assertThat(player.getPosY(), is(newY));
        assertThat(player.getMap(), sameInstance(map));                 // Won't make sense with mocked map
    }

    @Test(expected = NullPointerException.class)
    public void setLocationWithoutMapTest() {
        GamePlayer player2 = new GamePlayer("Ford Prefect");
        player2.setLocation(initialX, initialY);                         // Calls map.isValidPosition(newX, newY) - return true
    }

    @Test
    public void getMapLocationTest() {
        assertThat(player.getMapLocation(), equalTo(new MapLocation(map, initialX, initialY)));     // Calls map.getWidth() & map.getHeight()
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
    }

    @Test
    public void setFirstPositionTest() {
        kilgarrah.setMapLocation(map, 0, 0);           // Calls map.equals(map) & map.isValidPosition(0, 0)
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(0, kilgarrah.getPosY());
    }

    @Test
    public void setLastPositionTest() {
        int lastX = SIZE_X - 1;
        int lastY = SIZE_Y - 1;
        fluff.setMapLocation(map, lastX, lastY);      // Calls map.equals(map) & map.isValidPosition(xPos, yPos)
        assertEquals(lastX, fluff.getPosX());
        assertEquals(lastY, fluff.getPosY());
    }

    @Test
    public void validMoveRightTest() {
        player.move(RIGHT);
        assertEquals(initialX + 1, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        kilgarrah.move(LEFT);
        assertEquals(initialX - 1, kilgarrah.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        fluff.move(DOWN);
        assertEquals(initialY + 1, fluff.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        player.move(UP);
        assertEquals(initialY - 1, player.getPosY());
    }

    @Test
    public void stepsRemainingTest() {
        int expectedStepsRemaining = kilgarrah.getStepsRemaining();
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
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
        fluff.move(LEFT);
        fluff.move(UP);
        fluff.resetSteps();
        assertEquals(expectedStepsLeft, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveRightTest() {
        int lastX = SIZE_X - 1;                  // Different from test setUp
        player.setMapLocation(map, lastX, initialY);         // Calls map.equals(map) & map.isValidPosition(xPos, initialY)
        player.move(RIGHT);
        assertEquals(SIZE_X - 1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void invalidMoveLeftTest() {
        kilgarrah.setMapLocation(map, 0, initialY);      // Calls map.equals(map) & map.isValidPosition(xPos, initialY)
        kilgarrah.move(LEFT);
        assertEquals(0, kilgarrah.getPosX());
        assertEquals(DEFAULT_TEST_SPEED2, kilgarrah.getStepsRemaining());
    }

    @Test
    public void invalidMoveDownTest() {
        int lastY = SIZE_Y - 1;                  // Different from test setUp
        fluff.setMapLocation(map, initialX, lastY);          // Calls map.equals(map) & map.isValidPosition(initialX, lastY)
        fluff.move(DOWN);
        assertEquals(map.getHeight() - 1, fluff.getPosY());     // Calls map.getHeight()
        assertEquals(2 * DEFAULT_TEST_SPEED1, fluff.getStepsRemaining());
    }

    @Test
    public void invalidMoveUpTest() {
        player.setMapLocation(map, initialX, 0);         // Calls map.addEntity(player, location) - must return NULL, Calls map.getWidth() & map.getHeight()
        player.move(UP);
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED1, player.getStepsRemaining());
    }

    @Test
    public void simpleMoveSequenceTest() {
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
        player.setMapLocation(map, initialX, initialY);         // Calls map.addEntity(player, location) - must return NULL, Calls map.getWidth() & map.getHeight()
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
    	int testSpeed = 5;
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP);
        player.setMaxSpeed(testSpeed);
        assertEquals(testSpeed, player.getMaxSpeed());
        assertEquals(0, player.getStepsRemaining());
    }
}