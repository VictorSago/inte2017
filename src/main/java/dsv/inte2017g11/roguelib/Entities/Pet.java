package dsv.inte2017g11.roguelib.Entities;

public class Pet extends AbstractEntity {

    private String nick;

    private int level;

    public Pet(String name, int health, int speed) {
        super(name, health, speed);
        this.nick = name;
        this.level = 1;
    }

    public String getName() {
        return nick;
    }

    public void newName(String newName) {
        this.nick = newName;
    }


    public int getLevel() {
        return level;
    }

    //TODO kan maxSpeed öka? fylla upp currentHealth vid levelup?
    public void levelUp() {
        level += 1;
        maxHealth += 10;
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
