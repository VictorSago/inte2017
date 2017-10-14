package dsv.inte2017g11.roguelib.Items;

public abstract class Item {

    private String name;
    private int weight;
    protected Effect effect;


    public Item(String name, int weight) {
        if (name.equals(""))
            throw new IllegalArgumentException("Names can't be empty");
        this.name = name;
        if (weight >= 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    public String getName(){
        return name;
    }

    public int getWeight() {
        return weight;
    }

    abstract public Effect getEffect();

}
