package dsv.inte2017g11.roguelib.Items;

public abstract class Item {

    private String name;
    private int weight;
    private String description ="";
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

    public Item(String name, int weight, String desc) {
        this(name, weight);
        if (desc == null || desc.equals("") || desc.isEmpty())
            this.description = "no description available";
        else
            this.description = desc;
    }

    public String getName(){
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        if (description.isEmpty())
            return "no description available";
        else
            return description;
    }

    abstract public Effect getEffect();

}
