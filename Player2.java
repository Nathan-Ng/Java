package CaptureTheFlag;

import zen.core.Zen;

public class Player {
	
	int x;
	int y;
	String name;
	String team;
	
	public Player(String n) {
		name=n;
		team=Zen.read(name + "team");
	}
	public void draw() {
		Zen.setColor("team");
		Zen.fillOval(x-10, y-10, 20, 20);
	}
	public void move() {
		x=Zen.readInt(name + "x");
		y=Zen.readInt(name + "y");
	}
	
}
