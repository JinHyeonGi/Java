package JIn.java.exam01;

import java.awt.Button;
import java.awt.Frame;

public class FrameEx {
	// 메인 메서드
	public static void main(String[] args) {
		Frame frame = new Frame();
		
		frame.setTitle("Test");
		Button bt1 = new Button("OK");	// OK라는 버튼을 생성 (bt1)
		frame.add(bt1);	// bt1을 화면에 추가
		Button bt2 = new Button("Cancle");
		frame.add(bt2);	// bt1을 추가한 후 bt2를 추가하면 bt1은 사라진다. (하나의 영역에는 하나의 컨포넌트만 넣을 수 있다)
		frame.setSize(300, 200);	// 가로세로 길이를 지정
		frame.setVisible(true);	// show()처럼 화면에 보여준다
	}
}