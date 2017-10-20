package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Directions;
import dsv.inte2017g11.roguelib.GameMap;

abstract public class AbstractCharacter {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;

    private final String name;

    private int maxHealth;
    private int currentHealth;

    private int speed;
    private int stepsLeft;

    private GameMap map;
    private int posX;
    private int posY;

    public AbstractCharacter(String name, int health, int speed) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.stepsLeft = this.speed;
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

    public void healCharacter(int healingpoint) {
        if (currentHealth + healingpoint > maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth += healingpoint;
        }
    }

    public void hurtCharacter(int damagepoint) {
        if (currentHealth - damagepoint < 0) {
            currentHealth = -1;
        } else {
            currentHealth -= damagepoint;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        int oldSpeed = this.speed;
        if (s < 0) {
            this.speed = 0;
        } else {
            this.speed = s;
        }
        this.stepsLeft += this.speed - oldSpeed;
        if (this.stepsLeft < 0) {
            this.stepsLeft = 0;
        }
    }

    public int getStepsLeft() {
        return stepsLeft;
    }

    public void resetSteps() {
        stepsLeft = speed;
    }

    public GameMap getMap() {
        return map;
    }

    public boolean setPosition(GameMap map, int x, int y) {
        if (map != null && map.isValidPosition(x, y) && map.isFreePosition(x, y)) {
            this.map = map;
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPosition(int x, int y) {
        if (this.map != null && map.isValidPosition(x, y) && map.isFreePosition(x, y)) {
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosition() {
        if (map != null) {
            return posY * map.getWidth() + posX;
        } else {
            return -1;
        }
    }

    /* @FIXME NullPointerException when there is no map */
    public void moveRight() {
        if (stepsLeft > 0 && validateNewPosition(posX + 1, posY)) {
            posX++;
            stepsLeft--;
        }
    }

    /* @FIXME NullPointerException when there is no map */
    public void moveLeft() {
        if (stepsLeft > 0 && validateNewPosition(posX - 1, posY)) {
            posX--;
            stepsLeft--;
        }
    }

    /* @FIXME NullPointerException when there is no map */
    public void moveDown() {
        if (stepsLeft > 0 && validateNewPosition(posX, posY + 1)) {
            posY++;
            stepsLeft--;
        }
    }

    /* @FIXME NullPointerException when there is no map */
    public void moveUp() {
        if (stepsLeft > 0 && validateNewPosition(posX, posY - 1)) {
            posY--;
            stepsLeft--;
        }
    }

    /* @FIXME NullPointerException when there is no map */
    public void move(Directions... dirs) {
        for (Directions d : dirs) {
            switch (d) {
                case RIGHT:
                    moveRight();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case UP:
                    moveUp();
                    break;
            }
        }
    }


    /**
     * If the entered direction together with speed is a
     * valid value for the player to move towards this may
     * be computed
     *
     * @param x x-coordinate of the new position
     * @param y y-coordinate of the new position
     * @return <code>true</code> if the new position is a valid one,
     * <code>false</code> otherwise
     */
    private boolean validateNewPosition(int x, int y) {
        return (map.getTile(x, y) != null);
    }

}

