package JIn.java.exam13;

import java.awt.*;
import java.awt.event.*;

public class KeyEventEx extends Frame implements KeyListener {
	Label la = new Label("주민번호 : ", Label.RIGHT);
	Label la1 = new Label("-", Label.CENTER);
	TextField jumin1 = new TextField(10);
	TextField jumin2 = new TextField(10);
	Button bt = new Button("확인");

	KeyEventEx() {
		super("KeyEventEx");
		setForm();
		setEvent();
		pack();
		setVisible(true);
	}

	public void setEvent() {
		jumin1.addKeyListener(this);
		jumin2.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == jumin1) {
			if (jumin1.getText().trim().length() == 6)
				jumin2.requestFocus();
		}
		if (e.getSource() == jumin2) {
			if (jumin2.getText().trim().length() == 7)
				bt.requestFocus();
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void setForm() {
		setLayout(new BorderLayout());
		add("West", la);
		Panel p = new Panel(new FlowLayout(FlowLayout.LEFT));
		p.add("West", jumin1);
		p.add("Center", la1);
		p.add("East", jumin2);
		add("Center", p);
		Panel pl = new Panel(new FlowLayout(FlowLayout.RIGHT));
		pl.add(bt);
		add("South", pl);
	}

	public static void main(String[] ar) {
		new KeyEventEx();
	}
}