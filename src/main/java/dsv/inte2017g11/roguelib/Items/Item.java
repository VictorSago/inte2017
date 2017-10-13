package dsv.inte2017g11.roguelib.Items;

public abstract class Item {

    private String name;

    public Item(String name){
        if(name.equals(""))
            throw new IllegalArgumentException("names can't be empty");
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
