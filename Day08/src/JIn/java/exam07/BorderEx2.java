package JIn.java.exam07;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderEx2 extends JFrame {
	private JTextField jtf = new JTextField();
	private Icon icon =

			new ImageIcon("image/ico03.jpg");
	private Icon iconl = new ImageIcon("image/ico04.jpg");
	private JButton jbt = new JButton("확인", icon);
	private JLabel jl = new JLabel("Test", JLabel.CENTER);

	public BorderEx2() {
		super("BorderEx");
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jtf);
		TitledBorder tb = new TitledBorder(new EtchedBorder(), "ID", TitledBorder.LEFT, TitledBorder.TOP);
		jtf.setBorder(tb);
		con.add("Center", jbt);
		MatteBorder mb = new MatteBorder(30, 30, 30, 30, iconl);
		jbt.setBorder(mb);
		con.add("South", jl);
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.red, 5), new BevelBorder(BevelBorder.RAISED));
		jl.setBorder(cb);
		this.setSize(300, 350);
		this.setVisible(true);
	}
}
