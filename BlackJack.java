import java.util.ArrayList;

import zen.core.Zen;


public class BlackjackHand {
	static int state=1;

	public static final int Get_Cards=1;
	public static final int Hit=2;
	public static final int Stay=3;
	public static final int Bust=4;

	static ArrayList <Card> cards = new ArrayList <Card> ();

	public static void main (String[] args){
		Zen.create(500, 400);

		while (true){
			Zen.setBackground("green");
			int x=50;
			for (Card c: cards){
				c.draw(x, 100);
				x=x+50;
			}
			if (state==Get_Cards){
				cards.clear();
				if (cardValue()==21){
					state=Stay;
				}else {
					state=Hit;
				}
				if (state==Hit){
					if (Zen.isKeyPressed("h")){
						cards.add(getRandomCard());
						if (cardValue()>21){
							state=Bust;
						}
						Zen.sleep(100);
						if(cardValue()>21){
							state=Bust;
						}
					}
					if (Zen.isKeyPressed("s")){
						state=Stay;
					}
				}
				else if(state==Stay){
					Zen.sleep(1000);
					state=Get_Cards;
				}
				else if(state==Bust){
					Zen.sleep(1000);
					state=Get_Cards;
				}
				Zen.buffer(50);

			}
			if (state==Stay){

			}
			if (state==Bust){

			}
		}
	}
	private static Card getRandomCard() {
		return new Card(Zen.getRandomNumber(2, 14), Zen.getRandomNumber(1, 4));
	}
	private static int cardValue(){
		int total=0;
		for (Card c:cards) {
			if (c.getNumber()<14){

			}
		}
		return total;
	}
}
