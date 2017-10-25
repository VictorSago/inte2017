package dsv.inte2017g11.roguelib.Misc;

import dsv.inte2017g11.roguelib.Maps.*;
import dsv.inte2017g11.roguelib.Characters.*;
import java.util.Scanner;

public class Engine {

	private GameMap map;
	private GamePlayer player;
	private boolean run = true;
	private Scanner scan;
	
	
	
	public Engine(String name,int x,int y) {
		map = new GameMap(x,y);
		player = new GamePlayer(name,100,1,map);
		scan = new Scanner(System.in);
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
	
	public Scanner getScanner() {
		return scan;
	}
	public void setRun(boolean run){
		this.run = run;
	}
	
	public void run() {
		while(run){
			while(player.getStepsLeft()>0){
			//System.out.println("Player currently at x:"+player.getPosX()+ " and y:"+ player.getPosY());
			System.out.println(player);
			player.printDecisions();
			int choice = scan.nextInt();
			run = player.tic(choice);
			scan.nextLine();
			scan.nextLine();
			}
			player.resetSteps();
			//map.tic();
		}
		System.out.println("Spelet avslutas");
	}
	
}
