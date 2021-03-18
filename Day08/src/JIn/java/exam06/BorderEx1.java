package JIn.java.exam06;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderEx1 extends JFrame {
	private JButton[] jb = new JButton[6];

	public BorderEx1() {
		super("Test");
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(3, 2, 5, 5));
		for (int i = 0; i < 6; i++) {
			jb[i] = new JButton(i + "번 버튼");
			con.add(jb[i]);
		}
		EmptyBorder eb = new EmptyBorder(10, 10, 10, 10);
		jb[0].setBorder(eb);
		LineBorder lb = new LineBorder(Color.red, 5);
		jb[1].setBorder(lb);
		EtchedBorder ebl = new EtchedBorder();
		jb[2].setBorder(ebl);
		BevelBorder bb = new BevelBorder(BevelBorder.RAISED);
		jb[3].setBorder(bb);
		SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		jb[4].setBorder(sbb);
		MatteBorder mb = new MatteBorder(5, 10, 15, 20, Color.green);
		jb[5].setBorder(mb);
		this.setSize(300, 200);
		this.setVisible(true);
	}

	public static void main(String[] ar) {
		new BorderEx1();
	}

}
