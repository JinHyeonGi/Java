package JIn.java.exam04;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 내부 익명 Class를 통해 Event Listener 작성 및 생성
 */
public class MyFrame extends Frame {

	private static final long serialVersionUID = 1L;

	public MyFrame() {
		super("네번째");
		addWindowListener(new WindowAdapter() {	// MyFrame$1.class
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}