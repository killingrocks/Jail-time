public class GasTank {
	
	private int capacity;
	// the maximum capacity of the car
	
	private double level;
	
	public GasTank(int sentcapacity){
		
		capacity=0;
		
		if(sentcapacity>0)
		capacity= sentcapacity;
		
		
		level = 0;
		
	}
	
	public  int getCapacity(){
		return capacity;
	}
	// this is the maximum capacity
	
	public double getLevel(){
		return level;
	}
	
	public void setLevel (double levelIn){
		if (levelIn > 0)
			level = levelIn;
		else
			level = 0;
	}

	
}