package JIn.java.exam01;
import java.awt.*;
import java.awt.event.*;

public class GraphicEx1 extends Frame implements MouseListener, MouseMotionListener {
	private int x;
	private int y;
	private int w;
	private int h;

	public GraphicEx1() {
		super("GraphicEx");
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(500, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawOval(x, y, w - x, h - y);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == this) {
			x = e.getX();
			y = e.getY();
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == this) {
			w = e.getX();
			h = e.getY();
			repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == this) {
			w = e.getX();
			h = e.getY();
			repaint();
		}
	}

	public static void main(String[] ar) {
		new GraphicEx1();
	}
}
