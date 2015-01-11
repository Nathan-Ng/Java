import zen.core.Zen;
 
 
public class Card {
	public static final int HEART = 1;
	public static final int DIAMOND = 2;
	public static final int SPADE = 3;
	public static final int CLOVER = 4;
 
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;
 
	private int number;
	private int suit;
 
	public Card(int number, int suit) {
		this.number = number;
		this.suit = suit;
	}
	public int getNumber(){
		return number;
	}
	public int getSuit(){
		return suit;
	}
	public boolean greaterThan(Card other) {
		if (number > other.number) {
			return true;
		}
		else if (number == other.number && suit > other.suit) {
			return true;
		}
		return false;
	}
 
	public void draw(int x, int y) {
		Zen.setColor("white");
		Zen.fillRect(x - 20, y - 30, 40, 60);
		Zen.setFont("Arial", 36);
		switch(suit) {
		case Card.HEART:
			Zen.setColor("red");
			Zen.drawText("\u2665", x - 12, y + 10);
			break;
		case Card.DIAMOND:
			Zen.setColor("red");
			Zen.drawText("\u2666", x - 12, y + 10);
			break;
		case Card.SPADE:
			Zen.setColor("black");
			Zen.drawText("\u2660", x - 12, y + 10);
			break;
		case Card.CLOVER:
			Zen.setColor("black");
			Zen.drawText("\u2663", x - 12, y + 10);
			break;
		}
 
		Zen.setFont("Arial", 15);
		if (number <= 10) {
			Zen.drawText("" + number, x - 18, y - 16);
			Zen.drawText("" + number, x + ((number == 10) ? 2 : 7), y + 25);
		}
		else {
			switch(number) {
			case 11: 
				Zen.drawText("J", x - 15, y - 15);
				Zen.drawText("J", x + 7, y + 25);
				break;
			case 12: 
				Zen.drawText("Q", x - 15, y - 15);
				Zen.drawText("Q", x + 7, y + 25);
				break;
			case 13: 
				Zen.drawText("K", x - 15, y - 15); 
				Zen.drawText("K", x + 7, y + 25);
				break;
			case 14: 
				Zen.drawText("A", x - 15, y - 15);
				Zen.drawText("A", x + 7, y + 25);
				break;
			}
		}
	}
 
}
