package Checkers;

import zen.core.Zen;

public class CheckersGame {
	static int[][] board;
	static int ax=-1;
	static int ay=-1;
	static int player=1;

	public static void main(String[] args) {
		setup();
		draw();
		while (true){
			if (Zen.isMouseClicked()){
				click(Zen.getMouseX()/50, Zen.getMouseY()/50);
				draw();
			}

		}

	}

	public static void setup() {
		board=new int[8][8];
		Zen.create(400, 400);	
		Zen.buffer(1);

		for (int x=0; x<8; x++){
			for (int y=0; y<3; y++){
				if (x%2==y%2){
					board[x][y]=1;
				}
			}
		}
		for (int x=0; x<8; x++){
			for (int y=5; y<8; y++){
				if (x%2==y%2){
					board[x][y]=2;
				}
			}
		}
	}

	public static void draw() {
		Zen.setBackground("red");
		for (int x=0; x<8; x++){
			for (int y=0; y<8; y++){

				if (x%2==y%2){
					Zen.setColor("black");
					Zen.fillRect(x*50, y*50, 50, 50);

					if (canMove(x,y)){
						Zen.setColor("gray");
						Zen.fillRect(x*50, y*50, 50, 50);
					}
					if (board[x][y]==1){
						Zen.setColor("purple");
						Zen.fillOval(x*50+4, y*50+4, 40, 40);
					}else if (board[x][y]==2){
						Zen.setColor("green");
						Zen.fillOval(x*50+4, y*50+4, 40, 40);
					}
				}

			}
		}
		Zen.buffer(1);
	}

	public static void click(int x, int y){
		if(canMove(x, y)){
			move(ax,ay, x, y);
			ax=-1;
			ay=-1;
		}else if (board[x][y]==player) {
			ax=x;
			ay=y;
		}
	}

	public static void move(int sx, int sy, int ex, int ey) {
		
		board [ex][ey]=board[sx][sy];
		board [sx][sy]=0;
		//move over a peice
		if (Math.abs(ex-sx)==2 && Math.abs(ey-sy)==2){
			board[(ex+sx)/2][(ey+sy)/2]=0;
		}
		
		
		if (player==1){
			player=2;
		}else {
			player=1;
		}
	}

	public static boolean canMove(int x, int y){
		if (ax<0||ax<0){
			return false;
		}

		if (player==1){
			if (x==ax-1&&y==ay+1&&board[x][y]==0){
				return true;
			}
			if (x==ax+1&&y==ay+1&&board[x][y]==0){
				return true;
			}
		}else if (player==2){
			if (x==ax-1&&y==ay-1&&board[x][y]==0){
				return true;
			}
			if (x==ax+1&&y==ay-1&&board[x][y]==0){
				return true;
			}
		}

		if (player==1){
			if (x==ax+2 && y==ay+2 &&board[ax+1][ay+1]==2&&board[x][y]==0){
				return true;
			}else if (x==ax-2&&y==ay+2&&board[ax-1][ay+1]==2&&board[x][y]==0){
				return true;
			}
		}else if (player==2){
			if (x==ax+2&&y==ay-2&&board[ax+1][ay-1]==1&&board[x][y]==0){
				return true;
			}else if (x==ax-2&&y==ay-2&&board[ax-1][ay-1]==1&&board[x][y]==0){
				return true;
			}
		}

		return false;
	}

}
