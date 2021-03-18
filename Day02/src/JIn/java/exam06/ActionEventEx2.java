package JIn.java.exam06;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx2 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Button bt = new Button("확인");
	
	ActionEventEx2() {
		super("ActionEventEx2");
		bt.addActionListener(this);
		setLayout(new FlowLayout());
		add(bt);
		setSize(300, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new ActionEventEx2();
	}
}