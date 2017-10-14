package dsv.inte2017g11.roguelib.Items;

public class WeaponItem extends Item {

    String name;

    public WeaponItem(String name, int weight){
        super(name, 2);
    }

    @Override
    public Effect getEffect() {
        return null;
    }
}
