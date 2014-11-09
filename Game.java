package CaptureTheFlag;

import java.util.ArrayList;

public class Game {
	
	ArrayList <Team> teams;
	
	public Game() {
		teams=new ArrayList<Team>() ;
	}
	
	public void draw() {
		for (Team t : teams){
			t.draw();
		}
	}

	public void move() {
		for (Team t : teams){
			t.move();
		}
	}
	
	public void addTeam (Team t){
		teams.add(t);
	}

}
