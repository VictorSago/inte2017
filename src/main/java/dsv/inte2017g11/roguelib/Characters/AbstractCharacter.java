package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Maps.Directions;
import dsv.inte2017g11.roguelib.Maps.GameMap;
import dsv.inte2017g11.roguelib.Maps.MapPath;
import dsv.inte2017g11.roguelib.Maps.Tile;

/**
 * @author zeron
 *
 */
/**
 * @author zeron
 *
 */
abstract public class AbstractCharacter {

    static final int DEFAULT_MAX_HEALTH = 100;
    static final int DEFAULT_SPEED = 10;
    private int damage;

    private final String name;

    private int maxHealth;
    private int currentHealth;

    private int speed;
    private int stepsLeft;

    private GameMap map;
    private int posX;
    private int posY;

    public AbstractCharacter(String name, int health, int speed,GameMap map) {
        this.name = name;
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.speed = speed;
        this.stepsLeft = this.speed;
        this.map = map;
        damage = 10;
    }

    public AbstractCharacter(String name, int health,GameMap map) {
        this(name, health, DEFAULT_SPEED,map);
    }

    public AbstractCharacter(String name,GameMap map) {
        this(name, DEFAULT_MAX_HEALTH, DEFAULT_SPEED,map);
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
            currentHealth = 0;
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
        return this.setPosition(this.map, x, y);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    public int getDmg(){
    	return damage;
    }
    
    public void changeDmg(int dmg){
    	damage += dmg;
    }

    
    /**
     * Return the position as a single number, counting from 
     * the upper left corner down to the character's position, 
     * going from left to right and from up to down.
     * @return The number of steps from the upper left corner 
     * of the map to the current position on the map. <br>
     * If there is no map present then <code>-1</code> is returned.
     */
    public int getPosition() {
        if (map != null) {
            return posY * map.getWidth() + posX;
        } else {
            return -1;
        }
    }

    protected boolean moveRight() {
        if (isValidPosition(posX + 1, posY)) {
            posX++;
            stepsLeft--;
            return true;
        }
        else
        	return false;
    }

    protected boolean moveLeft() {
        if (isValidPosition(posX - 1, posY)) {
            posX--;
            stepsLeft--;
            return true;
        }
        else
        	return false;
    }

    protected boolean moveDown() {
        if (isValidPosition(posX, posY + 1)) {
            posY++;
            stepsLeft--;
            return true;
        }
        else
        	return false;
    }

    protected boolean moveUp() {
        if (isValidPosition(posX, posY - 1)) {
            posY--;
            stepsLeft--;
            return true;
        }
        else
        	return false;
    }

    protected void moveStep(Directions dir) {
        if (stepsLeft > 0) {
            switch (dir) {
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
        return isValidPosition(this.map, x, y);
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
    
    public void reduceStepsLeft(){
    	stepsLeft--;
    }
    
    public int attack(AbstractCharacter other){
    	other.hurtCharacter(damage);
    	return damage;
    }
    
    public boolean tic(int i){
    	
    	return true;
    }
    
    @Override
    public String toString(){
    	return "Hp: "+currentHealth+" Dmg: "+damage+" Current Position  x: "+posX+" y: "+posY;
    }

}

