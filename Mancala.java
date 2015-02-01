
import zen.core.Zen;
import zen.game.Game;

public class MancalaGame {
	static int[] mancala=new int[14];
	static int player=1;

	public static void main(String[] args) {
		setup();
		draw();
		while (true){
			if (Zen.isMouseClicked()){
				click(Zen.getMouseClickX(), Zen.getMouseClickY());
				endgame();
				draw();
			}
		}
		
	}

	private static void click(int x, int y) {
		int temp=-1;
		int index =-1;
		if (player==1){
			if (y>=100&&y<=180){
				for (int i=110; i<710; i+=100){
					if (x>=i&&x<=i+80){
						index=i/100-1;
						if (mancala[index]==0){
							return;
						}
						temp=mancala[index];
						mancala[index]=0;
					}
					
				}
				player=2;
			}
		}
		if (player==2){
			if (y>=10&&y<=90){
				if (x>=110&&x<=190){
					index=12;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				if (x>=210&&x<=290){
					index=11;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				if (x>=310&&x<=390){
					index=10;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				if (x>=410&&x<=490){
					index=9;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				if (x>=510&&x<=590){
					index=8;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				if (x>=610&&x<=690){
					index=7;
					if (mancala[index]==0){
						return;
					}
					temp=mancala[index];
					mancala[index]=0;
				}
				player = 1;
			}
		}

		
		for (int i=index+1; i<=temp+index; i++){
			if (i>13){
				mancala[i-14]++;
			}else {
				mancala[i]++;
			}
		}
		
		
		
	}

	private static void draw() {
		Zen.setBackground(100, 78, 6);
		for (int x=0; x<14; x++){
			if (x<6){
				Zen.setColor("adjkls");
				Zen.fillOval(100*x+110, 100, 80, 80);
				Zen.setColor("red");
				Zen.drawText(Integer.toString(mancala[x]), 100*x+140, 150);
			} else if (x>6 &&  x<13){
				Zen.setColor("black");
				Zen.fillOval(100*(12-x)+110, 10, 80, 80);
				Zen.setColor("blue");
				Zen.drawText(Integer.toString(mancala[x]), 100*(12-x)+140, 60);
			} else if (x==6){
				Zen.setColor("black");
				Zen.fillOval(700, 0, 100, 200);
				Zen.setColor("red");
				Zen.drawText(Integer.toString(mancala[x]),740, 120);
			} else if (x==13){
				Zen.setColor("black");
				Zen.fillOval(0, 0, 100, 200);
				Zen.setColor("blue");
				Zen.drawText(Integer.toString(mancala[x]),40, 120);
			}
			
		}
		Zen.buffer(1);
	}

	public static void setup() {
		Zen.create(800, 200);
		Zen.setFont("arial", 40);

		for (int i=0; i<14; i++){
			if (i!=6 && i!=13){
				mancala[i]=4;
			}else {
				mancala[i]=0;
			}
		}
	}
	public static void endgame(){
		if (checkEmpty()){
			for (int i=7; i<13; i++){
				mancala[13]+=mancala[i];
				mancala[i]=0;
			}
		}else if (checkEmpty2()){
			for (int i=0; i<6; i++){
				mancala[6]+=mancala[i];
				mancala[i]=0;
			}
		}
	}

public static boolean checkEmpty(){
	int count=0;
	for (int i=0; i<6; i++){
		if (mancala[i]==0){
			count++;
		}
	}
	if (count==6){
		return true;
	}
	return false;
}

public static boolean checkEmpty2(){
	int count=0;
	for (int i=7; i<13; i++){
		if (mancala[i]==0){
			count++;
		}
	}
	if (count==6){
		return true;
	}
	return false;
}
	
}
