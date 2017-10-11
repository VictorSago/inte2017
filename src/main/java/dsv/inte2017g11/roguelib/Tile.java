package dsv.inte2017g11.roguelib;

public class Tile {
    private int x;
    private int y;


    public Tile(int x, int y) {
        if (x >= 0 && y >= 0) {
            this.x = x;
            this.y = y;
        } else throw new IndexOutOfBoundsException("Invalid cord");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (x * 31) + (y * 17);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
            Tile p = (Tile) o;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }
}
