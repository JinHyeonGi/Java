package JIn.java.exam09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class ListDataEx extends JFrame implements ListDataListener {
	private JRootPane jrp;
	private Container con;
	private DefaultListModel dlm = new DefaultListModel();
	private JList jl = new JList(dlm);
	private JScrollPane jsp = new JScrollPane(jl);

	public ListDataEx() {
		super("Tesf");
		setForm();
		setEvent();
		setSize(300, 200);
		setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		dlm.set(2, "BBB2");
	}

	public void setForm() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", new JLabel("ListData Event !!!", JLabel.CENTER));
		con.add("South", new JButton("확인"));
		dlm.addElement("AAA0");
		dlm.addElement("AAA1");
		dlm.addElement("AAA2");
		dlm.addElement("AAA3");
		dlm.addElement("AAA4");
		dlm.addElement("AAA5");
		dlm.addElement("AAA6");
		dlm.addElement("AAA7");
		dlm.addElement("AAA8");
		dlm.addElement("AAA9");
		con.add("Center", jsp);
	}

	public void setEvent() {
		dlm.addListDataListener(this);
	}

	public void contentsChanged(ListDataEvent e) {
		if (e.getSource() == dlm) {
			System.out.println(e.getIndex0() + "번의 내용이 변경되었습니다.");
		}
	}

	public void intervalAdded(ListDataEvent e) {
	}

	public void intervalRemoved(ListDataEvent e) {
	}

	public static void main(String[] ar) {
		new ListDataEx();
	}
}
