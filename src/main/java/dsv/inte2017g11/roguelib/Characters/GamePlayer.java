package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Items.GearItem;
import dsv.inte2017g11.roguelib.Items.Item;

import java.util.ArrayList;
import java.util.Collection;

public class GamePlayer extends AbstractCharacter {

    private Collection<Item> inventory;
    private int defence;

    public GamePlayer(String name, int health, int speed) {
        super(name, health, speed);
        inventory = new ArrayList<>();
    }

    public GamePlayer(String name, int health) {
        super(name, health);
    }

    public GamePlayer(String name) {
        super(name);
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public int getInventorySize() {
        return inventory.size();
    }

    /*
    NOTE : maybe this should throw a custom exception when no items
    matches the one to fetch, or return something different
    TODO handle return statement when item is non-existing
     */
    public Item getFromInventory(String itemName) {
        for (Item i : inventory) {
            if (i.getName().equalsIgnoreCase(itemName))
                return i;
        }
        return null;
    }

    public boolean dropItem(String item) {
        Item removeMe = getFromInventory(item);
        if (removeMe != null) {
            inventory.remove(removeMe);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void hurtCharacter(int damagePoint) {
        if(defence > damagePoint){
            //hurt gear
            defence -= damagePoint;
        }
        else if (defence == damagePoint){
            //destroy gear but don't hurt player
        }
        else if(defence < damagePoint){
            //destroy gear and hur player
        }

    }

    public int getDefence() {
        return defence;
    }

    public void equipItem(String eq) {
        Item eqItem = getFromInventory(eq);
        if (eqItem instanceof GearItem) {
            defence += ((GearItem) eqItem).getGearHP();
        }
    }

}
