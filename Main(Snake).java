package Snake;

import zen.core.Zen;

public class Main {

	
	
	public static void main(String[] args) {
		Zen.create(500, 500);
		Snake s=new Snake();
		Apple a=new Apple();
		
		while (true){
			background();
			//set up snake
			s.draw();
			s.move();
			s.check();
			a.draw();
			s.check2();
			if (s.isHitting(a)){
				a.teleport();
				s.grow();
			}
			Zen.buffer(100);
		}

	}

	private static void background() {
		Zen.setBackground("white");
	}

}
