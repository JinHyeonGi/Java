package JIn.java.exam05;

import java.awt.*;
import java.awt.event.*;

public class ActionEventEx1 extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TextField tf = new TextField(10);
	
	ActionEventEx1(){
		super("ActionEventEx1");
		setLayout(new FlowLayout());
		add(tf);
		tf.addActionListener(this);
		setSize(300, 200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf) {
			String imsi = tf.getText();
			System.out.println("메시지 :" + imsi);
			tf.setText("");
		}
	}
	
	public static void main(String[] args) {
		new ActionEventEx1();
	}
}