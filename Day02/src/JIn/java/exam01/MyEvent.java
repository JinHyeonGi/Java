package JIn.java.exam01;

import java.awt.event.*;

public class MyEvent extends WindowAdapter {
	@Override	// Window창 종료 기능 오버라이딩
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}