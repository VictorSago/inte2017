package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Maps.GameMap;
import dsv.inte2017g11.roguelib.Maps.MapPath;
import org.junit.Before;
import org.junit.Test;

import static dsv.inte2017g11.roguelib.Maps.Directions.*;
import static org.junit.Assert.assertEquals;

public class CharacterMapInteractionTest {

    private final int DEFAULT_TEST_HEALTH = 100;
    private final int DEFAULT_TEST_SPEED = 10;
    private final int SIZE_X = 20;
    private final int SIZE_Y = 15;

    private AbstractCharacter player;
    private GameMap map;

    @Before
    public void setUp() throws Exception {
        player = new AbstractCharacter("Jane Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED,map) {};
        map = new GameMap(SIZE_X, SIZE_Y);
    }

    @Test
    public void setPositionTest() {
        int initialX = 10;
        int initialY = 5;
        player.setPosition(map, initialX, initialY);
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
        assertEquals(initialY * map.getWidth() + initialX, player.getPosition());
    }

    @Test
    public void setFirstPositionTest() {
        player.setPosition(map, 0, 0);
        assertEquals(0, player.getPosX());
        assertEquals(0, player.getPosY());
        assertEquals(0, player.getPosition());
    }

    @Test
    public void setLastPositionTest() {
        int initialX = SIZE_X - 1;
        int initialY = SIZE_Y - 1;
        int expectedPosition = SIZE_X * SIZE_Y - 1;
        player.setPosition(map, initialX, initialY);
        assertEquals(initialX, player.getPosX());
        assertEquals(initialY, player.getPosY());
        assertEquals(expectedPosition, player.getPosition());
    }

    @Test
    public void validMoveRightTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(RIGHT);
        assertEquals(initialX + 1, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(LEFT);
        assertEquals(initialX - 1, player.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(DOWN);
        assertEquals(initialY + 1, player.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(UP);
        assertEquals(initialY - 1, player.getPosY());
    }

    @Test
    public void stepsLeftTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int expectedStepsLeft = player.getStepsLeft();
        player.setPosition(map, initialX, initialY);
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
        player.move(RIGHT);
        expectedStepsLeft--;
        assertEquals(expectedStepsLeft, player.getStepsLeft());
        player.move(LEFT);
        player.move(UP);
        player.move(DOWN);
        expectedStepsLeft -= 3;
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }

    @Test
    public void resetStepsTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int expectedStepsLeft = player.getStepsLeft();
        player.setPosition(map, initialX, initialY);
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
        player.move(LEFT);
        player.move(UP);
        player.resetSteps();
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }

    @Test
    public void invalidMoveRightTest() {
        int initialX = SIZE_X - 1;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(RIGHT);
        assertEquals(map.getWidth() - 1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveLeftTest() {
        int initialX = 0;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(LEFT);
        assertEquals(0, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveDownTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y - 1;
        player.setPosition(map, initialX, initialY);
        player.move(DOWN);
        assertEquals(map.getHeight() - 1, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveUpTest() {
        int initialX = SIZE_X / 2;
        int initialY = 0;
        player.setPosition(map, initialX, initialY);
        player.move(UP);
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void simpleMoveSequenceTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT);
        int expectedX = initialX + 1;
        int expectedY = initialY + 2;
        int expectedStepsLeft = DEFAULT_TEST_SPEED - 3;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }

    @Test
    public void moveTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        MapPath path = new MapPath();
        path.appendStep(DOWN);
        path.appendStep(RIGHT);
        path.appendStep(UP);
        path.appendStep(UP);
        path.appendStep(RIGHT);
        int expectedX = initialX + 2;
        int expectedY = initialY + 1 - 2;
        int expectedStepsLeft = DEFAULT_TEST_SPEED - path.getPathLength();
        path = player.move(path);
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsLeft());
        assertEquals(0, path.getPathLength());
    }

    @Test
    public void moveLongerThanMaxStepsTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP, UP, UP, LEFT, LEFT);
        int expectedX = initialX + 3;
        int expectedY = initialY + 3 - 4;
        int expectedStepsLeft = 0;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }
    
    @Test
    public void setNewSpeedAfterMoveTest() {
    	int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        int testSpeed = 5;
        player.setPosition(map, initialX, initialY);
        player.move(DOWN, DOWN, RIGHT, RIGHT, DOWN, RIGHT, UP, UP);
        player.setSpeed(testSpeed);
        assertEquals(testSpeed, player.getSpeed());
        assertEquals(0, player.getStepsLeft());
    }
}
