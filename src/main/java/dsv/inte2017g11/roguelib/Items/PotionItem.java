package dsv.inte2017g11.roguelib.Items;

public class PotionItem extends Item {

    private int power;
    private Effect effect;

    public PotionItem(String name, int power, Effect effect) {
        super(name);
        this.power = power;
        if(effect!=null)
        this.effect = effect;
        else
            throw new IllegalArgumentException();
    }

    public int getPower(){
        return power;
    }

    public Effect getEffect(){
        return effect;
    }
}
