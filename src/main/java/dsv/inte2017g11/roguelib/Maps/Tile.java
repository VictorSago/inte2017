package dsv.inte2017g11.roguelib.Maps;

import dsv.inte2017g11.roguelib.Characters.AbstractCharacter;

import java.util.ArrayList;

public class Tile {
   
	private int terrain;
    private ArrayList<AbstractCharacter> characters = new ArrayList<AbstractCharacter>();


    public Tile(int terrain, ArrayList<AbstractCharacter> characters) {
    	if(terrain < 0) {
            throw new IllegalArgumentException("Wrong terrain");
        }
        this.terrain = terrain;
    	this.characters = characters;
    }
    public int getTerrain() {
    	return terrain;
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
