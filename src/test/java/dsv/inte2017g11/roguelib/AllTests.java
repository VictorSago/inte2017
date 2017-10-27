package dsv.inte2017g11.roguelib;


import dsv.inte2017g11.roguelib.Characters.CharacterTestSuite;
import dsv.inte2017g11.roguelib.Characters.MonsterTests;
import dsv.inte2017g11.roguelib.Items.ItemTestSuite;
import dsv.inte2017g11.roguelib.Maps.MapTestSuite;

import dsv.inte2017g11.roguelib.Characters.PetTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ItemTestSuite.class, MapTestSuite.class, CharacterTestSuite.class})
public class AllTests {
}
