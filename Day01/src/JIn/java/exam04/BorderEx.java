package JIn.java.exam04;

import java.awt.*;

public class BorderEx extends Frame {

	private static final long serialVersionUID = 1L;
	Label a, b, c, d, e;

	public BorderEx() {
		super("BorderLayout");
		setLayout(new BorderLayout(5, 5));
		a = new Label("↑", Label.CENTER);
		b = new Label("↓", Label.CENTER);
		c = new Label("←", Label.CENTER);
		d = new Label("→", Label.CENTER);
		e = new Label("이동", Label.CENTER);

		setBackground(Color.gray);
		a.setBackground(Color.red);
		b.setBackground(Color.green);
		c.setBackground(Color.blue);
		d.setBackground(Color.magenta);
		e.setBackground(Color.yellow);
		a.setForeground(Color.white);
		b.setForeground(Color.white);
		c.setForeground(Color.white);
		d.setForeground(Color.white);
		e.setForeground(Color.white);
		add("North", a);	// 위치 설정
		add("South", b);
		add(c, BorderLayout.WEST);
		add(d, BorderLayout.EAST);
		add("Center", e);
		setLocation(300, 300);
		pack();	// 내용에 맞게 윈도우 창의 크기를 조절함
		setVisible(true);
	}

	public static void main(String[] ar) {
		BorderEx bs = new BorderEx();
	}
}
