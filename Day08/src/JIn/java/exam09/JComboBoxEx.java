package JIn.java.exam09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxEx extends JFrame {
	public JComboBoxEx() {
		super("JComboBox 테스트");
		setLayout(new FlowLayout());
		String[] citems = { "One", "Two", "Three", "Four", "Five" };
		JComboBox combo = new JComboBox(citems);
		add(combo);
		DefaultComboBoxModel cmodel = new DefaultComboBoxModel();
		cmodel.addElement("Chicken");
		cmodel.addElement("Potato");
		combo = new JComboBox();
		combo.setModel(cmodel);
		DefaultComboBoxModel cxmodel = (DefaultComboBoxModel) combo.getModel();
		cxmodel.addElement("Coke");
		cxmodel.addElement("Coffee");
		cxmodel.addElement("juice");
		add(combo);
		setBounds(300, 200, 300, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JComboBoxEx();
	}
}
