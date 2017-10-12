package dsv.inte2017g11.roguelib;

public class Tile {
   


    public Tile() {
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return 1500;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
           return true;
        }
        return false;
    }
}
