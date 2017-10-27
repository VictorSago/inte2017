package dsv.inte2017g11.roguelib.Characters;
import dsv.inte2017g11.roguelib.Maps.Tile;


public class Monster extends AbstractCharacter{

    private int type;
    private int attackValue;

    public Monster(String name, int health, int speed, int type, int attackValue) {
        super(name, health, speed);
        this.attackValue = attackValue;

    }

    public void attack(Tile t) {
        for (AbstractCharacter c : t.getCharacters()) {
            if (!c.equals(this)) {
                c.hurtCharacter(attackValue);
            }
        }
    }
    public void attack(Monster m){
        m.hurtCharacter(attackValue);
    }
}