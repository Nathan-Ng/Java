package FallingCoins;

import zen.core.Zen;

public class Player {

	int x=250;
	int y=670;
	int dx=5;
	int dy=5;

	public void draw() {
		Zen.setColor("black");
		Zen.fillOval(x, y, 30, 30);
	}

	public void move() {
		if(Zen.isKeyPressed("right")){
		x=x+dx;
		}
		if(Zen.isKeyPressed("left")){
		x=x-dx;
		}
	}

		public boolean isHitting(Coin k) {
			if (Math.abs(x-k.x)<25 && Math.abs(y-k.y)<25){
				return true;
			}
			else {
				return false;
			}
		}
		
		public boolean isHitting2(Brick k) {
			if (Math.abs(x-k.x)<25 && Math.abs(y-k.y)<25){
				return true;
			}
			else {
				return false;
			}
		}

}
