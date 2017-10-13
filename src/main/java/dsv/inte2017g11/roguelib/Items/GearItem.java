package dsv.inte2017g11.roguelib.Items;

/*
GearItem is a subclass of the item class
it takes name, weigth, gearHP and effect as argument
the gearHP is how much hp the gear has
effect is going to be implemented to not only give addition to the
  characters health when being equipped but also to affect another
  ability(more magic, slows down, lowers strength etc)
 */

public class GearItem extends Item {

    private int weight;
    private int gearHP;
    private Effect effect;

    public GearItem(String name, int weight, int gearHP, Effect e) {
        super(name);
        if (weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        if (gearHP >= 0 && e != null) {
            this.gearHP = gearHP;
            this.effect = e;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getGearHP() {
        return gearHP;
    }

    @Override
    public Effect getEffect(){
        return effect;
    }

}
