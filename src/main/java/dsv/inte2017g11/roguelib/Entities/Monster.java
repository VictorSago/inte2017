package dsv.inte2017g11.roguelib.Entities;

public class Monster extends AbstractEntity {

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


    /*public void attack(Tile t){
        for(AbstractEntity c : t.getCharacters()){
            if (!c.equals(this)){
                c.damage(attackValue);
            }
        }
    }*/
}
