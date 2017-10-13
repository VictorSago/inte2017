package dsv.inte2017g11.roguelib;

import java.util.Random;

public class GameMap {

    private final int width;
    private final int height;
    private Tile[][] tiles;

    private Random rand = new Random();

    public GameMap(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
        fillMapField(width,height);
    }

    private void fillMapField(int sX, int sY) {
        tiles = new Tile[sX][sY];
        for (int i = 0; i < sX; i++) {
            for (int j = 0; j < sY; j++) {
                tiles[i][j] = new Tile(randomTerrain());
            }
        }
    }
    
    private int randomTerrain(){
    	return rand.nextInt(10);
    }

    public Tile getPosition(int x, int y) {
        if (x < 0 || y < 0 || x > width || y > height) {
            throw new IndexOutOfBoundsException();
        } else {
            return tiles[x][y];
        }
    }

    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

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
}
