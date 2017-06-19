
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller implements MouseListener, KeyListener 
// when i put KeyListener it made wanted me to put the methods
{
    Model model;
    View view;
    Sprite sprite;
  //  Car car;

    Controller() throws IOException, Exception {
        model = new Model();// you create the image with this
        view = new View(this); // this is the movement
 // create a Controller

        
        // they said i should remove the timer in part 6
// new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e){
    	// Gets here is left mouse button was clicked
		if (SwingUtilities.isLeftMouseButton(e)){
		model.CreateandLocation(e.getX(), e.getY());
		 view.repaint();	
		} 
		
		else if (SwingUtilities.isRightMouseButton(e)){
			// Gets here if right mouse button was clicked
			// fill up all the tanks
			model.updateScene(  view.getWidth()  ,  view.getHeight() );
			view.repaint();
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {  }

    public static void main(String[] args) throws Exception {
        new Controller();
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'h')
			System.out.println("hello world");
		else if (e.getKeyChar () == 'n')
model.captureAndEscape();
		else if (e.getKeyChar() == 'r'){
			model.initialize();
			view.repaint();
		}
		else if (e.getKeyChar() == 's'){
			start();
		}
		
		// TODO Auto-generated method stub
	}
	public void start() {
    	Thread name= new Thread(new SpriteMover(model, view));
    	name.start();
    }
}
