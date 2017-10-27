package dsv.inte2017g11.roguelib.Maps;

public class Location {

    protected int posX, posY;

    public Location(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public void setXYPos(int x, int y) {
        posX = x;
        posY = y;
    }

    public void setXYPos(Location loc) {
        setXYPos(loc.getX(), loc.getY());
    }

    /**
     * Displaces current location by <code>deltaX</code> steps 
     * horizontally and <code>deltaY</code> steps vertically.
     * @param deltaX - horizontal displacement
     * @param deltaY - vertical displacement
     * @return This object with the new coordinates.
     */
    public Location displace(int deltaX, int deltaY) {
        posX += deltaX;
        posY += deltaY;
        return this;
    }

    /**
     * Creates a new <code>Location</code> object by adding 
     * supplied parameters to this object's coordinates. 
     * Leaves the original object unchanged.
     * @param deltaX horizontal displacement
     * @param deltaY vertical displacement
     * @return New <code>Location</code> object with new coordinates.
     */
    public Location addXY(int deltaX, int deltaY) {
        return new Location(posX + deltaX, posY + deltaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (o instanceof Location) {
            Location otherLocation = (Location) o;
            return posX == otherLocation.posX && posY == otherLocation.posY;
        }
        return false;
    }

    /**
     * This implementation of hashCode is based on Matthew Szudzik's
     * pairing function, <url>http://szudzik.com/ElegantPairing.pdf</url>.
     * @return A hash code value for this Location object
     */
    @Override
    public int hashCode() {
        int a = posX >= 0 ? 2 * posX : -2 * posX - 1;
        int b = posY >= 0 ? 2 * posY : -2 * posY - 1;
        return  a >= b ? a * a + a + b : a + b * b;
    }

    @Override
    public String toString() {
        return "(" + posX + ", " + posY + ")";
    }
}
