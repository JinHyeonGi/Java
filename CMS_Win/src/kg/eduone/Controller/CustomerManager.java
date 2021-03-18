package kg.eduone.Controller;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import kg.eduone.vo.Customer;

public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener {

	/* 멤버필드 */
	private static final long serialVersionUID = 1L;
	// 이름
	private TextField nametf = new TextField(20);
	// 주민번호
	private TextField jumin1tf = new TextField(7);
	private TextField jumin2tf = new TextField(8);
	// 전화번호
	private Choice telch = new Choice();
	private String[] tstr = { "010", "011", "016", "017", "018", "019" };
	private TextField tel1tf = new TextField(4);
	private TextField tel2tf = new TextField(4);
	// 성별
	private CheckboxGroup cg = new CheckboxGroup();
	private Checkbox man = new Checkbox("남성", cg, true);
	private Checkbox woman = new Checkbox("여성", false, cg);
	// 취미
	private String[] hstr = { "독서", "영화", "음악", "게임", "쇼핑" };
	private Checkbox[] hobby = new Checkbox[hstr.length];
	// 버튼 설정
	private Button addbt = new Button("등록");
	private Button dispbt = new Button("분석");
	private Button updatebt = new Button("수정");
	private Button delbt = new Button("삭제");
	private Button initbt = new Button("입력모드");
	// 전체 목록
	private List listli = new List();
	// 개인 정보 분석 결과 및 정보
	private TextArea infota = new TextArea();
	// 메뉴 설정
	private MenuBar mb = new MenuBar();
	private Menu mfile = new Menu("File");
	private MenuItem mfnew = new MenuItem("새파일");
	private MenuItem mfopen = new MenuItem("불러오기");
	private MenuItem mfsave = new MenuItem("저장하기");
	private MenuItem mfsaveas = new MenuItem("새이름으로저장하기");
	private MenuItem mfexit = new MenuItem("종료");
	private Menu mhelp = new Menu("Help");
	private MenuItem mhver = new MenuItem("버전정보");
	// 다이알로그
	private Dialog dialog = new Dialog(this, "버전정보", true);
	private Label dlabel = new Label("CustomerManager V1.0", Label.CENTER);
	private Button dbt = new Button("확인");
	// 구성요소
	private ArrayList<Customer> data = new ArrayList<Customer>();
	private File myfile = null;
	private FileDialog fildDialog = null;

	/* 생성자 */
	public CustomerManager() {
		super("고객관리프로그램");
		setMenu();
		setDialog();
		setEvent();
		buildGUI();
	}

	/* 메서드 */
	// 버튼 활성화 설정
	private void setButton(boolean state) {
		addbt.setEnabled(state);
		dispbt.setEnabled(!state);
		updatebt.setEnabled(!state);
		delbt.setEnabled(!state);
		initbt.setEnabled(!state);
	}

	// 화면 초기화 설정
	public void clrscr() {
		nametf.setText("");
		jumin1tf.setText("");
		jumin2tf.setText("");
		telch.select(0);
		tel1tf.setText("");
		tel2tf.setText("");
		man.setState(true);
		for (int i = 0; i < hobby.length; i++)
			hobby[i].setState(false);
		infota.setText("");
		nametf.requestFocus();
	}

	// 입력칸 활성화 설정
	public void setForm(boolean state) {
		nametf.setEditable(state);
		jumin1tf.setEditable(state);
		jumin2tf.setEditable(state);
		man.setEnabled(state);
		woman.setEnabled(state);
	}

	// Event 설정
	public void setEvent() {
		mfsaveas.addActionListener(this);
		mfsave.addActionListener(this);
		mfopen.addActionListener(this);
		mfnew.addActionListener(this);
		dbt.addActionListener(this);
		mfexit.addActionListener(this);
		mhver.addActionListener(this);
		initbt.addActionListener(this);
		delbt.addActionListener(this);
		updatebt.addActionListener(this);
		dispbt.addActionListener(this);
		listli.addItemListener(this);
		addbt.addActionListener(this);
		tel1tf.addActionListener(this);
		telch.addItemListener(this);
		jumin2tf.addKeyListener(this);
		jumin1tf.addKeyListener(this);
		nametf.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// Action 설정
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nametf) { // 엔터를 누르면 포커스를 jumin1tf로 이동
			jumin1tf.requestFocus();
			return;
		}
		if (e.getSource() == tel1tf) { // 값을 하나 선택하면 tel2tf로 이동
			tel2tf.requestFocus();
			return;
		}
		if (e.getSource() == addbt) { // 등록 버튼을 누를 경우에
			// Action.이름 입력 설정
			String name = nametf.getText().trim(); // 입력 칸에 값에서 좌우 공백값을 제거한 값을 name에 입력
			if (name == null || name.length() == 0) { // 칸이 빈칸일 경우
				infota.setText("\n\t이름은 반드시 입력하셔야 합니다.");
				nametf.setText("");
				nametf.requestFocus();
				return;
			}
			// Action.주민번호 입력 설정
			StringBuffer jumin = new StringBuffer(jumin1tf.getText());
			jumin.append("-");
			jumin.append(jumin2tf.getText());
			if (jumin1tf.getText().trim().length() != 6 || jumin2tf.getText().trim().length() != 7) {
				infota.setText("\n\t주민번호는 앞 6자리 뒷 7자리로 구성됩니다.");
				jumin1tf.setText("");
				jumin2tf.setText("");
				jumin1tf.requestFocus();
				return;
			}
			// Action.전화번호 입력 설정
			StringBuffer tel = new StringBuffer(telch.getSelectedItem());
			tel.append("-");
			tel.append(tel1tf.getText());
			tel.append("-");
			tel.append(tel2tf.getText());
			if (tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) {
				infota.setText("\n\t전화번호는 반드시 입력 하셔야 합니다.");
				tel1tf.setText("");
				tel2tf.setText("");
				tel1tf.requestFocus();
				return;
			}
			// Action.성별 설정
			boolean gender = man.getState();
			// Action.취미 설정
			StringBuffer myHobby = new StringBuffer();
			for (int i = 0; i < hobby.length; i++) {
				if (hobby[i].getState()) {
					myHobby.append(hobby[i].getLabel());
					myHobby.append("-");
				}
			}
			if (myHobby.length() == 0) { // 하나도 취미를 체크하지 않았을 경우
				myHobby.append("없음");
			} else {
				// myHobby.delete(myHobby.length()-1, myHobby.length());
				myHobby.deleteCharAt(myHobby.length() - 1);
			}

			Customer myCustomer = new Customer(name, jumin.toString(), tel.toString(), gender, myHobby.toString());

			infota.setText("\n\t성공적으로 등록 되었습니다.");
			data.add(myCustomer);
			listli.add(myCustomer.toString());

			try { // 프로그램을 0.5초간 멈춤
				Thread.sleep(500);
			} catch (InterruptedException ir) {
			}

			clrscr();
		}
		// 분석 버튼 설정
		if (e.getSource() == dispbt) {
			// 주민번호 검증을 수행해서 infota에다가 정보를 출력해 줍니다.
		}
		// 수정 버튼 설정
		if (e.getSource() == updatebt) {

			Customer myCustomer = data.get(listli.getSelectedIndex());
			// 수정.전화번호 설정
			StringBuffer tel = new StringBuffer(telch.getSelectedItem());
			tel.append("-");
			tel.append(tel1tf.getText());
			tel.append("-");
			tel.append(tel2tf.getText());
			if (tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) { // 전화번호칸이 비어있을 경우
				infota.setText("\n\t전화번호는 반드시 입력 하셔야 합니다.");
				tel1tf.setText("");
				tel2tf.setText("");
				tel1tf.requestFocus();
				return;
			}
			// 수정.취미 설정
			StringBuffer myHobby = new StringBuffer();
			for (int i = 0; i < hobby.length; i++) {
				if (hobby[i].getState()) {
					myHobby.append(hobby[i].getLabel());
					myHobby.append("-");
				}
			}
			if (myHobby.length() == 0) {// 하나도 취미를 체크하지 않았다.
				myHobby.append("없음");
			} else {// 하나이상 체크했다.
				// myHobby.delete(myHobby.length()-1, myHobby.length());
				myHobby.deleteCharAt(myHobby.length() - 1);
			}

			infota.setText("\n\t성공적으로 수정되었습니다.");
			myCustomer.setTel(tel.toString());
			myCustomer.setHobby(myHobby.toString());

			try {
				Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
			} catch (InterruptedException ir) {
			}

			setButton(true);
			setForm(true);
			clrscr();
			return;
		}
		// 삭제 버튼 설정
		if (e.getSource() == delbt) {
			int index = listli.getSelectedIndex();

			infota.setText("\n\t성공적으로 삭제 되었습니다.");

			listli.remove(index);
			data.remove(index);

			try { // 프로그램을 0.5간 멈춘다
				Thread.sleep(500);
			} catch (InterruptedException ir) {
			}

			setForm(true);
			setButton(true);
			clrscr();
			return;
		}
		// 입력모드 버튼
		if (e.getSource() == initbt) {
			setForm(true);
			setButton(true);
			clrscr();
			return;
		}
		// 메뉴.버전정보 설정
		if (e.getSource() == mhver) {
			Point pt = getLocation();
			Dimension my = getSize();
			Dimension dsize = dialog.getSize();

			dialog.setLocation((int) pt.getX() + my.width / 2 - dsize.width / 2,
					(int) pt.getY() + my.height / 2 - dsize.height / 2);
			dialog.setVisible(true);
		}
		// 메뉴.종료 설정
		if (e.getSource() == mfexit) {
			System.exit(0);
		}
		// 메뉴.버전정보.확인 버튼 설정
		if (e.getSource() == dbt) {
			dialog.setVisible(false);
		}
		// 메뉴.새파일 설정
		if (e.getSource() == mfnew) {
			listli.removeAll();
			data.clear();
			myfile = null;
			setButton(true);
			setForm(true);
			clrscr();
		}
		// 메뉴.불러오기 설정
		if (e.getSource() == mfopen) {
			fildDialog = new FileDialog(this, "불러오기", FileDialog.LOAD);
			fildDialog.setVisible(true);
			String fileName = fildDialog.getFile();
			String directory = fildDialog.getDirectory();
			if (fileName == null || directory == null) {
				return;
			}
			myfile = new File(directory, fileName);
			// dataLoad();
			loadData();
		}
		// 메뉴.저장하기 설정
		if (e.getSource() == mfsave) {
			if (myfile == null) {
				fildDialog = new FileDialog(this, "새 이름으로 저장하기", FileDialog.SAVE);
				fildDialog.setVisible(true);
				String fileName = fildDialog.getFile();
				String directory = fildDialog.getDirectory();
				if (fileName == null || directory == null) {
					return;
				}
				myfile = new File(directory, fileName);
			}
			// dataSave();
			saveData();
		}
		// 메뉴.새이름으로 저장하기 설정
		if (e.getSource() == mfsaveas) {
			fildDialog = new FileDialog(this, "새 이름으로 저장하기", FileDialog.SAVE);
			fildDialog.setVisible(true);
			String fileName = fildDialog.getFile();
			String directory = fildDialog.getDirectory();
			if (fileName == null || directory == null) {
				return;
			}
			myfile = new File(directory, fileName);
			// dataSave();
			saveData();
		}
	}

	// 불러오기 메서드 (객체 역직렬화)
	public void loadData() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		listli.removeAll();
		data.clear();

		try {
			fis = new FileInputStream(myfile);
			ois = new ObjectInputStream(fis);

			Customer myCustomer = null;
			while ((myCustomer = (Customer) ois.readObject()) != null) {
				listli.add(myCustomer.toString());
				data.add(myCustomer);
			}
		} catch (EOFException eofe) {
			infota.setText("\n\t성공적으로 데이터를 로딩하였습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.err.println("Customer 클래스를 찾을 수 없습니다.");
		} catch (FileNotFoundException fnfe) {
			System.err.println(myfile.getName() + " 파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException ioe) {
			}
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ioe) {
			}
		}

		try { // 프로그램을 0.5간 멈춘다
			Thread.sleep(500);
		} catch (InterruptedException ir) {
		}

		setButton(true);
		setForm(true);
		clrscr();
	}

	// 저장 메서드 (객체 직렬화)
	public void saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(myfile);
			oos = new ObjectOutputStream(fos);

			for (int i = 0; i < data.size(); i++) {
				Customer myCustomer = data.get(i);
				oos.writeObject(myCustomer);
			}
			infota.setText("\n\t성공적으로 저장되었습니다");
		} catch (FileNotFoundException fnfe) {
			System.err.println(myfile.getName() + " 파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException ioe) {
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException ioe) {
			}
		}

		try { // 프로그램을 0.5간 멈춘다
			Thread.sleep(500);
		} catch (InterruptedException ir) {
		}

		setButton(true);
		setForm(true);
		clrscr();
	}

	// 불러오기 메서드
	public void dataLoad() {
		FileReader fr = null;
		BufferedReader br = null;

		listli.removeAll();
		data.clear();

		try {
			fr = new FileReader(myfile);
			br = new BufferedReader(fr);

			String readData = "";
			while ((readData = br.readLine()) != null) {
				String[] mydata = readData.split("/");
				boolean gender = false;
				if (mydata[3].equals("남성"))
					gender = true;
				Customer myCustomer = new Customer(mydata[0], mydata[1], mydata[2], gender, mydata[4]);
				listli.add(myCustomer.toString());
				data.add(myCustomer);
			}
			infota.setText("\n\t성공적으로 데이터를 로딩하였습니다.");
		} catch (FileNotFoundException fnfe) {
			System.err.println(myfile.getName() + " 파일을 찾을 수 없습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
			}
			try {
				if (fr != null)
					fr.close();
			} catch (IOException ioe) {
			}
		}

		try { // 프로그램을 0.5간 멈춘다
			Thread.sleep(500);
		} catch (InterruptedException ir) {
		}

		setForm(true);
		setButton(true);
		clrscr();
	}

	// 저장 메서드
	public void dataSave() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(myfile);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);

			for (int i = 0; i < data.size(); i++) {
				Customer myCustomer = data.get(i);
				StringBuffer sb = new StringBuffer(myCustomer.getName());
				sb.append("/");
				sb.append(myCustomer.getJumin());
				sb.append("/");
				sb.append(myCustomer.getTel());
				sb.append("/");
				sb.append(myCustomer.isGender() ? "남성" : "여성");
				sb.append("/");
				sb.append(myCustomer.getHobby());
				pw.println(sb.toString());
			}
			infota.setText("\n\t성공적으로 저장되었습니다");
		} catch (FileNotFoundException fnfe) {
			System.err.println(myfile.getName() + " 파일을 찾을 수 없습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ioe) {
			}
			try {
				if (fw != null)
					fw.close();
			} catch (IOException ioe) {
			}
		}

		try { // 프로그램을 0.5간 멈춘다
			Thread.sleep(500);
		} catch (InterruptedException ir) {
		}

		setButton(true);
		setForm(true);
		clrscr();
	}

	// 등록된 회원을 클릭 한 경우
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == telch) {
			tel1tf.requestFocus();
			return;
		}
		if (e.getSource() == listli) {
			int index = listli.getSelectedIndex();

			Customer myCustomer = data.get(index);

			nametf.setText(myCustomer.getName());
			jumin1tf.setText(myCustomer.getJumin().split("-")[0]);
			jumin2tf.setText(myCustomer.getJumin().split("-")[1]);
			telch.select(myCustomer.getTel().split("-")[0]);
			tel1tf.setText(myCustomer.getTel().split("-")[1]);
			tel2tf.setText(myCustomer.getTel().split("-")[2]);
			man.setState(myCustomer.isGender());
			woman.setState(!myCustomer.isGender());

			for (int i = 0; i < hobby.length; i++)
				hobby[i].setState(false);

			String[] myHobby = myCustomer.getHobby().split("-");
			for (int i = 0; i < myHobby.length; i++) {
				for (int j = 0; j < hobby.length; j++) {
					if (myHobby[i].equals(hobby[j].getLabel())) {
						hobby[j].setState(true);
						break;
					}
				}
			}

			setForm(false);
			setButton(false);
			telch.requestFocus();
		}
	}

	// 키보드 Event 설정
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == jumin1tf) {
			if (jumin1tf.getText().trim().length() == 6) {
				jumin2tf.requestFocus();
				return;
			}
		}
		if (e.getSource() == jumin2tf) {
			if (jumin2tf.getText().trim().length() == 7) {
				telch.requestFocus();
				return;
			}
		}
	}

	// 메뉴.버전정보 설정
	private void setDialog() {
		dialog.setLayout(new BorderLayout(3, 3));
		dlabel.setFont(new Font("Serif", Font.BOLD, 15));
		dialog.add("Center", dlabel);
		dialog.add("South", dbt);
		dialog.setSize(200, 150);
	}

	// 메뉴 구성
	private void setMenu() {
		setMenuBar(mb);

		mb.add(mfile);
		mfile.add(mfnew);
		mfile.addSeparator();
		mfile.add(mfopen);
		mfile.add(mfsave);
		mfile.add(mfsaveas);
		mfile.addSeparator();
		mfile.add(mfexit);

		mb.add(mhelp);
		mhelp.add(mhver);
	}

	// 화면 구성
	private void buildGUI() {
		setBackground(Color.CYAN);
		// 동 서 남 북 Label 생성
		add("North", new Label());
		add("South", new Label());
		add("West", new Label());
		add("East", new Label());
		// Panel 하나를 불러와 mainPanel이라는 이름으로 지정 (크기 5, 5)
		/* mainPanel 화면 설정 */
		Panel mainPanel = new Panel(new BorderLayout(5, 5));
		/* mainPanel.centerPanel 화면 설정 */
		Panel centerPanel = new Panel(new BorderLayout(5, 5));
		// mainPanel.centerpanel.North쪽에 화면 설정
		centerPanel.add("North", new Label("고 객 정 보 등 록", Label.CENTER));
		// mainPanel.centerpanel.West쪽에 화면 설정
		Panel cwPanel = new Panel(new GridLayout(5, 1, 5, 5));
		cwPanel.add(new Label("이름: ", Label.RIGHT));
		cwPanel.add(new Label("주민번호: ", Label.RIGHT));
		cwPanel.add(new Label("전화번호: ", Label.RIGHT));
		cwPanel.add(new Label("성      별: ", Label.RIGHT));
		cwPanel.add(new Label("취      미: ", Label.RIGHT));
		centerPanel.add("West", cwPanel);
		// mainPanel.centerpanel.East쪽에 화면 설정
		centerPanel.add("East", new Label());
		// mainPanel.centerpanel.SouthWest쪽에 화면 설정
		Panel csPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
		csPanel.add(addbt);
		csPanel.add(dispbt);
		csPanel.add(updatebt);
		csPanel.add(delbt);
		csPanel.add(initbt);
		centerPanel.add("South", csPanel);
		// mainPanel.centerpanelCenter쪽에 화면 설정
		Panel ccPanel = new Panel(new GridLayout(5, 1, 5, 5));
		Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p1.add(nametf);
		ccPanel.add(p1);

		Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p2.add(jumin1tf);
		p2.add(new Label("-", Label.CENTER));
		p2.add(jumin2tf);
		ccPanel.add(p2);

		Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
		for (int i = 0; i < tstr.length; i++)
			telch.add(tstr[i]);
		p3.add(telch);
		p3.add(new Label("-", Label.CENTER));
		p3.add(tel1tf);
		p3.add(new Label("-", Label.CENTER));
		p3.add(tel2tf);
		ccPanel.add(p3);

		Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
		p4.add(man);
		p4.add(woman);
		ccPanel.add(p4);

		Panel p5 = new Panel(new FlowLayout(FlowLayout.LEFT));
		for (int i = 0; i < hstr.length; i++) {
			hobby[i] = new Checkbox(hstr[i]);
			p5.add(hobby[i]);
		}
		ccPanel.add(p5);
		centerPanel.add("Center", ccPanel);
		mainPanel.add("Center", centerPanel);
		/* mainPanel.eastPanel 화면 설정 */
		Panel eastPanel = new Panel(new BorderLayout(5, 5));
		eastPanel.add("North", new Label("전체목록", Label.CENTER));
		eastPanel.add("Center", listli);
		mainPanel.add("East", eastPanel);
		/* mainPanel.southPanel 화면 설정 */
		Panel southPanel = new Panel(new BorderLayout(5, 5));
		southPanel.add("North", new Label("개 인 정 보 분 석 결 과 및 정 보", Label.CENTER));
		southPanel.add("Center", infota);
		mainPanel.add("South", southPanel);
		add("Center", mainPanel);

		pack();

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension my = getSize();
		setLocation(scr.width / 2 - my.width / 2, scr.height / 2 - my.height / 2);

		setForm(true);
		setButton(true);
		nametf.requestFocus();

		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerManager();
	}
}