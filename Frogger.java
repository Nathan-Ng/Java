		f.setup();
		ArrayList<Truck> list = new ArrayList<Truck>();
		int count = 0;
		while (count < 50) {
			Truck t = new Truck();
			t.create();
			list.add(t);
			count = count + 1;
		}

		while (true){
			drawBackground();


			for (Truck t : list) {
				t.draw();
				t.move();
				if (t.isKilling(f)) {
					f.setup();
				}
			}

			f.draw();
			f.move();


			Zen.buffer(33);
		}
	}

	private static void drawBackground() {

		Zen.setBackground("green");
		Zen.setColor("gray");
		Zen.fillRect(0, 200, 500, 300);

		int y = 200;
		int x = 10;
		int y2=225;
		int x2 = 10;

		while (y <= 500){
			Zen.setColor("black");
			Zen.fillRect(0, y, 500, 10);
			y=y+50;
		}
		while (y2<500){
			x2 = 10;
			while (x2 < 500){
				Zen.setColor("yellow");
				Zen.fillRect(x2, y2, 10, 3);
				x2=x2+20;

			}
			y2=y2+50;
		}
	}

}
