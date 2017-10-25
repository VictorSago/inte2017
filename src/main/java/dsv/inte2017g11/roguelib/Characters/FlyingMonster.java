package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Maps.*;
public class FlyingMonster extends Monster {

    public FlyingMonster(String name, int health, int speed, int type, int attackValue,GameMap map) {
        super(name, health, speed, type, attackValue,map);

    }

    public boolean fly(){
        return true;
    }
}
