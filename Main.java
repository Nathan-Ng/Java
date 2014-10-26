package FallingCoins;

import java.util.ArrayList;

import zen.core.Zen;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int score=0;
		Player p=new Player();
		Gameover g=new Gameover();
		Zen.create(500, 800);
		ArrayList<Coin> list = new ArrayList<Coin>();
		int count = 0;
		while (count < 20) {
			Coin c = new Coin();
			list.add(c);
			count = count + 1;
		}

		ArrayList<Brick> list2 = new ArrayList<Brick>();
		int count2 = 0;
		while (count2 < 5) {
			Brick b = new Brick();
			list2.add(b);
			count2 = count2 + 1;
		}

		while(true){
			Zen.setBackground("light blue");
			Zen.setColor("green");
			Zen.fillRect(0, 700, 500, 100);
			p.draw();
			p.move();

			for (Coin c: list) {
				c.draw();
				c.fall();
				c.check();
				if (p.isHitting(c)==true){
					c.hit();
					score++;
				}
			}

			for (Brick b: list2) {
				b.draw();
				b.fall();
				b.check();

				if (p.isHitting2(b)==true){
					b.hit();
					b.disapear();
					g.draw();
				}
			}

			String scoreboard = "score: "+score;
			Zen.setColor("white");
			Zen.drawText(scoreboard, 10, 780);
			Zen.buffer(33);
		}
	}

}
//make new coins
