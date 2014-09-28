package Frogger;

import zen.core.Zen;

public class Frog {
int x;
int y;
boolean upKeypressed;
public void setup (){
	x=250;
	y=515;
}

public void draw (){
Zen.setColor("red");
Zen.fillRect(x-15, y-15, 30, 30);
}

public void move (){
	if (Zen.isKeyPressed("left")){
		x=x+3;
	}
	if (Zen.isKeyPressed("right")){
		x=x-3;
	}

	if (Zen.isKeyPressed("up")&& upKeypressed == false){
		y=y-50;
		upKeypressed=true;
	}
	if (Zen.isKeyPressed("up")==false){
		upKeypressed=false;
	}
	
	if (Zen.isKeyPressed("down")){
		y=y+3;
	}
}
	


}
