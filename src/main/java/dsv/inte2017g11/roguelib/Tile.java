package dsv.inte2017g11.roguelib;

public class Tile {

    static protected long idCounter = 0;

    private long id;

    protected boolean occupied;
    private GameMap owner;

    public Tile(GameMap map) {
        id = idCounter++;
        owner = map;
        occupied = false;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return ((int) id * 31) + (owner.hashCode() * 17);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
            Tile p = (Tile) o;
            return this.id == p.id && this.owner == p.owner;
        }
        return false;
    }

    public static long getNextId() {
        return idCounter;
    }
}
