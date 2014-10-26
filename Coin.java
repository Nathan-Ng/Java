package FallingCoins;

import zen.core.Zen;

public class Coin {
	
	int x=Zen.getRandomNumber(20, 780);
	int y=Zen.getRandomNumber(-500, -30);;
	int gravity=10;
	public void draw() {
	Zen.setColor("yellow");
	Zen.fillOval(x, y, 25, 25);
	}

	public void fall() {
	y=y+gravity;	
		
	}

	public void check() {
		if(y>770){
			y=Zen.getRandomNumber(-500, -30);
		}	
	}
	
	public void hit(){
		y=Zen.getRandomNumber(-500, -30);
	}

}
