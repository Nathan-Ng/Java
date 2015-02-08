import zen.core.Zen;


public class mancala {

	static int[] mancala = new int[14];
	static int player = 1;
	static int lastPosition = -1;
	static boolean valid = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setup();
		draw();

		while (true)
		{
			if (Zen.isMouseClicked())
			{
				click(Zen.getMouseX(), Zen.getMouseY());
				endGame();
				draw();
				Zen.sleep(100);
			}
		}

	}

	public static void setup()
	{
		Zen.create(800, 300);
		Zen.setFont("arial", 40);

		for (int i = 0; i < 14; i++)
		{
			if (i != 6 && i != 13)
			{
				mancala[i] = 4;
			}
			else
				mancala[i] = 0;
		}
	}

	public static void draw()
	{
		Zen.setBackground("white");
		for (int x = 0; x < 14; x++)
		{
			if (x < 6)
			{
				Zen.setColor("tan");
				Zen.fillOval(100 * x + 110, 100, 80, 80);
				Zen.setColor("black");
				Zen.drawText(Integer.toString(mancala[x]), 100 * x + 140, 150);
			}
			else if (x > 6 && x < 13)
			{
				Zen.setColor("tan");
				Zen.fillOval(100 * (12 - x) + 110, 10, 80, 80);
				Zen.setColor("black");
				Zen.drawText(Integer.toString(mancala[x]), 100 * (12-x) + 140, 60);
			}
			else if (x == 6)
			{
				Zen.setColor("tan");
				Zen.fillOval(700, 0, 100, 200);
				Zen.setColor("black");
				Zen.drawText(Integer.toString(mancala[x]), 740, 120);
			}
			else if (x == 13)
			{
				Zen.setColor("tan");
				Zen.fillOval(0, 0, 100, 200);
				Zen.setColor("black");
				Zen.drawText(Integer.toString(mancala[x]), 40, 120);
			}
		}

		Zen.setColor("black");
		Zen.drawText("Player: " + player, 300, 250);

		Zen.buffer(1);
	}

	public static void click (int x, int y)
	{
		int temp = -1;
		int index = -1;

		if (player == 1)
		{
			if (y >= 100 && y <= 180)
			{
				if (x >= 110 && x <= 190)
				{
					index = 0;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 210 && x <= 290)
				{
					index = 1;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 310 && x <= 390)
				{
					index = 2;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 410 && x <= 490)
				{
					index = 3;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 510 && x <= 590)
				{
					index = 4;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 610 && x <= 690)
				{
					index = 5;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				valid = true;
			}
		}

		if (player == 2)
		{
			if (y >= 10 && y <= 90)
			{
				if (x >= 110 && x <= 190)
				{
					index = 12;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 210 && x <= 290)
				{
					index = 11;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 310 && x <= 390)
				{
					index = 10;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 410 && x <= 490)
				{
					index = 9;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 510 && x <= 590)
				{
					index = 8;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				if (x >= 610 && x <= 690)
				{
					index = 7;
					if (mancala[index] == 0)
						return;
					temp = mancala[index];
					mancala[index] = 0;
				}
				valid = true;
			}
		}

		step(index, temp);

		if (valid == true)
		{
			player = player % 2 + 1;
			valid = false;
		}

		if (player == 2 && lastPosition == 6)
		{
			player = 1;
		}
		else if (player == 1 && lastPosition == 13)
		{
			player = 2;
		}
	}

	public static void step(int index, int stones)
	{
		int finalPosition = stones + index;

		for (int i = index + 1; i <= finalPosition; i++)
		{
			if (player == 1)
			{
				if (i > 13 && i - 14 != 13)
				{
					mancala[i-14]++;
				}
				else if (i > 13 && i - 14 == 13)
				{
					finalPosition++;
				}
				else if (i != 13)
				{
					mancala[i]++;
				}
				else if (i == 13)
				{
					finalPosition++;
				}
			}
			else if (player == 2)
			{
				if (i > 13 && i - 14 != 6)
				{
					mancala[i-14]++;
				}
				else if (i > 13 && i -14 == 6)
				{
					finalPosition++;
				}
				else if (i != 6)
				{
					mancala[i]++;
				}
				else if (i == 6)
				{
					finalPosition++;
				}
			}
			lastPosition = i;
		}

		if (lastPosition > 13)
		{
			lastPosition = lastPosition - 14;
		}

		if (valid && lastPosition != 6 && lastPosition != 13 && mancala[lastPosition] == 1 && player == 1)
		{
			mancala[6] += mancala[lastPosition] + mancala[12 - lastPosition];
			mancala[lastPosition] = 0;
			mancala[12 - lastPosition] = 0;
		}
		else if (valid && lastPosition != 6 && lastPosition != 13 && mancala[lastPosition] == 1 && player == 2)
		{
			mancala[13] += mancala[lastPosition] + mancala[12 - lastPosition];
			mancala[lastPosition] = 0;
			mancala[12 - lastPosition] = 0;
		}

	}

	public static void endGame()
	{      
		if (checkEmpty1()){
			for (int i = 7; i < 13; i++)
			{
				mancala[13] += mancala[i];
				mancala[i] = 0;
			}
			
		}
		else if (checkEmpty2())
		{
			for (int i = 0; i < 6; i++)
			{
				mancala[6] += mancala[i];
				mancala[i] = 0;
			}
		}

	}

	public static boolean checkEmpty1()
	{
		int count = 0;

		for (int i = 0; i < 6; i++)
		{
			if (mancala[i] == 0)
				count++;
		}

		if (count == 6){
			return true;
		}
		return false;
	}

	public static boolean checkEmpty2()
	{
		int count = 0;

		for (int i = 7; i < 13; i++)
		{
			if (mancala[i] == 0)
				count++;
		}

		if (count == 6){
			return true;
		}

		return false;          
	}
	/*if (mancala[6]>mancala[13]){
	Zen.setColor("yellow");
	Zen.fillRect(0, 0, 800, 300);
	Zen.setColor("black");
	Zen.drawText("Player 1 wins", 400, 150);
} else if (mancala[13]>mancala[6]){
	Zen.setColor("yellow");
	Zen.fillRect(0, 0, 800, 300);
	Zen.setColor("black");
	Zen.drawText("Player 2 cheated, so Player 1 wins by default", 400, 150);
} else {
	Zen.setColor("yellow");
	Zen.fillRect(0, 0, 800, 300);
	Zen.setColor("black");
	Zen.drawText("It should be a tie, but Player 1 is superior so Player 2 loses and Player 1 wins", 400, 150);
}
*/

}
