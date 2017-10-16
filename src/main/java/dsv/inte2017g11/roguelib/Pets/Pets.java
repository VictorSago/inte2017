package dsv.inte2017g11.roguelib.Pets;

public class Pets {
    private String name;
    private int currentHealth;
    private int currentSpeed;

    public Pets(String name, int health, int speed) {
        this.name = name;
        this.currentHealth = health;
        this.currentSpeed = speed;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}
