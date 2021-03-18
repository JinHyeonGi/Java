package JIn.java.exam13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JOptionPaneEx extends JFrame implements ActionListener {

	JButton bl, b2, b3, b4;
	String[] str = { "로그인", "회원가입" };

	public JOptionPaneEx() {
		super("JOptionPane 테스트");
		setLayout(new FlowLayout());
		bl = new JButton("MessageDialog");
		b2 = new JButton("ConfirmDialog");
		b3 = new JButton("InputDialog");
		b4 = new JButton("OptionDialog");
		add(bl);
		add(b2);
		add(b3);
		add(b4);
		pack();
		setLocation(300, 300);
		setVisible(true);
		bl.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bl) {
			JOptionPane.showMessageDialog(this, " 메세지 다이얼로그박스", "메세지", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == b2) {
			JOptionPane.showConfirmDialog(this, "확인 다이 얼 로그박스”", "확인", JOptionPane.YES_NO_CANCEL_OPTION);
		} else if (e.getSource() == b3) {
			JOptionPane.showInputDialog(this, "입 력 다이 얼 로그박스", "입 력", JOptionPane.YES_NO_OPTION);
		} else if (e.getSource() == b4) {
			JOptionPane.showOptionDialog(this, "옵션 다이얼로그박스", "옵션", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
		}
	}

	public static void main(String[] args) {
		new JOptionPaneEx();
	}
}
