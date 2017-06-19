import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite 
{
	//private String jpgName;
	protected int locationX;
	protected int locationY;
	private Image image;
	
// -------Display image at initial coordinates-----------
	public Sprite(String jpgName)
	{
		setImage(jpgName);
		// i am initializing the bank to be at 300,300 
		//because it places the back at that position 
		// at the start
		locationX = 300;
		locationY = 300;
	}
// ------------------------------------------------------
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	

// ---------- Display image ----------------------------
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));     
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
// -----------The place where you get image--------------

	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	void updateState() {
		
	}
	
	void updateScene(int x, int y) {
		
	}
	
	public boolean overlaps(Sprite s){ // when a cop car overlaps a robber car

	double Imagesize = 60*Math.sqrt(2);
	double space = Math.sqrt ( ( Math.pow( ( s.getX()-this.getX() ), 2 ) + Math.pow( ( s.getY() - this.getY() ), 2) ) );
	if (space <= Imagesize)
		return true;
	
			return false;
		
	}
	
}