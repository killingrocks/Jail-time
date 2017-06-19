import java.util.Random;
import java.awt.Graphics;

public class RobberCar extends Car{
	private int xRatio;
	private int yRatio;
	private Random random = new Random ();
	private int number;
	private int number2;
	private static int robberscap = 0 ;
	private static int escape;
	private boolean escaped;
	
private boolean capture;
		RobberCar(){
			// set each to a random value
	
			super("RobberCar", 5000,new Engine("Look", 20, 200), "red-car.jpg");
			escaped = false;
			capture =false;
			fillUp();
			number= random.nextInt(6);
			number2 = random.nextInt(6);
			if (number %2 == 0)
			xRatio= random.nextInt(6);
			else
			xRatio= -1*random.nextInt(6);
			
			if (number2 %2 == 0)
				yRatio= random.nextInt(6);
				else
				yRatio= -1*random.nextInt(6);

			//String description, int Maxfuel, Engine initengine, String jpgName
		}
		
		
		public void updateImage(Graphics g) {

			super.updateImage(g);
		}
		
		
		public void updateScene(int x , int y) {
			if (locationX <= x+4 && locationY <= y+4 && locationX >= -4  && locationY >= -4)// does not count the robber car is its over the bounds
				if(locationX > x ||locationY >y || locationX < 0 || locationY < 0){	// counts the robber car if it passes the bounds	
				escaped = true;	
				escape++;
				}
					
		}
		
		public void updateState() {
				
			if(isCapture())
			drive(0,xRatio, yRatio);
			else
			drive(4,xRatio, yRatio);	// if captured i want it to stop the driving method
		}

		public boolean hasEscaped(){
	
			if(escaped) {	// counts the robber car if it passes the bounds	
			//	System.out.println(escape);
				return true;
			}
			return false;
		}
		
		public void captured(){
			
			setImage("jail.jpg");
			capture = true;
			robberscap++;
		}
		
		
		public boolean isCapture(){// returns true only if the robber car is captured
		
			if (capture)
		return true;
				return false;
		}
		
		public static int getRobberscap(){
			return robberscap;
		}
		public static int getEscape(){
			return escape;
		}
		public static void reset(){
			robberscap = 0;
			escape = 0 ; 
		}
		
	}