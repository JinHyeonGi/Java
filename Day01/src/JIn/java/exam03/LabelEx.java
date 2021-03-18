package JIn.java.exam03;

import java.awt.*;

public class LabelEx extends Frame {

	private static final long serialVersionUID = 1L;
	Label la1;
	Label la2;
	Label la3;
	Label la4;
	Font f1;
	Font f2;

	LabelEx() {
		super("Label Exam");	// 창 제목 설정
		f1 = new Font("굴림체", Font.BOLD, 20);	// f1에 폰트 설정 저장
		f2 = new Font("바탕체", Font.ITALIC, 25);
		la1 = new Label("안녕하세요!");	// la1에 입력된 글자 저장
		la2 = new Label("이승재 입니다.", Label.CENTER);
		la3 = new Label("Teacher지요!", Label.RIGHT);
		la4 = new Label("방가방가!!!");
		setLayout(new GridLayout(4, 1));	// 행과 열의 숫자 결정함
		la1.setFont(f1);	// 폰트 적용
		la2.setFont(f1);
		la3.setFont(f2);
		la4.setFont(f2);
		add(la1);	// 화면에 표시
		add(la2);
		add(la3);
		add(la4);
		la1.setBackground(Color.red);	// 배경색 설정
		la2.setBackground(Color.blue);
		la3.setBackground(Color.green);
		la4.setBackground(Color.pink);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] ar) {
		LabelEx Is = new LabelEx();
	}
}
