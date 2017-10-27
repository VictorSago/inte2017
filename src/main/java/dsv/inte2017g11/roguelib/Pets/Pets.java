package dsv.inte2017g11.roguelib.Pets;

public class Pets {
    private String name;
    private int currentHealth;
    private int currentDamage;
    private int maxHealth;
    private int level;
    private boolean available;

    public Pets(String name, int health, int damage) {
        this.name = name;
        this.currentHealth = health;
        this.maxHealth = currentHealth;
        this.currentDamage = damage;
        this.level = 1;
        this.available = true;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentDamage() {
        return currentDamage;
    }

    public String getName() {
        return this.name;
    }

    public void newName(String newName) {
        this.name = newName;
    }

    public void takeDamage(int enemyDamage) {
        currentHealth -= enemyDamage;
        if (currentHealth<0){
            currentHealth = 0;
        }
        if(currentHealth==0){
            deadPet();
        }
    }

    private void deadPet() {
        available=false;
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

    //TODO fylla upp currentHealth vid levelup?
    public void levelUp() {
        level+=1;
        maxHealth+=10;
        currentDamage+=5;
    }

    public boolean isAvailable() {
        return available;
    }

    public void revive() {
        available=true;
        currentHealth=10;
    }

    public void phoenixDown() {
        available=true;
        currentHealth=maxHealth;
    }

}
