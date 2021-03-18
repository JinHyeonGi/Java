package JIn.java.exam11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class JTreeEx extends JFrame implements TreeExpansionListener, TreeSelectionListener, TreeModelListener {
	private JRootPane jrp;
	private Container con;
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("ROOT");
	private DefaultTreeModel dtm = new DefaultTreeModel(root);
	private JTree jt = new JTree(dtm);
	private JScrollPane jsp = new JScrollPane(jt);
	private DefaultMutableTreeNode node = new DefaultMutableTreeNode("INode");
	private DefaultMutableTreeNode node_l = new DefaultMutableTreeNode("ROOT1");
	private DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode("ROOT2");
	private DefaultMutableTreeNode node_3 = new DefaultMutableTreeNode("GROOTS");
	private DefaultMutableTreeNode nodel = new DefaultMutableTreeNode("2Node");
	private DefaultMutableTreeNode nodel_l = new DefaultMutableTreeNode("ROOT 1");
	private DefaultMutableTreeNode nodel_2 = new DefaultMutableTreeNode("ROOT2");
	private DefaultMutableTreeNode nodel_3 = new DefaultMutableTreeNode("ROOT3");
	private DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("3Node");
	private DefaultMutableTreeNode node2_l = new DefaultMutableTreeNode("ROOT 1");
	private DefaultMutableTreeNode node2_2 = new DefaultMutableTreeNode("ROOT2");
	private DefaultMutableTreeNode node2_3 = new DefaultMutableTreeNode("ROOT3");

	public JTreeEx() {
		super("Test");
		setForm();
		setEvent();
		setSize(300, 200);
		setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		root.remove(node);
		dtm.reload();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ee) {
		}
		root.add(node);
		dtm.reload();
	}

	public void setForm() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", new JLabel("JTree Event !!!", JLabel.CENTER));
		con.add("South", new JButton("확인"));
		root.add(node);
		root.add(nodel);
		root.add(node2);
		node.add(node_l);
		node.add(node_2);
		node.add(node_3);
		nodel.add(nodel_l);
		nodel.add(nodel_2);
		nodel.add(nodel_3);
		node2.add(node2_2);
		node2.add(node2_l);
		node2.add(node2_3);
		jt.expandRow(0);
		jt.setEditable(true);
		con.add("Center", jsp);
	}

	public void setEvent() {
		jt.addTreeExpansionListener(this);
		jt.addTreeSelectionListener(this);
		dtm.addTreeModelListener(this);
	}

	public void treeCollapsed(TreeExpansionEvent e) {
		System.out.println("접혔다. : " + e.getPath());
	}

	public void treeExpanded(TreeExpansionEvent e) {
		System.out.println("열렸다. : " + e.getPath());
	}

	public void valueChanged(TreeSelectionEvent e) {
		System.out.println("위치가 변했다. : " + e.getPath());
	}

	public void treeNodesChanged(TreeModelEvent e) {
		System.out.println("노드의 글자가 바뀌었습니다.");
	}

	public void treeNodesInserted(TreeModelEvent e) {
	}

	public void treeNodesRemoved(TreeModelEvent e) {
	}

	public void treeStructureChanged(TreeModelEvent e) {
		System.out.println("트리의 구조가 바뀌었습니다.");
	}

	public static void main(String[] ar) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ee) {
		}
		new JTreeEx();
	}
}
