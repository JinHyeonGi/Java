package JIn.java.exam02;

import java.awt.Button;
import java.awt.Frame;
/**
 * Frame 클래스를 상속받아서 만드는 방법
 */
public class MyFrame extends Frame {

	private static final long serialVersionUID = 1L;
	private Button bt1 = new Button("확인");	// 확인이라는 버튼을 생성 (bt1)
	private Button bt2 = new Button("취소");	// 취소라는 버튼을 생성 (bt2)
	
	public MyFrame() {
		super("연습");	// 타이틀을 연습이라 설정
		add(bt1);	// bt1을 추가
		add(bt2);	// bt2를 추가
		setSize(300, 200);	// 창을 300, 200 크기로 설정
		setVisible(true);	// 창을 보여준다
	}
	
	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}