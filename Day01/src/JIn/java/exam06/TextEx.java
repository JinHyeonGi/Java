package JIn.java.exam06;

import java.awt.*;

public class TextEx extends Frame {

	private static final long serialVersionUID = 1L;
	private TextField tf = new TextField("제목 : ");
	private TextArea ta = new TextArea("메모", 5, 10);
	private Button bt = new Button("확인");
	private Label la = new Label("취소");

	public TextEx() {
		super("TextExtField");
		setLayout(new BorderLayout());
		add("North", tf);
		add("South", bt);
		add("Center", ta);
		add("West", la);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] ar) {
		TextEx te = new TextEx();
	}
}
