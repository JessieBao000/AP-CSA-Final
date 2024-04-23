import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Map {

	private Image living, garage, stewie, attic, kitchen; 
	private AffineTransform tx;
	
	public int dir=0;
	public int maxDir=2;
	int width, height;
	int x, y;				
	double scaleWidth = 0.75;		
	double scaleHeight = 0.75;
	
	public Map() {
		
		living 	= getImage("/imgs/"+"familyguyroom.PNG"); 
		garage 	= getImage("/imgs/"+"garage.PNG"); 
		stewie 	= getImage("/imgs/"+"stewie.png"); 
		attic 	= getImage("/imgs/"+"houseattic.PNG"); 
		kitchen 	= getImage("/imgs/"+"kitchen.png"); 
		
		width = 900;
		height = 600;
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		
		init(x, y); 
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		

		g.drawRect(x, y, width, height);

		init(x,y);
		
		switch(dir) {
			case 0:
				g2.drawImage(living, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 1:
				g2.drawImage(garage, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 2:
				g2.drawImage(stewie, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 3:
				g2.drawImage(attic, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
			case 4:
				g2.drawImage(kitchen, tx, null);
				g.drawRect(x, y, width, height);
				break;
				
		}
		


	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}

	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Map.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Map f = new Map();
	}

}
