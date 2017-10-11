package dsv.inte2017g11.roguelib;

public class Character {
    private final String name;
    private int health;
    private int speed;

    private GameMap map;
    private int posX;
    private int posY;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public boolean setPosition(int x, int y) {
        if (map.isLegal(x, y) && map.isFree(x, y)) {
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

    public boolean move(int x, int y) {
        if (map.isLegal(posX + x, posY + y) && map.isFree(posX + x, posY + y)) {
            this.posX = posX + x;
            this.posY = posY + y;
            return true;
        } else {
            return false;
        }
    }
}
