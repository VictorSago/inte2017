package dsv.inte2017g11.roguelib.Maps;

import java.util.Random;

public class GameMap {

    private final int width;
    private final int height;
    private Tile[][] tiles;

    private Random rand = new Random();

    public GameMap(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("A map's width and height must be positive.");
        }
        this.width = width;
        this.height = height;
        fillMapField(width,height);
    }

    private void fillMapField(int sizeX, int sizeY) {
        tiles = new Tile[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                tiles[i][j] = new Tile(rand.nextInt(10));
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
    @SuppressWarnings("unused")
    public boolean isFreePosition(int x, int y) {
        return true;
    }

    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
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
