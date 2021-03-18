package JIn.java.exam05;

import java.awt.*;
import javax.swing.*;

public class JTextAreaEx extends JFrame {
	private JTextArea ta = new JTextArea(5, 10);
	private JScrollPane js = new JScrollPane(ta);

	public JTextAreaEx() {
		super("Test");
		JPanel jp = (JPanel) this.getContentPane();
		jp.setLayout(new BorderLayout());
		jp.add("Center", js);
		setSize(new Dimension(300, 200));
		setVisible(true);
	}

	public static void main(String[] ar) {
		new JTextAreaEx();
	}
}
