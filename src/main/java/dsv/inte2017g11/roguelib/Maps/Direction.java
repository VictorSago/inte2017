package dsv.inte2017g11.roguelib.Maps;

public enum Direction {
    RIGHT   (1, 0),
    LEFT    (-1, 0),
    UP      (0, -1),
    DOWN    (0, 1);

    private final int deltaX, deltaY;

    Direction(int dX, int dY) {
        this.deltaX = dX;
        this.deltaY = dY;
    }

    public int deltaX() {
        return deltaX;
    }

    public int deltaY() {
        return deltaY;
    }
}

