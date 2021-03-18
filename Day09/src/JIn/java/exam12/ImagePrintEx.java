package JIn.java.exam12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImagePrint extends JComponent implements Runnable {
	private Image image;
	private int x, y, w, h;
	private MediaTracker mt = new MediaTracker(this);
	private Graphics graphics;

	public ImagePrint() {
		image = Toolkit.getDefaultToolkit().getImage("image/yuna.jpg");
		mt.addImage(image, 0);
		w = image.getWidth(this);
		h = image.getHeight(this);
		new Thread(this).start();
	}

	public Graphics returnlnfo() {
		return graphics;
	}

	public void run() {
		while (true) {
			mt.checkID(0, true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if (mt.checkID(0)) {
			g.drawImage(image, x, y, w, h, 0, 0, image.getWidth(null), image.getHeight(null), this);
		} else {
			g.drawString("Not Yet!!", 100, 100);
		}
		graphics = g;
	}

	public void setting(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public Image returnImage() {
		return image;
	}
}

public class ImagePrintEx extends JFrame implements ActionListener {
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm = new JMenu("옵션");
	private JMenuItem jmi = new JMenuItem("기준그림");
	private JMenuItem jmi1 = new JMenuItem("상하반전");
	private JMenuItem jmi2 = new JMenuItem("좌우반전");
	private JMenuItem jmi3 = new JMenuItem("프린트하기");
	private ImagePrint is = new ImagePrint();

	public ImagePrintEx() {
		super("ImagePrintEx");
		jm.add(jmi);
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(jmi3);
		jmi.addActionListener(this);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		jmi3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		jmb.add(jm);
		setJMenuBar(jmb);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add("Center", is);
		setSize(510, 800);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jmi) {
			Image ii = is.returnImage();
			is.setting(0, 0, ii.getWidth(null), ii.getHeight(null));
			is.repaint();
		} else if (e.getSource() == jmi1) {
			Image ii = is.returnImage();
			is.setting(0, ii.getHeight(null), ii.getWidth(null), 0);
			is.repaint();
		} else if (e.getSource() == jmi2) {
			Image ii = is.returnImage();
			is.setting(ii.getWidth(null), 0, 0, ii.getHeight(null));
			is.repaint();
		} else if (e.getSource() == jmi3) {
			PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(this, "Grim", null);
			Graphics printGraphics = pj.getGraphics();
			printGraphics.drawImage(is.returnImage(), 0, 0, is.returnImage().getWidth(null),
					is.returnImage().getHeight(null), this);
			printGraphics.dispose();
			pj.end();
		}
	}

	public static void main(String[] ar) {
		new ImagePrintEx();
	}
}