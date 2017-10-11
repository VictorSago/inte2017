package dsv.inte2017g11.roguelib;

public class Character {
    private int maxHealth = 100;
    private String name;
    private int health;
    private int speed;
    private int x;
    private int y;
    private GameMap gameMap;

    public Character(String name, GameMap m) {
        this.name = name;
        this.health = maxHealth;
        this.speed = 1;
        this.x = 0;
        this.y = 0;
        this.gameMap = m;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void healCharacter(int healingpoint) {
        if (health + healingpoint > maxHealth)
            health = maxHealth;
        else
            health += healingpoint;
    }

    public void hurtCharacter(int damagepoint) {
        if (health - damagepoint < 0)
            health = -1;
        else
            health -= damagepoint;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        this.speed = s;
    }

    public Tile getPosition() {
        return gameMap.getPosition(x, y);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveDown() {
        if (validateNewPosition(x, y + speed))
            y += speed;
    }

    public void moveUp() {
        if (validateNewPosition(x, y - speed))
            y -= speed;
    }

    public void moveRight() {
        if (validateNewPosition(x + speed, y)) ;
        x += speed;
    }

    public void moveLeft() {
        if (validateNewPosition(x - speed, y)) {
            x -= speed;
        }
    }

    private boolean validateNewPosition(int x, int y) {
        /*
        if the entered direction together with speed is a
        valid value for the player to move towards this may
        be computed
         */
        return (gameMap.getPosition(x, y) != null);
    }
}
