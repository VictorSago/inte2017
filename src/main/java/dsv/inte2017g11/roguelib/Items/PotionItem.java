package dsv.inte2017g11.roguelib.Items;

public class PotionItem extends Item {

    private int power;

    public PotionItem(String name, int power) {
        super(name);
        this.power = power;
    }

    public int getPower(){
        return power;
    }

}
