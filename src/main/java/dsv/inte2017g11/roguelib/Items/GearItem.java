package dsv.inte2017g11.roguelib.Items;

public class GearItem extends Item {

    private int weigth;

    public GearItem(String name) {
        super(name);
    }

    public GearItem(String name, int weigth) {
        super(name);
        if (weigth > 0)
            this.weigth = weigth;
        else
            this.weigth = 0;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getEffect() {
        return 20;
    }

}
