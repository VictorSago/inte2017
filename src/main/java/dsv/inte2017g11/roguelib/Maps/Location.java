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

    public Location addXY(int x, int y) {
        posX += x;
        posY += y;
        return this;
    }

    public Location displace(int deltaX, int deltaY) {
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
