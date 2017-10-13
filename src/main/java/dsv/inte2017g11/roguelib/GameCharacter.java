package dsv.inte2017g11.roguelib;

public class GameCharacter {

    private final String name;

    private int maxHealth;
    private int currentHealth;

    private int speed;
    private int stepsLeft;

    private GameMap map;
    private int posX;
    private int posY;

    public GameCharacter(String name, int health, int speed) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.stepsLeft = this.speed;
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
        this.speed = s;
    }

    public int getStepsLeft() {
        return stepsLeft;
    }

    public GameMap getMap() {
        return map;
    }

    public boolean setPosition(GameMap map, int x, int y) {
        if (map.isValidPosition(x, y) && map.isFreePosition(x, y)) {
            this.map = map;
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }

    public boolean setPosition(int x, int y) {
        if (this.map != null && map.isValidPosition(x, y) && map.isFreePosition(x,y)) {
            this.posX = x;
            this.posY = y;
            return true;
        } else {
            return false;
        }
    }


    public int[] getPosition() {
        int[] ret = new int[2];
        ret[0] = posX;
        ret[1] = posY;
        return ret;
    }


    public void moveDown() {
        if (validateNewPosition(posX, posY + speed)) {
            posY += speed;
        }
    }

    public void moveUp() {
        if (validateNewPosition(posX, posY - speed)) {
            posY -= speed;
        }
    }

    public void moveRight() {
        if (validateNewPosition(posX + speed, posY)) {
            posX += speed;
        }
    }

    public void moveLeft() {
        if (validateNewPosition(posX - speed, posY)) {
            posX -= speed;
        }
    }

    /**
     *  If the entered direction together with speed is a
     *  valid value for the player to move towards this may
     *  be computed
     * @param x x-coordinate of the new position
     * @param y y-coordinate of the new position
     * @return <code>true</code> if the new position is a valid one,
     * <code>false</code> otherwise
     */
    private boolean validateNewPosition(int x, int y) {
        return (map.getTile(x, y) != null);
    }
}
