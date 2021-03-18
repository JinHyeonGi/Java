package JIn.java.exam08;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListSelectionEx extends JFrame implements ListSelectionListener {
	private Container con;
	private String[] str = { "AAA", "BBB", "CCC", "DDD", "EEE" };
	private JList li = new JList(str);
	private JScrollPane jsp = new JScrollPane(li);

	public ListSelectionEx() {
		super("Test");
		setForm();
		setEvent();
		setSize(300, 200);
		setVisible(true);
	}

	public void setForm() {
		con = this.getContentPane();
		con.setLayout(new FlowLayout());
		li.setVisibleRowCount(3);
		con.add(jsp);
	}

	public void setEvent() {
		li.addListSelectionListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == li) {
			System.out.println("첫번째 값 = " + e.getFirstIndex());
			System.out.println("마지막 값 = " + e.getLastIndex());
			System.out.println("Adjusting = " + e.getValueIsAdjusting());
			System.out.println("toString = " + e.toString());
		}
	}

	public static void main(String[] ar) {
		new ListSelectionEx();
	}
}
