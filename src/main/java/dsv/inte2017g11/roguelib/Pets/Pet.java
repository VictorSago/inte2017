package dsv.inte2017g11.roguelib.Pets;

public class Pet {
    private String name;

    private int maxHealth, currentHealth;
    private int currentSpeed;

    private int level;


    public Pet(String name, int health, int speed) {
        this.name = name;
        this.currentHealth = health;
        this.maxHealth = currentHealth;
        this.currentSpeed = speed;
        this.level = 1;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public String getName() {
        return this.name;
    }

    public void newName(String newName) {
        this.name = newName;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth<0){
            currentHealth = 0;
        }
    }


    public int getMaxHealth() {
        return maxHealth;
    }

    public void heal(int healItem) {
        if(isAvailable()) {
            currentHealth += healItem;
            if (currentHealth > maxHealth) {
                currentHealth = maxHealth;
            }
        }
    }

    public int getLevel() {
        return level;
    }

    //TODO kan speed öka? fylla upp currentHealth vid levelup?
    public void levelUp() {
        level += 1;
        maxHealth += 10;
    }

    public boolean isAvailable() {
        return currentHealth > 0;
    }

    public void revive() {
        if (currentHealth == 0) {
            currentHealth = 10;
        }
    }

    public void phoenixDown() {
        if (currentHealth == 0) {
            currentHealth = maxHealth;
        }
    }

}
