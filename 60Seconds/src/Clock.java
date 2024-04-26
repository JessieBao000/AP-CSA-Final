import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import java.awt.Font;



public class Clock {
static int interval;
static Timer timer;

public void paint(Graphics g) {
	Scanner sc = new Scanner(System.in);
	boolean b = true;
    String secs = "60";
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = Integer.parseInt(secs);
	Graphics g2 = (Graphics) g;
	//g2.setFont("Digital-7 Mono");
	g2.drawString(secs, 400, 30);
	
	timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
            System.out.println(setInterval());
            

        }
    }, delay, period);

}

private static final int setInterval() {
    if (interval == 1)
        timer.cancel();
    return --interval;
}


}
