package dsv.inte2017g11.roguelib.Characters;

public class Pet extends AbstractCharacter implements CombatSystem{
    private int level;
    private String element;

    public Pet(String name, int health, int attackValue, String element) {
        super(name, health, attackValue);
        this.level = 1;
        this.element = element;
    }

    public int getLevel() {
        return level;
    }

    //TODO fylla upp currentHealth vid levelup?
    public void levelUp() {
        level+=1;
        setMaxHealth(getMaxHealth()+10);
        setAttackValue(getAttackValue()+5);
    }

    public boolean isAvailable() {
        boolean available = true;
        if(getCurrentHealth()==0){
            available=false;
        }
        return available;
    }


    public String getElement() {
        return element;
    }
}
