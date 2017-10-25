package dsv.inte2017g11.roguelib.Entities;

public class FlyingMonster extends Monster {

    public FlyingMonster(String name, int health, int speed, int type, int attackValue) {
        super(name, health, speed, type, attackValue);

    }

    public boolean fly(){
        return true;
    }
}
