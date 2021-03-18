package JIn.java.exam14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPopupEx extends JFrame implements MouseListener {
	private JTextField jtf = new JTextField("None");
	private JPopupMenu jpm = new JPopupMenu();
	private JMenuItem jmi = new JMenuItem("Copy");
	private JMenuItem jmi1 = new JMenuItem("Cut");
	private JMenuItem jmi2 = new JMenuItem("Paste");

	public JPopupEx() {
		super("JPopupEx");
		jpm.add(jmi);
		jmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Copy");
			}
		});
		jpm.add(jmi1);
		jmi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Cut");
			}
		});
		jpm.add(new JSeparator());
		jpm.add(jmi2);
		jmi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf.setText("Paste");
			}
		});
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jtf);
		this.addMouseListener(this);
		setSize(300, 200);
		setVisible(true);
		jtf.setEditable(false);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == this) {
			if (e.isPopupTrigger()) {
				jpm.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] ar) {
		new JPopupEx();
	}
}
