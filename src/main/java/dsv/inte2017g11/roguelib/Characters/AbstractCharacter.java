package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Maps.Directions;
import dsv.inte2017g11.roguelib.Maps.GameMap;
import dsv.inte2017g11.roguelib.Maps.MapPath;





/**
 * @author zeron
 *
 */
abstract public class AbstractCharacter {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;

    private final String name;

    private int maxHealth, currentHealth;


    private int speed, stepsRemaining;


    private GameMap map;
    private int posX, posY;


    public AbstractCharacter(String name, int health, int speed) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.stepsRemaining = this.speed;
    }

    public AbstractCharacter(String name, int health) {
        this(name, health, DEFAULT_SPEED);
    }

    public AbstractCharacter(String name) {
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

    public void healCharacter(int healingPoint) {
        currentHealth += healingPoint;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public void hurtCharacter(int damagePoint) {
        currentHealth -= damagePoint;
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

    public GameMap getMap() {
        return map;
    }

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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    
    /**
     * Return the position as a single number, counting from 
     * the upper left corner down to the character's position, 
     * going from left to right and from up to down.
     * @return The number of steps from the upper left corner 
     * of the map to the current position on the map. <br>
     * If there is no map present then <code>-1</code> is returned.
     */
    /*public int getPosition() {
        if (map != null) {
            return posY * map.getWidth() + posX;
        } else {
            return -1;
        }
    }*/

    /*protected void moveRight() {
        if (isValidPosition(posX + 1, posY)) {
            posX++;
            stepsRemaining--;
        }
    }

    protected void moveLeft() {
        if (isValidPosition(posX - 1, posY)) {
            posX--;
            stepsRemaining--;
        }
    }

    protected void moveDown() {
        if (isValidPosition(posX, posY + 1)) {
            posY++;
            stepsRemaining--;
        }
    }

    protected void moveUp() {
        if (isValidPosition(posX, posY - 1)) {
            posY--;
            stepsRemaining--;
        }
    }*/

    protected void moveStep(Directions dir) {
        if (stepsRemaining > 0) {
            switch (dir) {
                case RIGHT:
                    if (isValidPosition(posX + 1, posY)) {
                        posX++;
                        stepsRemaining--;
                    }
                    break;
                case LEFT:
                    if (isValidPosition(posX - 1, posY)) {
                        posX--;
                        stepsRemaining--;
                    }
                    break;
                case DOWN:
                    if (isValidPosition(posX, posY + 1)) {
                        posY++;
                        stepsRemaining--;
                    }
                    break;
                case UP:
                    if (isValidPosition(posX, posY - 1)) {
                        posY--;
                        stepsRemaining--;
                    }
                    break;
            }
        }
    }

    public void move(Directions... dirs) {
        if (map == null) {
            return;
        }
        for (Directions d : dirs) {
            moveStep(d);
        }
    }

    public MapPath move(MapPath path) {
        if (map == null) {
            return path;
        }
        while (!path.isEmpty()) {
            Directions nextStep = path.getNextStep();
            moveStep(nextStep);
            }
        return path;
    }

    protected boolean isValidPosition(int x, int y) {
        return isValidPosition(map, x, y);
    }

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
        if (map != null) {
            return (map.getTile(x, y) != null && map.isValidPosition(x, y) && map.isFreePosition(x, y));
        } else {
            return false;
        }
    }

}

