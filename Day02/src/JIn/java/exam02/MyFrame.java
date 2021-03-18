package JIn.java.exam02;

import java.awt.*;
import java.awt.event.*;
/**
 * Event Listener를 Frame 자체에서 구현
 */
public class MyFrame extends Frame implements WindowListener {

	private static final long serialVersionUID = 1L;

	public MyFrame() {
		super("두번째");
		addWindowListener(this);
		setSize(300, 200);
		setVisible(true);
	}
	
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}