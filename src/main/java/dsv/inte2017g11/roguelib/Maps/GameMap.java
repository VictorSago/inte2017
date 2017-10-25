package dsv.inte2017g11.roguelib.Maps;

import java.util.Random;

import dsv.inte2017g11.roguelib.Items.*;
import dsv.inte2017g11.roguelib.Items.Effect;
import dsv.inte2017g11.roguelib.Characters.*;

import java.util.ArrayList;


public class GameMap {

    private final int width;
    private final int height;
    private Tile[][] tiles;

    private Random rand = new Random();

    public GameMap(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
        fillMapField(width,height);
        fillMapField2();
    }

    private void fillMapField(int sX, int sY) {
        tiles = new Tile[sX][sY];
        for (int i = 0; i < sX; i++) {
            for (int j = 0; j < sY; j++) {
                tiles[i][j] = new Tile(randomTerrain(), new ArrayList<>());
            }
        }
        
    }
    private void fillMapField2() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
            	int r = rand.nextInt(10);
            	switch(r){
            	case 1: tiles[i][j].addItem(new PotionItem("Super Elixir",50,Effect.MAGIC));
            			break;
            	case 2:	tiles[i][j].addItem(new WeaponItem("Sword",10,40));
    					break;
            	case 3:	tiles[i][j].addItem(new GearItem("Gloves",5,30,Effect.HEALTH));
						break;
            	case 4: tiles[i][j].addCharacter(new Monster("Werewolf",50,15,this));
						break;
            	case 5: tiles[i][j].addCharacter(new Monster("Dragon",80,1,this));
						break;
				default:
						break;
            	}
                
            }
        }
        
    }
    
    private int randomTerrain(){
    	return rand.nextInt(10);
    }

/*

    public Tile getPosition(int x, int y) {
        if (x < 0 || y < 0 || x > width || y > height) {
            throw new IndexOutOfBoundsException();
        } else {
            return tiles[x][y];
        }
    }
*/

    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }

    public boolean isFreePosition(int x, int y) {
        return true;
    }

    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return null;
        } else {
            return tiles[x][y];
        }
    }
}
