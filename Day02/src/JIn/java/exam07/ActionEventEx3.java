package JIn.java.exam07;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx3 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("File");
	private MenuItem now = new MenuItem("Now");
	private MenuItem exit = new MenuItem("Exit");
	
	ActionEventEx3() {
		super("ActionEventEx3");
		setMenuBar(mb);
		mb.add(file);
		file.add(now);
		file.addSeparator();
		file.add(exit);
		exit.addActionListener(this);
		setSize(300, 200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new ActionEventEx3();
	}
}