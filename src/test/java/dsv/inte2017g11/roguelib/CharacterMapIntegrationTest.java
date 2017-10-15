package dsv.inte2017g11.roguelib;

import dsv.inte2017g11.roguelib.Characters.AbstractCharacter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterMapIntegrationTest {

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
        player.setPosition(map, 10, 5);
        assertEquals(10, player.getPosX());
        assertEquals(5, player.getPosY());
        assertEquals(5 * map.getWidth() + 10, player.getPosition());
    }

    @Test
    public void validMoveRightTest() {
        player.setPosition(map, 10, 5);
        player.moveRight();
        assertEquals(11, player.getPosX());
    }

    @Test
    public void validMoveLeftTest() {
        player.setPosition(map, 10, 5);
        player.moveLeft();
        assertEquals(9, player.getPosX());
    }

    @Test
    public void validMoveDownTest() {
        player.setPosition(map, 10, 5);
        player.moveDown();
        assertEquals(6, player.getPosY());
    }

    @Test
    public void validMoveUpTest() {
        player.setPosition(map, 10, 5);
        player.moveUp();
        assertEquals(4, player.getPosY());
    }

    @Test
    public void stepsLeftTest() {
        player.setPosition(map, 10, 5);
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
        player.moveRight();
        assertEquals(DEFAULT_TEST_SPEED-1, player.getStepsLeft());
        player.moveLeft();
        player.moveUp();
        player.moveDown();
        assertEquals(DEFAULT_TEST_SPEED-4, player.getStepsLeft());
    }

    @Test
    public void invalidMoveRightTest() {
        player.setPosition(map, SIZE_X-1, 5);
        player.moveRight();
        assertEquals(SIZE_X-1, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveLeftTest() {
        player.setPosition(map, 0, 5);
        player.moveLeft();
        assertEquals(0, player.getPosX());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveDownTest() {
        player.setPosition(map, 10, SIZE_Y-1);
        player.moveDown();
        assertEquals(SIZE_Y-1, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void invalidMoveUpTest() {
        player.setPosition(map, 10, 0);
        player.moveUp();
        assertEquals(0, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED, player.getStepsLeft());
    }

    @Test
    public void simpleMoveTest() {
        player.setPosition(map, 10, 5);
        player.move(Directions.DOWN, Directions.DOWN, Directions.RIGHT);
        assertEquals(11, player.getPosX());
        assertEquals(7, player.getPosY());
        assertEquals(DEFAULT_TEST_SPEED-3, player.getStepsLeft());
    }
}
