package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Maps.Directions;
import dsv.inte2017g11.roguelib.Maps.GameMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterMapInteractionTest {

    private final int DEFAULT_TEST_HEALTH = 100;
    private final int DEFAULT_TEST_SPEED = 10;
    private final int SIZE_X = 20;
    private final int SIZE_Y = 15;

    private AbstractCharacter player;
    private GameMap map;

    @Before
    public void setUp() {
        player = new AbstractCharacter("Jane Doe", DEFAULT_TEST_HEALTH, DEFAULT_TEST_SPEED) {};
        map = new GameMap(SIZE_X, SIZE_Y);
    }

    @Test
    public void positionTest() {
        int tX = 10;
        int tY = 5;
        player.setPosition(map, tX, tY);
        assertEquals(tX, player.getPosX());
        assertEquals(tY, player.getPosY());
        assertEquals(tY * map.getWidth() + tX, player.getPosition());
    }

    @Test
    public void validMoveRightTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveRight();
        assertEquals(tX + 1, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveLeft();
        assertEquals(tX - 1, player.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveDown();
        assertEquals(tY + 1, player.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveUp();
        assertEquals(tY - 1, player.getPosY());
    }

    @Test
    public void stepsLeftTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y / 3;
        int expectedStepsLeft = player.getStepsLeft();
        player.setPosition(map, tX, tY);
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
        player.moveRight();
        expectedStepsLeft--;
        assertEquals(expectedStepsLeft, player.getStepsLeft());
        player.moveLeft();
        player.moveUp();
        player.moveDown();
        expectedStepsLeft -= 3;
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }

    @Test
    public void invalidMoveRightTest() {
        int tX = SIZE_X - 1;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveRight();
        assertEquals(map.getWidth() - 1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveLeftTest() {
        int tX = 0;
        int tY = SIZE_Y / 3;
        player.setPosition(map, tX, tY);
        player.moveLeft();
        assertEquals(0, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveDownTest() {
        int tX = SIZE_X / 2;
        int tY = SIZE_Y - 1;
        player.setPosition(map, tX, tY);
        player.moveDown();
        assertEquals(map.getHeight() - 1, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveUpTest() {
        int tX = SIZE_X / 2;
        int tY = 0;
        player.setPosition(map, tX, tY);
        player.moveUp();
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void simpleMoveTest() {
        int initialX = SIZE_X / 2;
        int initialY = SIZE_Y / 3;
        player.setPosition(map, initialX, initialY);
        player.move(Directions.DOWN, Directions.DOWN, Directions.RIGHT);
        int expectedX = initialX + 1;
        int expectedY = initialY + 2;
        int expectedStepsLeft = DEFAULT_TEST_SPEED - 3;
        assertEquals(expectedX, player.getPosX());
        assertEquals(expectedY, player.getPosY());
        assertEquals(expectedStepsLeft, player.getStepsLeft());
    }
}
