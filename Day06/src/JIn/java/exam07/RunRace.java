package JIn.java.exam07;

import java.awt.*;
import java.awt.event.*;

public class RunRace extends Frame implements ActionListener {
	private Button bt = new Button("출발");
	private int count;
	private Racer[] ra;

	public RunRace(int k, String[] hn) {
		super("말 경주");
		count = k;
		setLayout(new BorderLayout());
		ra = new Racer[count];
		Panel p = new Panel(new GridLayout(count, 1));
		for (int i = 0; i < count; i++) {
			ra[i] = new Racer(hn[i] + 1.1);
			p.add(ra[i]);
		}
		add("Center", p);
		Panel p1 = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(bt);
		bt.addActionListener(this);
		add("South", p1);
		setSize(600, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			Thread[] th = new Thread[count];
			for (int i = 0; i < count; i++) {
				th[i] = new Thread(ra[i]);
				th[i].setName(ra[i].return_name());
				th[i].setPriority((int) (Math.random() * 10) + 1);
			}
			for (int i = 0; i < count; i++) {
				th[i].start();
			}
		}
	}

	public static void main(String[] ar) {
		if (ar.length < 2) {
			System.out.println("Usage : java RacerRun count namel, .. ");
			System.exit(0);
		}
		int xx = Integer.parseInt(ar[0]);
		if (xx + 1 != ar.length) {
			System.out.println("Error = (count ! = name count)");
			System.exit(0);
		}
		RunRace r = new RunRace(xx, ar);
	}
}