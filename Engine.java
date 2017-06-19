public class Engine {
private String enginedescription;
private int mpg;
private int Maxspd;
public Engine (String initengine, int initmpg, int initmaxspd){

	enginedescription = initengine;
if (enginedescription.length() == 0)
	enginedescription = "Generic engine";


mpg = initmpg;
if (mpg < 0)
	mpg = 0;

Maxspd = initmaxspd;
if (Maxspd < 0)
	Maxspd = 0;



}



public  String getDescription(){
return String.format("%s (MPG: %d, Max speed: %d)", enginedescription,mpg, Maxspd);
}
public int getMpg(){
	return mpg;
}

public int getMaxspd(){
	return Maxspd;
	
}



}
