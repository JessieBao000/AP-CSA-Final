import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;


public class Clock {

	

	public void paint(Graphics g) {

		int sec = 10;
		Timer t = new Timer();

		t.scheduleAtFixedRate(new TimerTask() {
		
	//	t.scheduleAtFixedRate(new TimerTask());;
		
		int countdown = sec;

		public void run() {
		

		g.drawString(Integer.toString(sec), 10, 20);
			
		if(countdown < 0) {
			System.out.println("complete");
			t.cancel();
			
		}
		countdown--;
		}
	}, 0, 6000);
	
	
	}
	
	   public static void main(String[] args) {
		   
	   }

}


