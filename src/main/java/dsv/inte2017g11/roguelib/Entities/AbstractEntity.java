package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Maps.Directions;
import dsv.inte2017g11.roguelib.Maps.GameMap;
import dsv.inte2017g11.roguelib.Maps.MapLocation;
import dsv.inte2017g11.roguelib.Maps.MapPath;

/**
 * @author zeron
 *
 */
abstract public class AbstractEntity {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;

    private final String name;

    protected int maxHealth, currentHealth;

    private int speed, stepsRemaining;

//    private GameMap map;
//    private int posX, posY;

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
/*

    public boolean setPosition(GameMap map, int x, int y) {
        if (isValidPosition(map, x, y)) {
            this.map = map;
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPosition(int x, int y) {
        return setPosition(this.map, x, y);
    }
*/

    /*public boolean setPosition(GameMap map, int x, int y) {
        if (map != null && map.isValidPosition(x, y) && map.isFreePosition(x, y)) {
            this.map = map;
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }*/

    protected boolean moveStep(Directions dir) {
        if (stepsRemaining > 0) {
            switch (dir) {
                case RIGHT:
                    try {
                        location.addXY(1, 0);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case LEFT:
                    try {
                        location.addXY(-1, 0);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case DOWN:
                    try {
                        location.addXY(0, 1);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                case UP:
                    try {
                        location.addXY(0, -1);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
            }
            return false;
        }
        return false;
    }


/*
    protected void moveStep(Directions dir) {
        if (stepsRemaining > 0) {
            switch (dir) {
                case RIGHT:
                    if (isValidPosition(posX + 1, posY)) {
                        location.displaceOnMap(1, 0);
                        stepsRemaining--;
                    }
                    break;
                case LEFT:
                    if (isValidPosition(posX - 1, posY)) {
                        location.displaceOnMap(-1, 0);
                        stepsRemaining--;
                    }
                    break;
                case DOWN:
                    if (isValidPosition(posX, posY + 1)) {
                        location.displaceOnMap(0, 1);
                        stepsRemaining--;
                    }
                    break;
                case UP:
                    if (isValidPosition(posX, posY - 1)) {
                        location.displaceOnMap(0, -1);
                        stepsRemaining--;
                    }
                    break;
            }
        }
    }
*/

    public void move(Directions... dirs) {
        if (location == null) {
            return;
        }
        for (Directions d : dirs) {
            if (moveStep(d)) {
                stepsRemaining--;
            }
        }
    }

    public MapPath move(MapPath path) {
        if (location == null) {
            return path;
        }
        while (!path.isEmpty()) {
            Directions nextStep = path.getNextStep();
            if (moveStep(nextStep)) {
                stepsRemaining--;
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
     *  If the enterred direction together with speed is a
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

