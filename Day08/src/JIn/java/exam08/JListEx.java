package JIn.java.exam08;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JListEx extends JFrame {

	private static final long serialVersionUID = 1L;

	public JListEx() {
		super("JList Test");
		setLayout(new FlowLayout());
		String[] listData = { "Lee", "Seung", "Jae", "Java", "JSP" };
		JList list1 = new JList(listData);
		list1.setSelectedIndex(1);
		JList list2 = new JList(new DefaultListModel());
		DefaultListModel model = (DefaultListModel) list2.getModel();
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(1);
		Vector vListData = new Vector();
		JList list3 = new JList(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
		class Student {
			String id;
			String name;
			String department;

			public Student(String id, String name, String department) {
				this.id = id;
				this.name = name;
				this.department = department;
			}

			public String toString() {
				return name;
			}
		}
		JList list4 = new JList(new DefaultListModel());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = (DefaultListModel) list4.getModel();
		model.addElement(new Student("100", "홍길동", "전산과"));
		model.addElement(new Student("200", "손오공", "건축과"));
		model.addElement(new Student("300", "사오전", "토목과"));
		model.addElement(new Student("400", "저팔계", "경영학"));
		list4.setSelectedIndex(1);
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		setBounds(300, 200, 300, 200);
		setVisible(true);
	}

	public static void main(String[] ar) {
		new JListEx();
	}
}
