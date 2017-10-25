package dsv.inte2017g11.roguelib.Characters;
import dsv.inte2017g11.roguelib.Maps.Tile;
import dsv.inte2017g11.roguelib.Maps.*;


public class Monster extends AbstractCharacter{

    private int type;
    private int attackValue;

    public Monster(String name, int health, int speed, int type, int attackValue,GameMap map) {
        super(name, health, speed,map);
        this.type = type;
        this.attackValue = attackValue;

    }
    public Monster(String name, int health, int speed,GameMap map) {
        super(name, health, speed, map);
    }

    public int getType(){
        return type;
    }


    public void attack(Tile t){
        for(AbstractCharacter c : t.getCharacters()){
            if (!c.equals(this)){
                c.hurtCharacter(attackValue);
            }
        }
    }
}