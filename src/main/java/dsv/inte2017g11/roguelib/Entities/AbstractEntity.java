package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Maps.*;
import org.jetbrains.annotations.Contract;

/**
 * @author zeron
 *
 */
abstract public class AbstractEntity {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;

    private final String name;

    protected int maxHealth, currentHealth;

    protected int maxSpeed, stepsRemaining;

    private MapLocation location;

    @Contract("null, _, _ -> fail")
    public AbstractEntity(String name, int health, int speed) {
        if (name == null) {
            throw new IllegalArgumentException("Names can't be NULL!");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Names can't be EMPTY!");
        }
        this.name = name;
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be a positive number!");
        }
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.maxSpeed = speed;
        this.stepsRemaining = maxSpeed;
    }

    @Contract("null, _ -> fail")
    public AbstractEntity(String name, int health) {
        this(name, health, DEFAULT_SPEED);
    }

    @Contract("null -> fail")
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

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int s) {
        int oldSpeed = maxSpeed;
        if (s < 0) {
            maxSpeed = 0;
        } else {
            maxSpeed = s;
        }
        stepsRemaining += maxSpeed - oldSpeed;
        if (stepsRemaining < 0) {
            stepsRemaining = 0;
        }
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }

    public void resetSteps() {
        stepsRemaining = maxSpeed;
    }

    public MapLocation getMapLocation() {
        return location;
    }

    /**
     * Sets Location for this entity to map <code>map</code> and
     * coordinates <code>x</code> and <code>y</code>, if they are valid.<br>
     * <p>The operation of this method is as follows:
     * <ul>
     *     <li>If this entity doesn't yet have a location, then </li>
     *     <ol>
     *         <li>set this entity's location to the new <code>MapLocation</code> object</li>
     *         <li>add this entity and location to <code>map.entities</code> table</li>
     *     </ol>
     *     <li>If this entity already has a location and it is on the same map, then </li>
     *     <ol><li>change the location's coordinates to those supplied with the arguments</li></ol>
     *     <li>Otherwise, if this entity has a location on a different map, then </li>
     *     <ol>
     *         <li>remove this entity from the old map,</li>
     *         <li>set the location's coordinates and map to those supplied with the arguments, and </li>
     *         <li>add this entity and location to <code>map.entities</code> table</li>
     *     </ol>
     * </ul></p>
     * @param map - The map to which the location refers
     * @param x - x-coordinate of the new location
     * @param y - y-coordinate of the new location
     */
    public void setMapLocation(GameMap map, int x, int y) {
        if (location == null) {
            location = new MapLocation(map, x, y);
            map.addEntity(this, location);
        } else {
            if (location.getMap().equals(map)) {
                location.setMapXYPos(map, x, y);
            } else {
                location.getMap().removeEntity(this);
                location.setMapXYPos(map, x, y);
                map.addEntity(this, location);
            }
        }
    }

    public void setMapLocation(MapLocation loc) {
        if (location == null) {
            location = loc;
            location.getMap().addEntity(this, location);
        } else {
            if (location.getMap().equals(loc.getMap())) {
                location = loc;
            } else {
                location.getMap().removeEntity(this);
                location = loc;
                location.getMap().addEntity(this, location);
            }
        }
        // put or replace the value in map.entities with loc
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

}

