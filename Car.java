import java.awt.Graphics;

public class Car extends Sprite {

	private String Cardescription;
	private GasTank gas;
	private Engine engine;
	private int totalmilesdriven = 0;
	private Sprite sprite;

	// Car NeilCar = new Car("nissan", 150, null);
	public Car(String description, int Maxfuel, Engine initengine, String jpgName) {
		super(jpgName);

		if (description.length() == 0)
			Cardescription = "Generic car";
		engine = initengine;
		if (initengine == null)
			engine = new Engine("", 0, 0);

		Cardescription = description;
		gas = new GasTank(Maxfuel);



	}

	public String getDescription() {
		return String.format("%s\n",
				String.format("%s engine: %s, " + "fuel: %.2f / %d, " + "location: (%d,%d) ", Cardescription,
						engine.getDescription(), this.gas.getLevel(), gas.getCapacity(), this.locationX,
						this.locationY));

	}

	public double getFuelLevel() {
		return gas.getLevel();
	}

	public int getMPG() {
		return engine.getMpg();
	}

	public void fillUp() {
		gas.setLevel(gas.getCapacity());
	}

	public int getMaxSpeed() {
		return engine.getMaxspd();
	}

	public double drive(int distance, double xRatio, double yRatio) {

		double angle = 0;

		// this gets the angle
		if (xRatio != 0)
			angle = Math.atan(yRatio / xRatio);

		else {

			angle = Math.PI / 2.0;
		}
		// gets the distance travel on the x and y coordinate
		int xsub;
		// i need to formulate a if statement to change the signs relating to
		// the direction
		xsub = (int) ((double) distance * Math.abs(Math.cos(angle)));
		if (xRatio < 0)
			xsub *= -1;

		locationX += xsub;

		if (yRatio > 0) {

			int ysub = (int) (distance * (Math.abs((Math.sin(angle)))));
			locationY += ysub;

		} else { // if the direction is negative
			int ysub = (int) (-1 * distance * (Math.abs(Math.sin(angle))));
			locationY += ysub;

		}

		// ---------------------------------------------------

		// This is the distance portion and also the fuel portion
		if (getFuelLevel() >= (double)distance / (double)getMPG()) {
			totalmilesdriven += distance;
			gas.setLevel(getFuelLevel() - (double) (distance) / (double) (getMPG()));
			return distance;
		} else {
			System.out.printf("Ran out of gas after driving %.2f miles\n", getFuelLevel() * getMPG());

			// change distance to the actual
			// amount----------------------------------------
			if (xRatio > 0) {
				locationX -= (int) ((int) distance * (Math.cos(angle)));
				locationX += (int) ((int) (getFuelLevel() * getMPG()) * Math.abs(Math.cos(angle)));

			} else { // if the direction is negative
				locationX -= (int) ((int) (-1 * distance * (Math.cos(angle))));
				locationX += (int) ((int) (-1 * getFuelLevel() * getMPG()) * Math.abs(Math.cos(angle)));

			}
			if (yRatio > 0) {
				locationY -= (int) ((int) distance * (Math.abs(Math.sin(angle))));
				locationY += (int) ((int) (getFuelLevel() * getMPG()) * (Math.abs(Math.sin(angle))));

			} else { // if the direction is negative
				locationY -= (int) ((int) (-1 * distance * (Math.abs(Math.sin(angle)))));
				locationY += (int) ((int) (-1 * getFuelLevel() * getMPG()) * (Math.abs(Math.sin(angle))));

			}

			// ------------------------------------------------------------------------

			totalmilesdriven += (int) (getFuelLevel() * getMPG());

			int totalmilesleft = (int) (getFuelLevel() * getMPG());
			gas.setLevel(getFuelLevel() - (double) (distance) / (double) (getMPG()));

			return totalmilesleft;
		}
		// ----------------------------------------------------------------------------------

		// i just need a returning argument down here

		// ------------------------------------------------------------------------

	}

	public void updateImage(Graphics g) {
		// Move the sprite
		// super.setX(super.getX()+1);
		// super.getY();
		super.updateImage(g);
	}

}