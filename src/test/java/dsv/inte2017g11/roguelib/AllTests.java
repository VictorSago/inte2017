package dsv.inte2017g11.roguelib;


import dsv.inte2017g11.roguelib.Entities.EntityTestSuite;
import dsv.inte2017g11.roguelib.Items.ItemTestSuite;
import dsv.inte2017g11.roguelib.Maps.MapTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ItemTestSuite.class, MapTestSuite.class, EntityTestSuite.class})
public class AllTests {
}
