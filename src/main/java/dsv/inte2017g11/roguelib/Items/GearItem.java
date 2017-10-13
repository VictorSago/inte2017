package dsv.inte2017g11.roguelib.Items;

public class GearItem extends Item {

    private int weight;
    private int gearHP;
    private Effect effect;


    public GearItem(String name, int weight, int gearHP, Effect e) {
        super(name);
        if (weight >= 0)
            this.weight = weight;
        else
            this.weight = 0;
        if (gearHP >= 0 && e != null) {
            this.gearHP = gearHP;
            this.effect = e;
        }else
            throw new IllegalArgumentException();
    }

    public int getWeight() {
        return weight;
    }

    public int getGearHP() {
        return gearHP;
    }

    public Effect getEffect(){
        return effect;
    }

}
