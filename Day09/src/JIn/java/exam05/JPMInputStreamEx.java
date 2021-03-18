package JIn.java.exam05;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JPMInputStreamEx extends JFrame implements ActionListener, Runnable {
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JButton jbt = new JButton("로딩");
	private JButton jbtl = new JButton("종료");
	private JFileChooser jfc = new JFileChooser();
	private File f;
	private ProgressMonitorInputStream pmi;
	private BufferedInputStream bis;

	public JPMInputStreamEx() {
		super("Test");
		setForm();
		jbt.addActionListener(this);
	}

	public void run() {
		ProgressMonitor pm = pmi.getProgressMonitor();
		pm.setNote("Started");
		int imsi = 0;
		int kk = 0;
		jta.setText("");
		long size = f.length();
		jta.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		try {
			while ((imsi = pmi.read()) != -1) {
				pm.setNote((int) (kk / (float) size * 100) + "%");
				pm.setProgress(kk++);
				jta.append("" + (char) imsi);
				try {
					Thread.sleep(10);
				} catch (InterruptedException ee) {
				}
			}
		} catch (IOException eee) {
		}
		pm.close();
		jta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbt) {
			jfc.showOpenDialog(this);
			f = jfc.getSelectedFile();
			if (f == null)
				return;
			try {
				pmi = new ProgressMonitorInputStream(this, "Loading " + f.getName() + "...", new FileInputStream(f));
			} catch (IOException ee) {
				System.err.println("IOError = " + ee);
			}
			new Thread(this).start();
		}
	}

	private void setForm() {
		add("Center", jsp);
		jsp.setBorder(new TitledBorder("Loading..."));
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(jbt);
		p.add(jbtl);
		add("South", p);
		setSize(300, 200);
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(d.width / 2 - 150, d.height / 2 - 100);
	}

	public static void main(String[] ar) {
		new JPMInputStreamEx();
	}
}