package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Items.Item;

import java.util.ArrayList;
import java.util.Collection;

public class GamePlayer extends AbstractCharacter {

    private Collection<Item> inventory;

    public GamePlayer(String name, int health, int speed) {
        super(name, health, speed);
        inventory = new ArrayList<>();
    }

    public GamePlayer(String name, int health) {
        super(name, health);
        inventory = new ArrayList<>();
    }

    public GamePlayer(String name) {
        super(name);
        inventory = new ArrayList<>();
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public int getAmountOfItems(){
        return inventory.size();
    }

    /*
    NOTE : maybe this should throw a custom exception when no items
    matches the one to fetch, or return something different
    TODO handle return statement when item is non-existing
     */
    public Item getFromInventory(String itemName){
        for(Item i : inventory){
            if(i.getName().equalsIgnoreCase(itemName))
                return i;
        }
        throw new IllegalArgumentException();
    }
}
