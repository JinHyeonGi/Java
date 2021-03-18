package JIn.java.exam05;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ClockEx extends Frame implements ActionListener, Runnable {
	private Button bt = new Button("시작");

	public ClockEx() {
		super("시계");
		setLayout(new BorderLayout());
		add("South", bt);
		bt.addActionListener(this);
		setSize(600, 200);
		setVisible(true);
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			bt.setEnabled(false);
			Thread tt = new Thread(this);
			tt.start();
		}
	}

	public void paint(Graphics g) {
		Calendar ca = Calendar.getInstance();
		Date d = ca.getTime();
		g.setFont(new Font("굴림체", Font.BOLD, 30));
		g.drawString(d.toString(), 50, 100);
	}

	public static void main(String[] ar) {
		ClockEx cs = new ClockEx();
	}
}
