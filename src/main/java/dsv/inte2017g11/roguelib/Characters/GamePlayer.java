package dsv.inte2017g11.roguelib.Characters;

import dsv.inte2017g11.roguelib.Items.GearItem;
import dsv.inte2017g11.roguelib.Maps.*;
import dsv.inte2017g11.roguelib.Misc.Combat;
import dsv.inte2017g11.roguelib.Items.Item;

import java.util.ArrayList;
import java.util.Collection;

public class GamePlayer extends AbstractCharacter {

    private ArrayList<Item> inventory;
    private int defence;

    public GamePlayer(String name, int health, int speed,GameMap map) {
        super(name, health, speed,map);
        inventory = new ArrayList<>();
    }

    public GamePlayer(String name, int health,GameMap map) {
        super(name, health,map);
        inventory = new ArrayList<>();
    }

    public GamePlayer(String name,GameMap map) {
        super(name,map);
        inventory = new ArrayList<>();
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public int getAmountOfItems() {
        return inventory.size();
    }
    
    public ArrayList<Item> showInventory() {
    	return inventory;
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
        throw new IllegalArgumentException();
    }

    public void throwItem(String item) {
        Item removeMe = getFromInventory(item);
        inventory.remove(removeMe);
    }

   /* @Override
    public void hurtCharacter(int damagepoint) {
        if(defence > damagepoint){
            //hurt gear
            defence -= damagepoint;
        }
        else if (defence == damagepoint){
            //destroy gear but don't hurt player
        }
        else if(defence < damagepoint){
            //destroy gear and hur player
        }

    }*/

    public int getDefence() {
        return defence;
    }
    public void changeDefence(int def){
    	defence += def;
    }

    public void equipItem(String eq) {
        Item eqItem = getFromInventory(eq);
        if (eqItem instanceof GearItem) {
            defence += ((GearItem) eqItem).getGearHP();
        }
    }
    
    public void printDecisions() {
    	System.out.println("Press 1 to move left");
    	System.out.println("Press 2 to move up");
    	System.out.println("Press 3 to move right");
    	System.out.println("Press 4 to move down");
    	System.out.println("Press 5 to show inventory");
    	System.out.println("Press 6 to pick up item");
    	System.out.println("Press 7 to attack");
    	System.out.println("Press 8 to use item");
    	
    }
    @Override
    public boolean tic(int t) {
    	boolean move;
    	Tile tile = super.getMap().getTile(super.getPosX(), super.getPosY());
    	switch(t){
    	case 1: move = moveLeft();
    			if(!move)
    				System.out.println("Can't move left here");
    			break;
    	case 2: move = moveUp();
		    	if(!move)
					System.out.println("Can't move up here");
				break;
    	case 3: move = moveRight();
		    	if(!move)
					System.out.println("Can't move right here");
				break;
    	case 4: move = moveDown();
		    	if(!move)
					System.out.println("Can't move down here");
				break;
    	case 5: System.out.println(showInventory());
    			break;
    	case 6: 
    			if(tile.getItem() != null){
    				addToInventory(tile.getItem());
    				System.out.println("Added "+tile.getItem()+" to your inventory");
    				tile.removeItem();
    			}
    			else
    				System.out.println("There are no items here");
    			
				break;
    	case 7:	
				if(tile.getCharacter() != null){
					boolean success = Combat.fight(this,tile.getCharacter(),1000);
					if(success){
						tile.removeCharacter();
						System.out.println(super.getName()+" wins");
					}
					else{
						System.out.println(super.getName()+" dies");
						return false;
					}
				}
				else
					System.out.println("There are no characters here");
				break;
    	case 8:
    			System.out.println(inventory.get(0).use(this));
    			inventory.remove(0);
    			break;
    	case -1: return false;
    
    	}
    	//reduceStepsLeft();
    	return true;
    }
    
    

}
