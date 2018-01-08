package dsv.inte2017g11.roguelib.Entities;

import dsv.inte2017g11.roguelib.Items.*;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Collection;

public class GamePlayer extends AbstractEntity {

    private int attack;
    private int defence;

    private Collection<Item> inventory;
    private Collection<Item> equipment;

    public GamePlayer(String name, int health, int speed) {
        super(name, health, speed);
        inventory = new ArrayList<>();
    }

    @Contract("null, _ -> fail")
    public GamePlayer(String name, int health) {
        super(name, health);
    }

    @Contract("null -> fail")
    public GamePlayer(String name) {
        super(name);
    }

    @Override
    public void damage(int damagePoints) {
        if(defence > damagePoints){
            //hurt gear
            defence -= damagePoints;
        }
        else if (defence == damagePoints){
            //destroy gear but don't hurt player
        }
        else if(defence < damagePoints){
            //destroy gear and hur player
        }

    }

    public int getDefence() {
        return defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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



    public void equipItem(String eq) {
        Item eqItem = getFromInventory(eq);
        if (eqItem instanceof GearItem) {
            defence += ((GearItem) eqItem).getGearHP();
        }
    }

}
