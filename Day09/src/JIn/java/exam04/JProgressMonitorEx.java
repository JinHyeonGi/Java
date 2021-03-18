package JIn.java.exam04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressMonitorEx extends JFrame implements ActionListener, Runnable {
	private Icon icon = new ImageIcon("image/myimgl.gif");
	private JButton jbt = new JButton("시작", icon);;
	private JButton jbtl = new JButton("멈춤", icon);
	private ProgressMonitor pm;
	private Thread curTh;
	private boolean bb = true;

	public JProgressMonitorEx() {
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(jbt);
		jbt.addActionListener(this);
		p.add(jbtl);
		jbtl.addActionListener(this);
		con.add("South", p);
		pack();
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dl = getSize();
		setLocation(d.width / 2 - dl.width / 2, d.height / 2 - dl.height / 2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbt) {
			jbt.setEnabled(false);
			jbtl.setEnabled(true);
			curTh = new Thread(this);
			bb = true;
			curTh.start();
		} else if (e.getSource() == jbtl) {
			jbt.setEnabled(true);
			jbtl.setEnabled(false);
			bb = false;
			curTh = null;
		}
	}

	private static int kk = 0;

	public void run() {
		pm = new ProgressMonitor(this, "ProgressMonitor", "Not Started", 0, 100);
		pm.setNote("Started");
		if (kk == 100)
			kk = 0;
		for (int i = kk; i <= 100; i++) {
			if (pm.isCanceled())
				break;
			if (!bb)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			pm.setProgress(i);
			pm.setNote(i + "%");
			kk = i;
		}
		jbt.setEnabled(true);
		jbtl.setEnabled(false);
	}

	public static void main(String[] ar) {
		new JProgressMonitorEx();
	}
}
