package dsv.inte2017g11.roguelib.Maps;

public class Tile {
   
	private int terrain;

    public Tile(int terrain) {
    	if(terrain < 0) {
            throw new IllegalArgumentException("Wrong terrain");
        }
        this.terrain = terrain;
    }
    public int getTerrain() {
    	return terrain;
    }


    public void setTerrain(int terrain) {
    	if(terrain < 0) {
            throw new IllegalArgumentException("Wrong terrain");
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
           Tile otherTile = (Tile) o;
           return this.terrain == otherTile.terrain;
        }
        return false;
    }
}
