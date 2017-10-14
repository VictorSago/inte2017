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
    private String desc = "";

    public PotionItem(String name, int power, Effect effect) {
        super(name, 0);
        this.power = power;
        if (effect != null) {
            this.effect = effect;
        } else {
            throw new IllegalArgumentException("Effect can't be null");
        }
    }

    public PotionItem(String name, int power, Effect effect, String desc) {
        super(name, 0);
        this.power = power;
        if (effect != null) {
            this.effect = effect;
        } else {
            throw new IllegalArgumentException("Effect can't be null");
        }
        if (desc == null || desc.equals("") || desc.isEmpty())
            this.desc = "no description available";
        else
            this.desc = desc;
    }

    public int getPower() {
        return power;
    }

    public String getDescription() {
        if (desc.isEmpty())
            return "no description available";
        else
            return desc;
    }

    @Override
    public Effect getEffect() {
        return effect;
    }
}
