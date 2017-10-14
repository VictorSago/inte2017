package dsv.inte2017g11.roguelib.Items;
/*
PotionItem is a subclass of the item class
it takes name, power and effect as argument when created
power - how much effect will it have when used
effect - what attribute of a character will it effect when used
 */
public class PotionItem extends Item {

    private int power;
    private Effect effect;


    public PotionItem(String name, int power, Effect effect) {
        super(name, 0);
        this.power = power;
        if(effect!=null) {
            this.effect = effect;
        } else {
            throw new IllegalArgumentException("Effect can't be null");
        }
    }

    public int getPower(){
        return power;
    }

    @Override
    public Effect getEffect(){
        return effect;
    }
}
