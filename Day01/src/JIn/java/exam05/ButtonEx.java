package JIn.java.exam05;

import java.awt.*;

public class ButtonEx extends Frame {
	private String[] str = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "#", "0", "*"};
	private Button[] bt = new Button[str.length];
	public ButtonEx() {
		super("Button Example");
		setLayout(new GridLayout(4, 3, 5, 5));	// 버튼 위치 설정
		for (int i = 0; i < bt.length; i++) {
			bt[i] = new Button(str[i]);
			bt[i].setFont(new Font("굴림체", Font.BOLD, 30));
			add(bt[i]);
		}
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] ar) {
		ButtonEx be = new ButtonEx();
	}
}