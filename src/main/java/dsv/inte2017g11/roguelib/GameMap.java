package dsv.inte2017g11.roguelib;

public class GameMap {
    //the size x*x of the man
    private final int SIZE;
    private Tile[][] field;

    public GameMap(int size) {
        if (size > 0) {
            SIZE = size;
            fillMapField(size);
        } else throw new IndexOutOfBoundsException();
    }

    private void fillMapField(int s) {
        field = new Tile[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                field[i][j] = new Tile(i, j);
            }
        }
    }

    public Tile getPosition(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE || y > SIZE)
            throw new IndexOutOfBoundsException();
        else
            return field[x][y];
    }

    public int getSize() {
        return SIZE;
    }
}
