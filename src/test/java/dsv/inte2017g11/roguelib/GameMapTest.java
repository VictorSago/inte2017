package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {

    private final int SIZE_X = 15;
    private final int SIZE_Y = 10;
	
    @Test
    public void mapCreationTest() {
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertEquals(SIZE_X, m.getWidth());
        assertEquals(SIZE_Y, m.getHeight());
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidSizeXCreationTest() {
        GameMap m = new GameMap(-1, SIZE_Y);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void invalidSizeYCreationTest() {
        GameMap m = new GameMap(SIZE_X, -1);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void creationWithZeroValueXTest() {
        GameMap m = new GameMap(0, SIZE_Y);
    }

    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void creationWithZeroValueYTest() {
        GameMap m = new GameMap(SIZE_X, 0);
    }

   @Test
    public void gameMapBasicPositionTest() {
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNotNull(m.getPosition(2,2));
    }
   
   @Test
   public void gameMapEndPositionTest(){
       GameMap m = new GameMap(SIZE_X, SIZE_Y);
       assertNotNull(m.getPosition(SIZE_X-1,SIZE_Y-1));
   }
   
   @Test
   public void terrainDiversityTest(){
	   int x = 100;
	   int y = 100;
	   GameMap m = new GameMap(x,y);
	   int i = 0;
	   int j = 0;
	   int lastTerrain = m.getPosition(i, j).getTerrain();
	   while(m.getPosition(i, j).getTerrain() == lastTerrain){
		   lastTerrain = m.getPosition(i, j).getTerrain();
		   if(i < x) {
               i++;
           } else if(j < y) {
			   	j++;
		   		i = 0;
		   } else {
               fail();
           }
       }
   }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositionOverXIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        m.getPosition(SIZE_X*2,SIZE_Y/2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositionOverYIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        m.getPosition(SIZE_X-1, SIZE_Y*2);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositionUnderXIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        m.getPosition(-1,SIZE_Y-1);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositionUnderYIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        m.getPosition(SIZE_X/2,-1);
    }
}
