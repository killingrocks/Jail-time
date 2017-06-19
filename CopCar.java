import java.util.Random;
import java.awt.Graphics;

public class CopCar extends Car{
	private static int xRatio = 0;
	private static int yRatio = 0;
	private int xDirection = 1;
	private int yDirection = 1;
	private Random random = new Random ();

	
		CopCar(){
			super("CopCar", 5000,new Engine("Look", 30, 100), "cop-car.jpg");

			fillUp();
			
			// simplified random direction:
			xRatio = (random.nextInt(11) - 5);
			yRatio = (random.nextInt(11) - 5);
			
			
			/*number= random.nextInt(6);
			number2 = random.nextInt(6);
			if (number %2 == 0)
			xRatio= random.nextInt(6);
			else
			xRatio= -1*random.nextInt(6);
			
			if (number2 %2 == 0)
				yRatio= random.nextInt(6);
				else
				yRatio= -1*random.nextInt(6);	*/
		}
		public void updateScene(int x, int y){
			if (locationY >= y || locationY <= 0)
				yDirection = -1 * yDirection;
			if (locationX >= x || locationX <= 0)
				xDirection = -1 * xDirection;
		}	
		public void updateImage(Graphics g) {
	        // Move the sprite
			super.updateImage(g);
		}
		public void updateState() {
	        // Move the sprite
			drive(2,xDirection * xRatio, yDirection * yRatio);
		}
}
