package dsv.inte2017g11.roguelib;

public class GameMap {
    private final int sizeX;
    private final int sizeY;

    public GameMap(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
    }

    public boolean isFree(int x, int y) {
        return true;
    }

    public boolean isLegal(int x, int y) {
        return x > 0 && x <= sizeX && y > 0 && y <= sizeY;
    }
}
