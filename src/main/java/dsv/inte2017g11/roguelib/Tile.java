package dsv.inte2017g11.roguelib;

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
