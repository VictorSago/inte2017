package dsv.inte2017g11.roguelib;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameMapTest {
	
    @Test
    public void testMapCreateWithSize(){
        GameMap m = new GameMap(8,9);
        assertEquals(8, m.getWidth());
    }
    
    @Test
    public void testMapCreateWithSize2(){
        GameMap m = new GameMap(4,5);
        assertEquals(5, m.getHeight());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidSize(){
        GameMap m = new GameMap(-1,20);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapInvalidSize2(){
        GameMap m = new GameMap(30,-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapCreateWithZeroValue(){
        GameMap m = new GameMap(0,15);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapCreateWithZeroValue2(){
        GameMap m = new GameMap(80,0);
    }

   @Test
    public void testGameMapBasicPosition(){
        GameMap m = new GameMap(4,20);
        assertNotNull(m.getPosition(2,2));
    }
   
   @Test
   public void testGameMapEndPosition(){
       GameMap m = new GameMap(4,20);
       assertNotNull(m.getPosition(4,20));
   }
   
   @Test
   public void testTerrainDiversity(){
	   int x = 100;
	   int y = 100;
	   GameMap m = new GameMap(x,y);
	   int i = 0;
	   int j = 0;
	   int lastTerrain = m.getPosition(i, j).getTerrain();
	   while(m.getPosition(i, j).getTerrain() == lastTerrain){
		   lastTerrain = m.getPosition(i, j).getTerrain();
		   if(i<x)
			   	i++;
		   else if(j<y){
			   	j++;
		   		i = 0;
		   }
		   else
			   fail();
	   }   
   }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapGetPositionOverIndex(){
        GameMap m = new GameMap(4,5);
        m.getPosition(8,2);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapGetPositionOverIndex2(){
        GameMap m = new GameMap(4,5);
        m.getPosition(2,8);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapGetPositionUnderIndex(){
        GameMap m = new GameMap(4,10);
        m.getPosition(-1,8);
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameMapGetPositionUnderIndex2(){
        GameMap m = new GameMap(4,10);
        m.getPosition(8,-1);
    }
}
