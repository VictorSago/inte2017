package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Maps.*;

/**
 * @author zeron
 *
 */
abstract public class AbstractEntity {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;

    private final String name;

    protected int maxHealth, currentHealth;

    protected int speed, stepsRemaining;

    private MapLocation location;

    public AbstractEntity(String name, int health, int speed) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.stepsRemaining = this.speed;
    }

    public AbstractEntity(String name, int health) {
        this(name, health, DEFAULT_SPEED);
    }

    public AbstractEntity(String name) {
        this(name, DEFAULT_MAX_HEALTH, DEFAULT_SPEED);
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void heal(int healPoints) {
        if (isAlive()) {
            currentHealth += healPoints;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth;
            }
        }
    }

    public void damage(int damagePoints) {
        currentHealth -= damagePoints;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        int oldSpeed = speed;
        if (s < 0) {
            speed = 0;
        } else {
            speed = s;
        }
        stepsRemaining += speed - oldSpeed;
        if (stepsRemaining < 0) {
            stepsRemaining = 0;
        }
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }

    public void resetSteps() {
        stepsRemaining = speed;
    }

    public MapLocation getMapLocation() {
        return location;
    }

    public void setMapLocation(GameMap map, int x, int y) {
        if (location == null) {
            location = new MapLocation(map, x, y);
        } else {
            location.setMapXYPos(map, x, y);
        }
    }

    public void setMapLocation(MapLocation loc) {
        location = loc;
    }

    public void setLocation(int x, int y) {
        if (location == null) {
            throw new NullPointerException("Must have a map to set a location.");
        } else {
            location.setXYPos(x, y);
        }
    }

    public GameMap getMap() {
        if (location != null) {
            return location.getMap();
        } else {
            return null;
        }
    }

    public int getPosX() {
        return location.getX();
    }

    public int getPosY() {
        return location.getY();
    }

    /**
     * Move a step in the <code>dir</code> direction.<br>
     * The operation of this method is as follows:
     * <ol>
     * <li> Check if there are any steps left </li>
     * <li> If there are, then construct a new location from the current one and the direction <code>dir</code></li>
     * <li> Check if the newly constructed location is valid and free on the current map</li>
     * <li> If it is, then set the current location on the map to new coordinates</li>
     * <li> and return <code>success</code></li>
     * <li> In all other cases - if any of the checks fail - return <code>failure</code></li>
     * </ol>
     * 
     * @param dir - direction of movement
     * @return <code>true</code> if the step was possible, 
     * <code>false</code> otherwise
     */
    protected boolean moveStep(Direction dir) {
        if (stepsRemaining > 0) {
            Location newLocation = location.addXY(dir.deltaX(), dir.deltaY());
            if (location.getMap().isValidPosition(newLocation) && location.getMap().isFreePosition(newLocation)) {
                location.setXYPos(newLocation);
                return true;
            }
        }
        return false;
    }


    public void move(Direction... dirs) {
        if (location == null) {
            return;
        }
        for (Direction d : dirs) {
            if (moveStep(d)) {
                stepsRemaining--;
            } else {
                return;
            }
        }
    }

    public MapPath move(MapPath path) {
        if (location == null) {
            return path;
        }
        while (!path.isEmpty()) {
            Direction nextStep = path.getNextStep();
            if (moveStep(nextStep)) {
                path.removeNextStep();
                stepsRemaining--;
            } else {
                break;
            }
        }
        return path;
    }

/*
    protected boolean isValidPosition(int x, int y) {
        return isValidPosition(map, x, y);
    }
*/

    /**
     *  Test whether the parameters point to a valid position
     *  If the entered direction together with speed is a
     *  valid value for the player to move towards this may
     *  be computed
     *
     *  @param map the map whose position is being tested
     *  @param x x-coordinate of the new position
     *  @param y y-coordinate of the new position
     *  @return <code>true</code> if and only if the map exists and the
     *  new position is a valid one, <code>false</code> in all other cases
     */
    protected boolean isValidPosition(GameMap map, int x, int y) {
        return map != null && (map.getTile(x, y) != null && map.isValidPosition(x, y) && map.isFreePosition(x, y));
    }

}

