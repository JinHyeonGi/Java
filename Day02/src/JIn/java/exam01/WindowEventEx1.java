package JIn.java.exam01;
// java.awt를 전체 불러오면 폴더를 제외한 후 불러오기 때문에 하위 폴더는 또 불러야 함
import java.awt.*;
import java.awt.event.*;
/**
 * EventListener를 구현한 Class를 작성 후 생성시켜 연결하는 방식
 */
public class WindowEventEx1 {
	public static void main(String[] ar) {
		// 객체 생성
		Frame f = new Frame("첫번째");
		// Listener를 통해 MyEvent를 불러와서 기능을 구현
		f.addWindowListener(new MyEvent());
		
		f.setSize(300, 200);	// 창 크기 설정
		f.setVisible(true);	// 창 나타내기
	}
}