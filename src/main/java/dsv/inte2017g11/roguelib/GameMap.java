package dsv.inte2017g11.roguelib;

public class GameMap {

    private final int sizeX;
    private final int sizeY;
    private Tile[][] tiles;

    public GameMap(int sizeX, int sizeY) {
        if (sizeX > 0 && sizeY > 0) {
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            fillMapField(sizeX, sizeY);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void fillMapField(int sX, int sY) {
        tiles = new Tile[sX][sY];
        for (int i = 0; i < sX; i++) {
            for (int j = 0; j < sY; j++) {
                tiles[i][j] = new Tile(this);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x > sizeX || y > sizeY) {
            throw new IndexOutOfBoundsException();
        } else {
            return tiles[x][y];
        }
    }

    public int getTilePositionX(Tile t) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (tiles[i][j].getId() == t.getId()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int getTilePositionY(Tile t) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (tiles[i][j].getId() == t.getId()) {
                    return j;
                }
            }
        }
        return -1;
    }

    public int getSize() {
        return sizeX * sizeY;
    }

    public boolean isFreePosition(int x, int y) {
        return true;
    }

    public boolean isValidPosition(int x, int y) {
        return x > 0 && x <= sizeX && y > 0 && y <= sizeY;
    }

    public int hashCode() {
        return (sizeX * 31) + (sizeY * 17);
    }

}
