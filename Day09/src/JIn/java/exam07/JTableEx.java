package JIn.java.exam07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel {// java.swing의추상클래스
	Object[][] data = { { "Nari", "마루치", new Integer(1234), "옆집친구" }, { "One", "오윤아", new Integer(1111), "예쁜이" },
			{ "two", "오윤서", new Integer(2222), "귀염둥이" }, { "three", "아라치", new Integer(3333), "동아리친구" } };
	String[] name = { "아이디", "이름", "비밀번호", "구분" }; // 필드명 들

	public int getColumnCount() { // 테이블의 열의 수[필수]
		return name.length; // return 4； 와 동일
	}

	public int getRowCount() { // 테이블의 행의 수[필수]
		return data.length;
	}

	public Object getValueAt(int r, int c) { // 실제 데이터 추출[필수]
		return data[r][c];
	}

	public boolean isCellEditable(int r, int c) { // 편집가능하게 한다.
		return (c != 0) ? true : false;
	}

	public String getColumnName(int c) { // 테이블의 타이들명 부여
		return name[c];
	}

	public void setValueAt(Object obj, int r, int c) { // 필드값 변경
		data[r][c] = obj;
	}
}

public class JTableEx extends JFrame {
	JTable table;
	JTableModel model; // 사용자 모델정의 클래스

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table)); // 스크롤바 생성하면서
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableEx();
	}

}