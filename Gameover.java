package FallingCoins;

import zen.core.Zen;

public class Gameover {

	public void draw() {
		Zen.setColor("white");
		Zen.fillRect(0, 0, 500, 800);
		String gameover = "Game Over";
		Zen.setColor("red");
		Zen.drawText(gameover, 220, 400);
	}

}
