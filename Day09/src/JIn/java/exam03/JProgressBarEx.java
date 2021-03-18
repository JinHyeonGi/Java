package JIn.java.exam03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarEx extends JFrame implements ActionListener, Runnable {
	private JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	private JButton jbt = new JButton("시작");
	private JButton jbtl = new JButton("멈춤");

	public JProgressBarEx() {
		super("Test");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("이것이 프로그레스 바당..."));
		con.add("Center", jpb);
		jpb.setStringPainted(true);
		jpb.setString("0%");
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(jbt);
		jp.add(jbtl);
		jbt.addActionListener(this);
		jbtl.addActionListener(this);
		con.add("South", jp);
		setSize(300, 150);
		setVisible(true);
	}

	private boolean bb = true;
	private static int ii;

	public void run() {
		if (ii == 100)
			ii = 0;
		for (int i = ii; i <= 100; i++) {
			if (!bb)
				break;
			try {
				Thread.sleep(50);
			} catch (InterruptedException ee) {
			}
			jpb.setValue(i);
			ii = i;
			jpb.setString(i + "%");
		}
		jbt.setEnabled(true);
		jbtl.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbt) {
			bb = true;
			new Thread(this).start();
			jbt.setEnabled(false);
			jbtl.setEnabled(true);
		} else if (e.getSource() == jbtl) {
			bb = false;
			jbt.setEnabled(true);
			jbtl.setEnabled(false);
		}
	}

	public static void main(String[] ar) {
		new JProgressBarEx();
	}
}
