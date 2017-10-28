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

    private GameMap map;

    @Before
    public void setUp() throws Exception {
        map = new GameMap(MAP_SIZE_X, MAP_SIZE_Y);
    }

    @Test
    public void freePositionTest1() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        assertTrue(map.isFreePosition(x, y));
    }

    @Test
    public void freePositionTest2() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        Location location = new Location(x, y);
        assertTrue(map.isFreePosition(location));
    }

    @Test
    public void addEntityTest() throws Exception {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Arthur Dent");
        assertThat(map.addEntity(test_player, new Location(x, y)), nullValue());
    }

    @Test
    public void removeEntityTest() throws Exception {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Ford Prefect");
        map.addEntity(test_player, new Location(x, y));
        assertThat(map.removeEntity(test_player), equalTo(new Location(x, y)));
    }

    @Test
    public void getEntityLocationTest1() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Slartibartfast");
        MapLocation location = new MapLocation(map, x, y);
        test_player.setMapLocation(map, x, y);
        assertThat(map.getEntityLocation(test_player), equalTo(location));
    }

    @Test
    public void getEntityLocationTest2() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Zaphod Beeblebrox");
        MapLocation location = new MapLocation(map, x, y);
        test_player.setMapLocation(location);
        assertThat(map.getEntityLocation(test_player), sameInstance(location));
    }

    @Test
    public void checkMapLocationIsSameTest() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Marvin");
        test_player.setMapLocation(map, x, y);
        assertThat(test_player.getMapLocation(), sameInstance(map.getEntityLocation(test_player)));
    }

    @Test
    public void checkSameValuesAfterMove1() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Trillian");
        test_player.setMapLocation(map, x, y);
        test_player.move(Direction.RIGHT, Direction.DOWN, Direction.RIGHT);
        Location location1 = map.getEntityLocation(test_player);
        Location location2 = test_player.getMapLocation();
        assertThat("Map's Location is unequal to player's location", location1, equalTo(location2));
        assertThat("X-values differ between player's and map's locations", location1.getX(), is(x + 2));
        assertThat("Y-values differ between player's and map's locations", location1.getY(), is(y + 1));
    }

    @Test
    public void checkSameValuesAfterMove2() {
        int x = MAP_SIZE_X / 2;
        int y = MAP_SIZE_Y / 2;
        GamePlayer test_player = new GamePlayer("Random Frequent Flyer Dent");
        test_player.setMapLocation(new MapLocation(map, x, y));
        test_player.move(Direction.LEFT, Direction.LEFT, Direction.UP);
        Location location1 = map.getEntityLocation(test_player);
        Location location2 = test_player.getMapLocation();
        assertThat("Map's Location is unequal to player's location", location1, equalTo(location2));
        assertThat("X-values differ between player's and map's locations", location1.getX(), is(x - 2));
        assertThat("Y-values differ between player's and map's locations", location1.getY(), is(y - 1));
    }

}
