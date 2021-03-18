package JIn.java.exam06;

import javax.swing.*;
import java.util.Vector;

public class JTreeEx extends JFrame {
	Object[] gen = { "프로그램", "System", "Design" };
	Vector<Vector> nodel = new Vector<Vector>() {
		public String toString() {
			return "Lesson";
		}
	};
	Vector<String> node2 = new Vector<String>() {
		public String toString() {
			return "Java";
		}
	};
	Vector<String> node3 = new Vector<String>() {
		public String toString() {
			return "XML";
		}
	};

	public JTreeEx() {
		nodel.addElement(node2);
		nodel.addElement(node3);
		node2.addElement("Beg");
		node2.addElement("Adv");
		node2.addElement("JSP");
		node3.addElement("XSLT");
		node3.addElement("DOM");
		gen[0] = nodel;
		// 트리구조에 상위인"gen” 추가
		JTree tree = new JTree(gen);
		tree.setRootVisible(true); // 루트 설정
		JScrollPane js = new JScrollPane(tree);
		add(js);
		setBounds(300, 150, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
	}

	public static void main(String[] args) {
		new JTreeEx();
	}
}
