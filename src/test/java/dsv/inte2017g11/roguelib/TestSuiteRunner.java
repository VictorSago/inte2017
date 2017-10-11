package dsv.inte2017g11.roguelib;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
test suit used for testing of all the
so far implemented classes in our game
that is Character, Map and Position
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({CharacterTest.class, TileTest.class, GameMapTest.class})
public class TestSuiteRunner {
}
