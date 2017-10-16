package dsv.inte2017g11.roguelib.Items;

import static dsv.inte2017g11.roguelib.Items.Effect.DAMAGE;

public class WeaponItem extends Item {

    private int power;
    private Effect effect = DAMAGE;

    public WeaponItem(String name, int weight, int power) {
        super(name, weight);
        if (power > 0)
            this.power = power;
        else
            throw new IllegalArgumentException();
    }

    public WeaponItem(String name, int weight, int power, String desc) {
        super(name, weight, desc);
        if (power > 0)
            this.power = power;
        else
            throw new IllegalArgumentException();
    }

    public int getPower() {
        return power;
    }

    @Override
    public Effect getEffect() {
        return effect;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WeaponItem) {
            return (((WeaponItem) o).getName().equals(this.getName()) &&
                    ((WeaponItem) o).getWeight() == this.getWeight() &&
                    ((WeaponItem) o).getPower() == this.getPower() &&
                    ((WeaponItem) o).getDescription().equals(this.getDescription()));
        }
        return false;
    }

}