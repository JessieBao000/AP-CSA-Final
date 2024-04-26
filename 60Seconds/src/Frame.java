import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	
	
	Map map;
	
	static String state = "California";
	
	static HashMap dangers = new HashMap<String, State>();
	static HashMap itemsList = new HashMap<String, ItemsInfo>();
	
	int disaster = 0;
	
    Item[] items;
	Item test;
	

	
	
	
	

	public void paint(Graphics g) {
		super.paintComponent(g);
		
		map.paint(g);
		
		if(map.getDir()==4) {
			items[0].paint(g);
		}
	    
	}
	
	public static void main(String[] arg) {
		
		/*
		 * DISASTERS HASHMAP
		 */
		
		try {
			
			
			Scanner scanner = new Scanner(new File("disasters.txt"));
			scanner.next();

			while(scanner.hasNext()) {
				String line = scanner.next();
				String s="";
				int earthquake = 0;
				int volcano=0;
				int bomb=0;
				
				//System.out.println(line);
				String[] arr= line.split(",",5);
				
				for(int i = 0; i<4;i++) {
					
					if(i==0) {
						s = arr[i].trim();
						s = s.toLowerCase();
						state = s;
					}else if(i==1) {
						earthquake = Integer.valueOf(arr[i]);
					}else if(i==2) {
						volcano = Integer.valueOf(arr[i]);
					}else if(i==3) {
						bomb = Integer.valueOf(arr[i]);
					}
					
				}
				
				
				State temp = new State(s, earthquake, volcano, bomb);
				//System.out.println(s + earthquake + volcano + bomb);
				dangers.put(s,temp);
				
				
				
			}
			
			scanner.close();
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		
		
		
		/*
		 * ITEMS HASHMAP
		 */
		try {
			
			
			Scanner scanner = new Scanner(new File("items.txt"));
			scanner.next();
			
			while(scanner.hasNext()) {
				String line = scanner.next();
				String n="";
				int hunger = 0;
				int saftey=0;
				int health=0;
				int sanity = 0;
				
				//System.out.println(line);
				String[] arr= line.split(",",6);
				
				for(int i = 0; i<5;i++) {
					
					if(i==0) {
						n = arr[i].trim();
						n = n.toLowerCase();
					}else if(i==1) {
						hunger = Integer.valueOf(arr[i]);
					}else if(i==2) {
						saftey = Integer.valueOf(arr[i]);
					}else if(i==3) {
						health = Integer.valueOf(arr[i]);
					}else if(i==4) {
						sanity = Integer.valueOf(arr[i]);
					}
					
				}
				
				
				ItemsInfo temp = new ItemsInfo(n, hunger, saftey, health, sanity);
				//System.out.println(s + earthquake + volcano + bomb);
				itemsList.put(n,temp);
				System.out.println(n);
				
				
				
				
			}
			
			scanner.close();
			
			
			
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		
		
		Frame f = new Frame();
			
		
		
		
		
	}
	
	public Frame() {
		JFrame f = new JFrame("60 Seconds");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.cyan);
		f.add(this);
		f.setResizable(false);
 		f.addMouseListener(this);
		f.addKeyListener(this);




		map = new Map();
		items = new Item[15];
		for(int i =0; i<items.length;i++) {
			Item a = new Item();
			a.setDir(i);
			items[i] = a;
		}


		statePopup();
		
		openPopup();
		
	
		//backgroundMusic.play();

	
		
		//the cursor image must be outside of the src folder
		//you will need to import a couple of classes to make it fully 
		//functional! use eclipse quick-fixes
		/*setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("torch.png").getImage(),
				new Point(0,0),"custom cursor"));	
		*/
		
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public void statePopup() {
        // Show input dialog with a message and default value
        String userInput = JOptionPane.showInputDialog(
            null, 
            "Enter a United State:", 
            "User Input", 
            JOptionPane.QUESTION_MESSAGE
        );
        
        
		String tempstate = userInput.replace(" ", "");
		state = tempstate.toLowerCase();
		System.out.println("looks like "+ state);

        // If user input is not null and not empty, display it
        while ((userInput.equals(null) )|| userInput.isEmpty() || !dangers.containsKey(state)) {
           		
             System.out.println("Enter in a new state");
                    
             userInput = JOptionPane.showInputDialog(
                      null, 
                      "Enter a valid United State", 
                      "User Input", 
                      JOptionPane.QUESTION_MESSAGE
                 );
             
            state = userInput.toLowerCase();
     		state = userInput.replace(" ", "");
            
        } 
        
        State temp = (State)(dangers.get(state));
   		System.out.println(state + temp.getEarthquake() + " " + temp.getVolcano() + " "+ temp.getBomb());
   		state = temp.getState();
    }
	
	
	public void openPopup() {
        // Show input dialog with a message and default value
		    /* Simple JOptionPane ShowOptionDialogJava example */    
		    String[] options = { "Earthquake", "Volcano", "Bomb" };
		    int selection = JOptionPane.showOptionDialog(null, "You have 60 seconds to gather supplies before a disaster, which one will happen?", "Disaster Struck!", 
		                                                      0, 3, null, options, options[0]);
		    if (selection == 0) {
		      disaster = 1;
		    }
		    if (selection == 1) { 
		    	disaster = 2;
		    }
		    if (selection == 2) { 
		    	disaster = 3;
		  }
		    
		  // startTimer();
    }

	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		
	
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		//87-w 65-a 83-s 68-d
		//37-left 38-up  39-right 40-down  
		
		
		
		switch(k.getKeyCode()){
			case 37: //left
				//map.dir=0;
				if(map.getDir()-1<0) {
					map.dir = map.maxDir;
				}else {
					map.dir = map.getDir()-1;
				}
				
				
				
				break;
				
			case 39: //right
				//map.dir=1;
				if(map.getDir()+1>map.maxDir) {
					map.dir = 0;
				}else {
					map.dir = map.getDir()+1;
				}
				
				break;
				
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public static void playSound(String soundFilePath) {
	        try {
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
	                    Frame.class.getClassLoader().getResourceAsStream("sounds/" + soundFilePath)
	            );

	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();

	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	
	
	 
	
	
}