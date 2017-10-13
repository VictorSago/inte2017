package dsv.inte2017g11.roguelib.Items;

public abstract class Item {

    private String name;

    public Item(String name){
        this.name = name;
    }



    public String getName(){
        return name;
    }

}
