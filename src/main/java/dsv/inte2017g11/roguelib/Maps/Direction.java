package dsv.inte2017g11.roguelib.Maps;

import org.jetbrains.annotations.Contract;

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

    @Contract(pure = true)
    public int deltaX() {
        return deltaX;
    }

    @Contract(pure = true)
    public int deltaY() {
        return deltaY;
    }
}
