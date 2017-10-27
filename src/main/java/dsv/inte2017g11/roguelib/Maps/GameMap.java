package dsv.inte2017g11.roguelib.Maps;

import dsv.inte2017g11.roguelib.Entities.AbstractEntity;
import dsv.inte2017g11.roguelib.Items.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMap {

    private final int TERRAIN_HIGHEST = 10;

    private final int width;
    private final int height;
    private Tile[][] tiles;

    private Map<Item, Location> items;
    private Map<AbstractEntity, Location> entities;

    private Random rand = new Random();

    public GameMap(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("A map's width and height must be positive.");
        }
        this.width = width;
        this.height = height;
        generateTerrain(width,height);
        items = new HashMap<>();
        entities = new HashMap<>();
    }

    private void generateTerrain(int sizeX, int sizeY) {
        tiles = new Tile[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tiles[i][j] = new Tile(rand.nextInt(TERRAIN_HIGHEST));
            }
        }
    }

    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    // @TODO Implement
    public boolean isFreePosition(int x, int y) {
        return true;
    }

    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public boolean isValidPosition(Location loc) {
        return isValidPosition(loc.getX(), loc.getY());
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        } else {
            return tiles[x][y];
        }
    }

    @Override
    public String toString() {
        return "GameMap{" + width + "x" + height +"}";
    }
}
