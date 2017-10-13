package dsv.inte2017g11.roguelib.Items;

import static dsv.inte2017g11.roguelib.Items.Effect.*;

public class GearItem extends Item {

    private int weigth;
    private int gearHP;
    private Effect effect;


    public GearItem(String name, int weigth, int gearHP, Effect e) {
        super(name);
        if (weigth >= 0)
            this.weigth = weigth;
        else
            this.weigth = 0;
        if (gearHP >= 0 && e != null) {
            this.gearHP = gearHP;
            this.effect = e;
        }else
            throw new IllegalArgumentException();
    }

    public int getWeigth() {
        return weigth;
    }

    public int getGearHP() {
        return gearHP;
    }

    public Effect getEffect(){
        return effect;
    }

}
