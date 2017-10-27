package dsv.inte2017g11.roguelib.Maps;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {

    private final int SIZE_X = 20;
    private final int SIZE_Y = 15;
	
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
    public void gameMapBasicTilePositionTest() {
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNotNull(m.getTile(2, 2));
    }
   
   @Test
   public void gameMapEndTilePositionTest(){
       GameMap m = new GameMap(SIZE_X, SIZE_Y);
       assertNotNull(m.getTile(SIZE_X-1, SIZE_Y-1));
   }
   
  /* @Test
   public void terrainDiversityTest(){
	   int x = 100;
	   int y = 100;
	   GameMap m = new GameMap(x,y);
	   int i = 0;
	   int j = 0;
	   int lastTerrain = m.getTile(i, j).getTerrain();
	   while(m.getTile(i, j).getTerrain() == lastTerrain){
		   lastTerrain = m.getTile(i, j).getTerrain();
		   if(i < x) {
               i++;
           } else if(j < y) {
			   	j++;
		   		i = 0;
		   } else {
               fail();
           }
       }
   }*/

    /*@Test(expected = IndexOutOfBoundsException.class)
    public void getPositionOverXIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        m.getPosition(SIZE_X*2, SIZE_Y/2);
    }*/

    @Test
    public void getPositionOverXIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNull(m.getTile(SIZE_X*2, SIZE_Y/2));
    }
    
    @Test
    public void getPositionOverYIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNull(m.getTile(SIZE_X-1, SIZE_Y*2));
    }


    @Test
    public void getPositionUnderXIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNull(m.getTile(-1,SIZE_Y-1));
    }
    
    @Test
    public void getPositionUnderYIndexTest(){
        GameMap m = new GameMap(SIZE_X, SIZE_Y);
        assertNull(m.getTile(SIZE_X/2,-1));
    }
    @Test
    public void isValidPositionTest(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	assertTrue(gm.isValidPosition(12, 11));
    }
    @Test
    public void isValidPositionTest2(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	assertFalse(gm.isValidPosition(22, 11));
    }
    @Test
    public void isValidPositionTest3(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	assertFalse(gm.isValidPosition(11, 22));
    }
    @Test
    public void isValidPositionTest4(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	assertFalse(gm.isValidPosition(11, -2));
    }
    @Test
    public void isValidPositionTest5(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	assertFalse(gm.isValidPosition(-1, 4));
    }
    @Test
    public void isFreePositionTest(){
    	GameMap gm = new GameMap(SIZE_X,SIZE_Y);
    	gm.isFreePosition(10, 15);
    }
    
}
