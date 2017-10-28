package dsv.inte2017g11.roguelib.Maps;

import dsv.inte2017g11.roguelib.Entities.GamePlayer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MapWithEntitiesTest {

    private final int MAP_SIZE_X = 200;
    private final int MAP_SIZE_Y = 100;
    private final int POS_X = MAP_SIZE_X / 2;
    private final int POS_Y = MAP_SIZE_Y / 2;

    private GameMap map;

    @Before
    public void setUp() throws Exception {
        map = new GameMap(MAP_SIZE_X, MAP_SIZE_Y);
    }

    @Test
    public void freePositionTest1() {
        assertTrue(map.isFreePosition(POS_X, POS_Y));
    }

    @Test
    public void freePositionTest2() {
        Location location = new Location(POS_X, POS_Y);
        assertTrue(map.isFreePosition(location));
    }

    @Test
    public void addEntityTest() throws Exception {
        GamePlayer test_player = new GamePlayer("Arthur Dent");
        assertThat(map.addEntity(test_player, new Location(POS_X, POS_Y)), nullValue());
    }

    @Test
    public void removeEntityTest() throws Exception {
        GamePlayer test_player = new GamePlayer("Ford Prefect");
        map.addEntity(test_player, new Location(POS_X, POS_Y));
        assertThat(map.removeEntity(test_player), equalTo(new Location(POS_X, POS_Y)));
    }

    @Test
    public void removeNonExistingEntityTest() throws Exception {
        GamePlayer test_player = new GamePlayer("Arthur Dent");
        GamePlayer test_player2 = new GamePlayer("Tricia McMillan");
        map.addEntity(test_player, new Location(POS_X, POS_Y));
        assertThat(map.removeEntity(test_player2), nullValue());
    }

    @Test
    public void findEntityTest1() {
        GamePlayer test_player = new GamePlayer("Slartibartfast");
        MapLocation location = new MapLocation(map, POS_X, POS_Y);
        test_player.setMapLocation(map, POS_X, POS_Y);
        assertThat(map.findEntity(test_player), equalTo(location));
    }

    @Test
    public void findEntityTest2() {
        GamePlayer test_player = new GamePlayer("Zaphod Beeblebrox");
        MapLocation location = new MapLocation(map, POS_X, POS_Y);
        test_player.setMapLocation(location);
        assertThat(map.findEntity(test_player), sameInstance(location));
    }

    @Test
    public void findNonExistingEntityTest() {
        GamePlayer test_player = new GamePlayer("Marvin");
        GamePlayer test_player2 = new GamePlayer("Agrajag");
        test_player.setMapLocation(map, POS_X, POS_Y);
        assertThat(map.findEntity(test_player2), nullValue());
    }

    @Test
    public void findEntityByNameTest() {
        GamePlayer test_player = new GamePlayer("Agrajag");
        test_player.setMapLocation(map, POS_X, POS_Y);
        Location location = map.findEntityByName("Agrajag");
        assertThat("Expected Location, but method returned NULL!", location, notNullValue());
        assertThat("Should be an instance of Location!", location, instanceOf(Location.class));
        assertThat("Should be an instance of MapLocation!", location, instanceOf(MapLocation.class));
        assertThat("X-coordinate is wrong", location.getX(), is(POS_X));
        assertThat("Y-coordinate is wrong", location.getY(), is(POS_Y));
        assertThat("Equality failure", location, equalTo(new MapLocation(map, POS_X, POS_Y)));
    }

    @Test
    public void findNonExistingEntityByNameTest() {
        GamePlayer test_player = new GamePlayer("Agrajag");
        test_player.setMapLocation(map, POS_X, POS_Y);
        Location location = map.findEntityByName("Marvin");
        assertThat("Expected NULL, but method returned something else!", location, nullValue());
    }

    @Test
    public void checkMapLocationIsSameTest() {
        GamePlayer test_player = new GamePlayer("Marvin");
        test_player.setMapLocation(map, POS_X, POS_Y);
        assertThat(test_player.getMapLocation(), sameInstance(map.findEntity(test_player)));
    }

    @Test
    public void checkSameValuesAfterMove1() {
        GamePlayer test_player = new GamePlayer("Trillian");
        test_player.setMapLocation(map, POS_X, POS_Y);
        test_player.move(Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        Location location1 = map.findEntity(test_player);
        Location location2 = test_player.getMapLocation();
        assertThat("Map's Location is unequal to player's location", location1, equalTo(location2));
        assertThat("X-values differ between player's and map's locations", location1.getX(), is(POS_X + 2));
        assertThat("Y-values differ between player's and map's locations", location1.getY(), is(POS_Y + 1));
    }

    @Test
    public void checkSameValuesAfterMove2() {
        GamePlayer test_player = new GamePlayer("Random Frequent Flyer Dent");
        test_player.setMapLocation(new MapLocation(map, POS_X, POS_Y));
        test_player.move(Direction.LEFT, Direction.LEFT, Direction.UP);
        Location location1 = map.findEntity(test_player);
        Location location2 = test_player.getMapLocation();
        assertThat("Map's Location is unequal to player's location", location1, equalTo(location2));
        assertThat("X-values differ between player's and map's locations", location1.getX(), is(POS_X - 2));
        assertThat("Y-values differ between player's and map's locations", location1.getY(), is(POS_Y - 1));
    }

}
