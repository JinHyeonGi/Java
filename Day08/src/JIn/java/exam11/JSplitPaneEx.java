package JIn.java.exam11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPaneEx extends JFrame {
	JSplitPane splitPane, splitPanel;

	public JSplitPaneEx() {
		super("SplitPaneEx 테스트");
		JTextArea jtal = new JTextArea("첫번째", 20, 10);
		JScrollPane jtalScrollPane = new JScrollPane(jtal);
		JTextArea jta2 = new JTextArea("두번째", 20, 10);
		JScrollPane jta2ScrollPane = new JScrollPane(jta2);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jtalScrollPane, jta2ScrollPane);
		JTextArea jta3 = new JTextArea("세번째", 20, 10);
		JScrollPane jta3ScrollPane = new JScrollPane(jta3);
		splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, jta3ScrollPane);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(100);
		splitPane.setPreferredSize(new Dimension(200, 200));
		splitPanel.setPreferredSize(new Dimension(400, 200));
		add(splitPanel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new JSplitPaneEx();
	}
}