package JIn.java.exam10;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionEventEx extends Frame implements MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	public MouseMotionEventEx() {
		super("Move Test");
		addMouseMotionListener(this);
		setSize(400, 300);
		setVisible(true);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (e.getSource() == this)
			System.out.println("X = " + e.getX() + ", Y = " + e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == this)
			System.out.println("X = " + e.getX() + ", Y = " + e.getY());
	}
	
	public static void main(String[] args) {
		new MouseMotionEventEx();
	}
}