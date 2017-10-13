package dsv.inte2017g11.roguelib;

import java.util.Random;

public class GameMap {
    //the size x*x of the man
    private final int WIDTH;
    private final int HEIGHT;
    private Tile[][] field;
    private Random rand = new Random();

    public GameMap(int width,int height) {
        if (width <= 0 || height <= 0)
        	throw new IndexOutOfBoundsException();
        this.WIDTH = width;
        this.HEIGHT = height;
        fillMapField(width,height);
    }

    private void fillMapField(int x,int y) {
        field = new Tile[x+1][y+1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {	
                field[i][j] = new Tile(randomTerrain());
            }
        }
    }
    
    private int randomTerrain(){
    	return rand.nextInt(10);
    }

    public Tile getPosition(int x, int y) {
        if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT)
            throw new IndexOutOfBoundsException();
        else
            return field[x][y];
    }

    public int getWidth() {
        return WIDTH;
    }
    
    public int getHeight() {
        return HEIGHT;
    }

    public boolean isFreePosition(int x, int y) {
        return true;
    }

    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x > WIDTH || y > HEIGHT)
            throw new IndexOutOfBoundsException();
        else
            return field[x][y];
    }
}
