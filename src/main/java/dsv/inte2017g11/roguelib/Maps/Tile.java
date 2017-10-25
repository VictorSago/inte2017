package dsv.inte2017g11.roguelib.Maps;

import dsv.inte2017g11.roguelib.Characters.*;
import dsv.inte2017g11.roguelib.Items.*;

import java.util.ArrayList;
import java.util.Random;

public class Tile {
   
	private int terrain;
    private AbstractCharacter character;
	private ArrayList<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();
    private Item item;
    private Random rand = new Random();

    public Tile(int terrain, ArrayList<AbstractCharacter> characters,GameMap map) {
    	if(terrain < 0) {
            throw new IllegalArgumentException("Wrong terrain");
        }
        this.terrain = terrain;
    	this.characters = characters;
    	int i = rand.nextInt(10);
    	if(i<6){
    		item = new WeaponItem("Axe",20,30);
    		character = new Monster("Wolf",50,15,map);
    	}
    }
    public int getTerrain() {
    	return terrain;
    }
    public Item getItem() {
    	return item;
    }
    public AbstractCharacter getCharacter() {
    	return character;
    }
    public void removeItem() {
    	item = null;
    }
    public void removeCharacter() {
    	character = null;
    }
    public void addItem(Item i){
    	item = i;
    }

    public ArrayList<AbstractCharacter> getCharacters() {
        return characters;
    }


    public void setTerrain(int terrain) {
    	if(terrain < 0) {
            throw new IndexOutOfBoundsException("Wrong terrain");
        }
        this.terrain = terrain;
    }
    
    @Override
    public int hashCode() {
        return terrain * 59;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
           return this.terrain == ((Tile)o).terrain;
        }
        return false;
    }
}
