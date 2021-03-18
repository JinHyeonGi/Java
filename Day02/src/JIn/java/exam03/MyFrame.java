package JIn.java.exam03;

import java.awt.*;
import java.awt.event.*;
/**
 * 내부 Class를 통해 Event Listener 작성 및 생성
 */
public class MyFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	class MyEvent extends WindowAdapter{	// MyFrame$MyEvent.class
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	public MyFrame() {
		super("세번째");
		
		addWindowListener(new MyEvent());
		
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}