package FallingCoins;

import zen.core.Zen;

public class Brick{

	int x=Zen.getRandomNumber(20, 780);
	int y=Zen.getRandomNumber(-500, -30);;
	int gravity=10;
	
	public void draw() {
	Zen.setColor("red");
	Zen.fillRect(x, y, 25, 10);
	}
	
	public void fall() {
	y=y+gravity;	
	}
	
	public void check() {
		if(y>775){
			y=Zen.getRandomNumber(-500, -30);
		}	
	}
	
	public void hit(){
		gravity=0;
	}

	public void disapear() {
		Zen.setColor("white");
		Zen.fillRect(x, y, 25, 10);
	}

}
