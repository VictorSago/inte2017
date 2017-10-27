package dsv.inte2017g11.roguelib.Misc;

import dsv.inte2017g11.roguelib.Characters.*;

public class Combat {
	
	public static boolean fight(AbstractCharacter a1,AbstractCharacter a2,int sleep){
		AbstractCharacter first;
		AbstractCharacter second;
		if(a1.getSpeed() >= a2.getSpeed()){
			first = a1;
			second = a2;
		}
		else{
			first = a2;
			second = a1;
		}
		boolean turn = true;
		int dmg;
		while(a1.getCurrentHealth()>0 && a2.getCurrentHealth()>0){
			if(turn){
				dmg = first.attack(second);
				System.out.println(first.getName()+ " hits "+second.getName()+" for "+dmg+" damage");
				
			}else{
				dmg = second.attack(first);
				System.out.println(second.getName()+ " hits "+first.getName()+" for "+dmg+" damage");
			}turn = !turn;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(a1.getCurrentHealth()>0)
			return true;
		else
			return false;
			
	}
	
	

}
