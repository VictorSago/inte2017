package dsv.inte2017g11.roguelib.Engine;

import dsv.inte2017g11.roguelib.Maps.*;
import dsv.inte2017g11.roguelib.Characters.*;

public class Engine {

	private GameMap map;
	private GamePlayer player;
	private boolean run = true;
	
	
	
	public Engine(String name,int x,int y) {
		map = new GameMap(x,y);
		player = new GamePlayer(name,100,1);
	}
	
	public GameMap getMap(){
		return map;
	}
	
	public GamePlayer getGamePlayer() {
		return player;
	}
	
	public boolean getRun(){
		return run;
	}
	
	public void run() {
		while(run){
			run = player.decision();
			map.tic();
		}
	}
	
}
