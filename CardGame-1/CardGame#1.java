import zen.core.Zen;


public class Cardkitsu {
	static int myScore=50;
	static int opponentScore=50;
	static int pot=0;

	static int state=1;

	public static final int Place_Bet=1;
	public static final int Pick_Card=2;

	public static void main(String[] args) {
		Zen.create(300,  200);

		while (true){
			Zen.setBackground("green");
			Zen.setColor(255, 0, 0);
			Zen.setFont("Arial", 30);
			Zen.drawText(""+myScore, 20, 100);
			Zen.drawText(""+opponentScore, 250, 100);
			Zen.drawText(""+pot, 250, 50);
			if (state==Place_Bet) {
				for (int i=1; i<=9; i++){
					if (Zen.isKeyPressed(Integer.toString(i))){
						myScore-=i;
						opponentScore-=i;
						pot+=i*2;
						state=Pick_Card;
					}

				}
				Zen.buffer(33);
			}
			else if (state==Pick_Card){
				Card me=getRandomCard();
				Card opponent=getRandomCard();
				me.draw(100, 100);
				opponent.draw(200, 100);
				if (me.greaterThan(opponent)){
					myScore=myScore+pot;
					pot=0;
				}else if(opponent.greaterThan(me)){
					opponentScore=opponentScore+pot;
					pot=0;
				}else{

				}
				state=Place_Bet;
				
				Zen.buffer(200);
			}

		}


	}

	private static Card getRandomCard() {
		return new Card(Zen.getRandomNumber(2, 14), Zen.getRandomNumber(1, 4));
	}

}
