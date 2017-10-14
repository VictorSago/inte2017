package dsv.inte2017g11.roguelib.Items;

import static dsv.inte2017g11.roguelib.Items.Effect.DAMAGE;

public class WeaponItem extends Item {

    private int power;
    private Effect effect = DAMAGE;

    public WeaponItem(String name, int weight, int power){
        super(name, weight);
        if(power>0)
            this.power=power;
        else
            throw new IllegalArgumentException();
    }

    public WeaponItem(String name, int weight, int power, String desc){
        super(name, weight, desc);
        if(power>0)
            this.power=power;
        else
            throw new IllegalArgumentException();
    }

    public int getPower(){
        return power;
    }

    @Override
    public Effect getEffect() {
        return effect;
    }

}
