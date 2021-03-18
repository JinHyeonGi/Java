package JIn.java.exam01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameEx extends JFrame {
	public JFrameEx() {
		super("JFrame 테스트");
		JButton bt1 = new JButton("Hello Swing North");
		JButton bt2 = new JButton("Hello Swing Center");
		Container con = getContentPane();
		con.add("North", bt1);
		add(bt2);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JFrameEx();
	}
}
