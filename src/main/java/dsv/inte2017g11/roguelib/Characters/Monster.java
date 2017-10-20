package dsv.inte2017g11.roguelib.Characters;

public class Monster extends AbstractCharacter{

    private int type;
    private int attackValue;

    public Monster(String name, int health, int speed, int type, int attackValue) {
        super(name, health, speed);
        this.type = type;
        this.attackValue = attackValue;

    }

    public int getType(){
        return type;
    }


    public void attack(Monster m){
        m.hurtCharacter(attackValue);
    }
}