package JIn.java.exam10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class JTableEx extends JFrame implements CellEditorListener, TableColumnModelListener, TableModelListener {
	private JRootPane jrp;
	private Container con;
	private DefaultTableModel dtm = new DefaultTableModel(3, 4);
	private DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
	private DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
	private JTable jt = new JTable(dtm, dtcm, dlsm);
	private JScrollPane jsp = new JScrollPane(jt);
	private TableColumn tc, tc1, tc2, tc3;
	private DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	private DefaultCellEditor dee = new DefaultCellEditor(new JTextField());
	private JTableHeader jth = new JTableHeader(dtcm);

	public JTableEx() {
		super(" Test");
		setForm();
		setEvent();
		setSize(300, 200);
		setVisible(true);
	}

	public void setForm() {
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout(5, 5));
		con.add("North", new JLabel("JTable Event !!!", JLabel.CENTER));
		con.add("South", new JButton("확인"));
		tc = new TableColumn(0, 75);
		tc1 = new TableColumn(1, 75);
		tc2 = new TableColumn(2, 75);
		tc3 = new TableColumn(3, 75, dtcr, dee);
		tc.setHeaderValue("0 번");
		tc1.setHeaderValue(" 1 번");
		tc2.setHeaderValue("2번");
		tc3.setHeaderValue("3번");
		dtcm.addColumn(tc);
		dtcm.addColumn(tc1);
		dtcm.addColumn(tc2);
		dtcm.addColumn(tc3);
		jt.setTableHeader(jth);
		con.add("Center", jsp);
	}

	public void setEvent() {
		dee.addCellEditorListener(this);
		dtcm.addColumnModelListener(this);
		dtm.addTableModelListener(this);
	}

	public void editingCanceled(ChangeEvent e) {
	}

	public void editingStopped(ChangeEvent e) {
		System.out.println("수정이 완료 되었습니다.");
	}

	public void columnAdded(TableColumnModelEvent e) {
	}

	public void columnMoved(TableColumnModelEvent e) {
		System.out.println("움직 인 다.");
	}

	public void columnRemoved(TableColumnModelEvent e) {
	}

	public void columnMarginChanged(ChangeEvent e) {
		System.out.println("크기가 변형되었습니다.");
	}

	public void columnSelectionChanged(ListSelectionEvent e) {
		System.out.println(e.getFirstIndex() + "->" + e.getLastIndex());
	}

	public void tableChanged(TableModelEvent e) {
		System.out.println("변함 : " + e.getColumn() + "컬럼，" + e.getFirstRow() + "행");
	}

	public static void main(String[] ar) {
		new JTableEx();
	}
}
