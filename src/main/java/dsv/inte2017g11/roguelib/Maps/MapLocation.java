package dsv.inte2017g11.roguelib.Maps;

public class MapLocation extends Location {

    private GameMap map;

    public MapLocation(GameMap m, int x, int y) {
        super(x, y);
        if (m != null) {
            map = m;
        } else {
            throw new IllegalArgumentException("Cannot create a location on a NULL map.");
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

    public boolean isFree() {
        return map.isFreePosition(posX, posY);
    }

    @Override
    public void setXYPos(int x, int y) {
        if (map.isValidPosition(x, y)) {
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }

    @Override
    public void setXYPos(Location loc) {
        setXYPos(loc.getX(), loc.getY());
    }

/**
    //@Override
    public void setXYPos(int x, int y) {
        if ((x >= 0 && x < map.getWidth()) && (y >= 0 && y < map.getHeight())) {
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }
*/

    public void setMapXYPos(GameMap m, int x, int y) {
        if (m == null) {
            throw new IllegalArgumentException("Cannot set a location on a NULL map.");
        }
        if (m.isValidPosition(x, y)) {
            map = m;
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }

/**
    public void setMapXYPos(GameMap m, int x, int y) {
        if (m == null) {
            throw new IllegalArgumentException("Cannot set a location on a NULL map.");
        }
        if ((x >= 0 && x < m.getWidth()) && (y >= 0 && y < m.getHeight())) {
            map = m;
            posX = x;
            posY = y;
        } else {
            throw new IndexOutOfBoundsException("Cannot set position outside map boundaries.");
        }
    }
*/

    /**
     * Displaces current location by <code>deltaX</code> steps 
     * horizontally and <code>deltaY</code> steps vertically, 
     * if the new location is valid on the current map.
     * @return This object with the new coordinates, if the new coordinates 
     * are valid on the current map
     * @throws IndexOutOfBoundsException if the new coordinates are outside the current map
     * @see dsv.inte2017g11.roguelib.Maps.Location#displace(int, int)
     */
    @Override
    public Location displace(int deltaX, int deltaY) throws IndexOutOfBoundsException {
        int newX = posX + deltaX;
        int newY = posY + deltaY;
        if (map.isValidPosition(newX, newY)) {
            posX = newX;
            posY = newY;
            return this;
        } else {
            throw new IndexOutOfBoundsException("Result is outside map boundary.");
        }
    }

/**
    //@Override
    public Location displace(int x, int y) {
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
*/

/**
    //@Override
    public Location displace(int x, int y) {
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

    public MapLocation addMapXY(int deltaX, int deltaY) {
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
    public int hashCode() {
        int hash1 = super.hashCode();
        int hash2 = map.hashCode();
        return hash1 >= hash2 ? hash1 * hash1 + hash1 + hash2 : hash1 + hash2 * hash2;
    }

    @Override
    public String toString() {
        return map.toString() + "(" + posX + ", " + posY + ")";
    }

}
