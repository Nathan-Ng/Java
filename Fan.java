import zen.core.Zen;


public class Highest_Card {
	static int x=50;
	static int y=50;
	static int card_order=2;
	static int color_order=1;
	
	public static void main (String[] args) {
		Zen.create(800, 500);
		Zen.setBackground("green");

		
		while (true){
			getRandomCard();
			Zen.sleep(50);
		}
	}

	private static void getRandomCard() {
		Card mine=new Card(card_order, color_order);
		//Card yours= new Card(Zen.getRandomNumber(2, 14), Zen.getRandomNumber(1, 4));
		mine.draw(x, y);
		//yours.draw(560,250);
		if (color_order<4){
			color_order++;
		} else if (color_order==4){
			card_order++;
			color_order=1;
		}
		x=x+30;
		if (x>750){
			x=50;
			y+=50;
		}
		if (card_order>14){
			card_order=2;
		}
		if (y>450){
			y=908134;
		}
		
	}
	
}
