import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model {
	private ArrayList<Sprite> sprite;
	static int number = 0;
	CopCar copcar;
	RobberCar robbercar;
	Bank bank;
	View view;

	// --------------- Display the image----------------
	Model() throws IOException {
		// Model constructor calls the Sprint class.

		sprite = new ArrayList<>();
		bank = new Bank();
		sprite.add(bank);

	}
	// --------------------------------------------------

	// ----------Moves the Image --------------------
	public void update(Graphics g) {
		// how do i put my sprite in a different location
		// sprite.update(g);
		synchronized (sprite) {
			for (int i = 0; i < sprite.size(); i++)
				sprite.get(i).updateImage(g); // i need to find a way i can
												// invoke this method
		}
	}
	// ----------------------------------------------

	public void CreateandLocation(int x, int y) {
		synchronized (sprite) {
			robbercar = new RobberCar();
			copcar = new CopCar();

			if (number % 2 != 0) {
				sprite.add(copcar);
				number++;
				sprite.get(sprite.size() - 1).setX(x);
				sprite.get(sprite.size() - 1).setY(y);
			} else {
				sprite.add(robbercar);
				number++;
				sprite.get(sprite.size() - 1).setX(300);
				sprite.get(sprite.size() - 1).setY(300);
			}
			// "RobberCar", 20,new Engine("Look", 20, 100), "red-car.jpg"));

		}
		// create multiple cars
	}

	public void updateScene(int x, int y) {
		// use an iterator
		synchronized (sprite) {
			Iterator<Sprite> iter = sprite.iterator();
			while (iter.hasNext()) {
				Sprite s = iter.next();
				if (s instanceof RobberCar) {
					if (((RobberCar) s).hasEscaped()) {
						System.out.println("I'm free");
						iter.remove();
					}
				}
			}
		

			for (int numcopcar = 1; numcopcar < sprite.size(); numcopcar++) {// gets
				sprite.get(numcopcar).updateScene(x, y); // updates the image
				sprite.get(numcopcar).updateState(); // make the car drive													// copcar
				if (sprite.get(numcopcar) instanceof CopCar) // copcar
					for (int numrobber = 1; numrobber < sprite.size(); numrobber++)// gets
																					// robbercar

						if (sprite.get(numrobber) instanceof RobberCar) {// robbercar
							if (!((RobberCar) sprite.get(numrobber)).isCapture())
								// list1.get(numcopcar).overlaps(list1.get(numrobber));
								// // if robbercar overlaps copcar
								if (sprite.get(numcopcar).overlaps(sprite.get(numrobber))) { // return
																								// true
																								// if
																								// they
																								// overlap
									((RobberCar) sprite.get(numrobber)).captured(); // change
																				// image
																				// and
																				// stop
																				// movement
								}
						}
			}
		}

	}

	public void captureAndEscape() {
		System.out.println(" Capture : " + RobberCar.getRobberscap());
		System.out.println(" Escape : " + RobberCar.getEscape());
	}

	public void initialize() {
		synchronized (sprite) {
			sprite.clear();
			sprite.add(bank);
			RobberCar.reset();
		}
	}

}
