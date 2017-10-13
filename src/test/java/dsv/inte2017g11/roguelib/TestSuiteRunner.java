package dsv.inte2017g11.roguelib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * test suit used for testing of all of the
 * classes in our game implemented so far,
 * that is GameCharacter, GameMap and Tile
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GameCharacterTest.class, TileTest.class, GameMapTest.class})
public class TestSuiteRunner {
}
