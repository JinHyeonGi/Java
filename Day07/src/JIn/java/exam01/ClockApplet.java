package JIn.java.exam01;
import java.awt.*;
import java.util.*;
import java.applet.*;

public class ClockApplet extends Applet implements Runnable {
	public void init() {
		setBackground(Color.white);
	}

	public void start() {
		Thread th = new Thread(this);
		th.start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		Calendar ca = Calendar.getInstance();
		Date d = ca.getTime();
		g.setFont(new Font("Sans—Serif", Font.BOLD, 20));
		g.drawString(d.toString(), 50, getSize().height / 2);
	}
}