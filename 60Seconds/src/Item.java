import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Item {

	private Image soup,water,aid,shelter,cloth,knife,flashlight,
	 				radio,gas,soap,map,gloves,family,generator,book; 
	private AffineTransform tx, tx2;
	
	public int dir=0;
	public int maxDir=15;
	int width, height;
	int x, y;				
	double scaleWidth = 0.6;		
	double scaleHeight = 0.6;
	double scaleWidth2 = 0.2;		
	double scaleHeight2 = 0.2;
	
	public Item() {
		
		soup 	= getImage("/imgs/"+"campbell.png"); 
		water 	= getImage("/imgs/"+"water.png"); 
		aid 	= getImage("/imgs/"+"campbell.png"); 
		shelter = getImage("/imgs/"+"water.png"); 
		cloth 	= getImage("/imgs/"+"campbell.png"); 
		knife 	= getImage("/imgs/"+"water.png"); 
		flashlight 	= getImage("/imgs/"+"campbell.png"); 
		radio 	= getImage("/imgs/"+"water.png"); 
		gas 	= getImage("/imgs/"+"campbell.png"); 
		soap 	= getImage("/imgs/"+"water.png"); 
		map 	= getImage("/imgs/"+"campbell.png"); 
		gloves 	= getImage("/imgs/"+"water.png"); 
		family 	= getImage("/imgs/"+"water.png"); 
		generator 	= getImage("/imgs/"+"campbell.png"); 
		book 	= getImage("/imgs/"+"water.png"); 
		
		width = 60;
		height = 100;
		x = 0;
		y = 0;
		
		tx = AffineTransform.getTranslateInstance(0, 0);
		tx2 = AffineTransform.getTranslateInstance(0, 0);
		
		//init(x, y); 
		
	}

	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		

		//g.drawRect(x, y, width, height);

		
		switch(dir) {
			case 0:
				init(100,100);
				g2.drawImage(soup, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 1:
				init2(200,200);
				g2.drawImage(water, tx2, null);
				//g.drawRect(x, y, width, height);
				break;
			case 2:
				init(x,y);
				g2.drawImage(aid, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 3:
				init(x,y);
				g2.drawImage(shelter, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 4:
				init(x,y);
				g2.drawImage(cloth, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 5:
				init(x,y);
				g2.drawImage(knife, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 6:
				init(x,y);
				g2.drawImage(flashlight, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 7:
				init(x,y);
				g2.drawImage(radio, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 8:
				init(x,y);
				g2.drawImage(gas, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 9:
				init(x,y);
				g2.drawImage(soap, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 10:
				init(x,y);
				g2.drawImage(map, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 11:
				init(x,y);
				g2.drawImage(gloves, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 12:
				init(x,y);
				g2.drawImage(family, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 13:
				init(x,y);
				g2.drawImage(generator, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			case 14:
				init(x,y);
				g2.drawImage(book, tx, null);
				//g.drawRect(x, y, width, height);
				break;
			
		}
		


	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scaleWidth, scaleHeight);
	}
	
	
	private void init2(double a, double b) {
		tx2.setToTranslation(a, b);
		tx2.scale(scaleWidth2, scaleHeight2);
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
