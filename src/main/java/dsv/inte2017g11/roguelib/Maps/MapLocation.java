package dsv.inte2017g11.roguelib.Maps;

public class MapLocation extends Location {

    private GameMap map;

    public MapLocation(GameMap m, int x, int y) {
        super(x, y);
        if (m != null) {
            map = m;
        } else {
            throw new NullPointerException("Cannot create a location on a NULL map.");
        }
        if (x < 0) {
            posX = 0;
        } else if (x >= map.getWidth()) {
            posX = map.getWidth() - 1;
        }
        if (y < 0) {
            posY = 0;
        } else if (y >= map.getHeight()) {
            posY = map.getHeight() - 1;
        }
    }

    public GameMap getMap() {
        return map;
    }

    @Override
    public void setXYPos(int x, int y) {
        if ((x >= 0 && x < map.getWidth()) && (y >= 0 && y < map.getHeight())) {
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }

    public void setMapXYPos(GameMap m, int x, int y) {
        if (m == null) {
            throw new NullPointerException("Cannot set a location on a NULL map.");
        }
        if ((x >= 0 && x < m.getWidth()) && (y >= 0 && y < m.getHeight())) {
            map = m;
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }

    @Override
    public Location addXY(int x, int y) {
        int newX = posX + x;
        int newY = posY + y;
        if ((newX >= 0 && newX < map.getWidth()) && (newY >= 0 && newY < map.getHeight())) {
            posX = newX;
            posY = newY;
            return this;
        } else {
            throw new IndexOutOfBoundsException("Result is outside map boundary.");
        }
    }

/*
    @Override
    public Location addXY(int x, int y) {
        posX += x;
        posY += y;
        if (posX < 0) {
            posX = 0;
        } else if (posX >= map.getWidth()) {
            posX = map.getWidth() - 1;
        }
        if (posY < 0) {
            posY = 0;
        } else if (posY >= map.getHeight()) {
            posY = map.getHeight() - 1;
        }
        return this;
    }
*/

    public MapLocation displaceOnMap(int deltaX, int deltaY) {
        return new MapLocation(map, posX + deltaX, posY + deltaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (o instanceof MapLocation) {
            MapLocation otherLocation = (MapLocation) o;
            return map.equals(otherLocation.map) && posX == otherLocation.posX && posY == otherLocation.posY;
        }
        return false;
    }

    @Override
    public int hashCode() {return 0;}

    @Override
    public String toString() {
        return map.toString() + "(" + posX + ", " + posY + ")";
    }

}
