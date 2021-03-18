package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Vo.EmployeeVo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Employee extends Application {
	// 디자인
	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	Label label6 = new Label();
	TextField textField1 = new TextField();
	TextField textField2 = new TextField();
	TextField textField3 = new TextField();
	TextField textField4 = new TextField();
	TextField textField5 = new TextField();
	TextField textField6 = new TextField();
	Button btn1 = new Button("수정");
	Button btn2 = new Button("삭제");

	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();

		label1.setText("사원번호: ");
		label2.setText("이름: ");
		label3.setText("암호: ");
		label4.setText("E-MAIL: ");
		label5.setText("성별: ");
		label6.setText("전화번호: ");

		textField1.setPrefSize(200, 30);
		textField2.setPrefSize(200, 30);
		textField3.setPrefSize(200, 30);
		textField4.setPrefSize(200, 30);
		textField5.setPrefSize(200, 30);
		textField6.setPrefSize(200, 30);

		btn1.setPrefSize(50, 30);
		btn2.setPrefSize(50, 30);

		StringBuffer sql = new StringBuffer();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		// EmployeeVo값을 List로 담기 위해 선언
		List<EmployeeVo> employeeVoList = new ArrayList<EmployeeVo>();

		try { // 데이터베이스 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			// 검색 쿼리문
			pstmt = con.prepareStatement("select * from cafe_employee");
			// 결과를 rs에 담기
			rs = pstmt.executeQuery();
			// rs의 다음 값이 존재하지 않을 경우 중지
			while (rs.next()) {// EmployeeVo 형식의 변수를 선언하고 쿼리문 결과 값을 하나씩 EmployeeVo에 담는다
				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setEmployee_Id(rs.getString(1));
				employeeVo.setEmp_Name(rs.getString(2));
				employeeVo.setPassword(rs.getString(3));
				employeeVo.setE_mail(rs.getString(4));
				employeeVo.setGender(rs.getString(5));
				employeeVo.setPhone_number(rs.getString(6));
				employeeVoList.add(employeeVo);
			}
			// 예외 처리
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		BorderPane root = new BorderPane();
		// 새로운 TableView 하나를 만든다
		TableView tableView = new TableView();
		root.setCenter(tableView);
		// 테이블 (컬럼명, 형식) 설정
		TableColumn<EmployeeVo, String> tc1 = new TableColumn<EmployeeVo, String>("사원번호");
		TableColumn<EmployeeVo, String> tc2 = new TableColumn<EmployeeVo, String>("이름");
		TableColumn<EmployeeVo, String> tc3 = new TableColumn<EmployeeVo, String>("비밀번호");
		TableColumn<EmployeeVo, String> tc4 = new TableColumn<EmployeeVo, String>("이메일");
		TableColumn<EmployeeVo, String> tc5 = new TableColumn<EmployeeVo, String>("성");
		TableColumn<EmployeeVo, Integer> tc6 = new TableColumn<EmployeeVo, Integer>("전화번호");
		tc1.setCellValueFactory(new PropertyValueFactory<EmployeeVo, String>("employee_Id"));
		tc2.setCellValueFactory(new PropertyValueFactory<EmployeeVo, String>("emp_Name"));
		tc3.setCellValueFactory(new PropertyValueFactory<EmployeeVo, String>("Password"));
		tc4.setCellValueFactory(new PropertyValueFactory<EmployeeVo, String>("E_mail"));
		tc5.setCellValueFactory(new PropertyValueFactory<EmployeeVo, String>("Gender"));
		tc6.setCellValueFactory(new PropertyValueFactory<EmployeeVo, Integer>("Phone_number"));
		tableView.getColumns().setAll(tc1, tc2, tc3, tc4, tc5, tc6);
		ObservableList list = FXCollections.observableArrayList(employeeVoList);
		tableView.setItems(list);

		// 화면에 배치
		grid.add(label1, 0, 0);
		grid.add(label2, 0, 1);
		grid.add(label3, 0, 2);
		grid.add(label4, 0, 3);
		grid.add(label5, 0, 4);
		grid.add(label6, 0, 5);
		grid.add(textField1, 1, 0);
		grid.add(textField2, 1, 1);
		grid.add(textField3, 1, 2);
		grid.add(textField4, 1, 3);
		grid.add(textField5, 1, 4);
		grid.add(textField6, 1, 5);
		grid.add(btn1, 0, 6);
		grid.add(btn2, 1, 6);
		grid.add(tableView, 2, 0, 1, 7);
		// 중앙 정렬
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		// 창 크기, 이름 지정
		Scene scene = new Scene(grid, 850, 300);
		stage.setScene(scene);
		stage.setTitle("직원정보 화면");
		stage.show();

		tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// tableView에 있는 값이 원래 EmployeeVo 형식이기 때문에 EmployeeVo 형식을 가진 employeeVo 변수를 선언해
				// tableView값을 대입
				EmployeeVo employeeVo = (EmployeeVo) tableView.getSelectionModel().getSelectedItem();
				textField1.setText(employeeVo.getEmployee_Id());
				textField2.setText(employeeVo.getEmp_Name());
				textField3.setText(employeeVo.getPassword());
				textField4.setText(employeeVo.getE_mail());
				textField5.setText(employeeVo.getGender());
				textField6.setText(employeeVo.getPhone_number());
			}
		});
		btn1.setOnAction(new EventHandler<ActionEvent>() { // 수정 버튼을 눌렀을 경우 발생되는 이벤트
			public void handle(ActionEvent event) {
				if (textField1.getText().equals("") || textField2.getText().equals("")
						|| textField3.getText().equals("") || textField4.getText().equals("")) { // 빈 칸이 하나라도 있을 경우
					// 아래 내용의 경고창을 띄움
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("직원정보 수정 오류!");
					alert.setContentText("직원정보를 확인해주세요!");
					alert.showAndWait();
				} else { // 칸이 빈 칸이 없다면
					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					try {
						// 데이터베이스 연결
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest",
								"mytest");
						// 수정 쿼리문
						pstmt = con.prepareStatement(
								"update cafe_employee set employee_id = ?, emp_name = ?, password = ?, e_mail = ?, gender = ?, phone_number = ? where employee_id = ?");
						// 각 텍스트필드에 작성된 값을 가져와서 쿼리문 ? 부분을 채움
						pstmt.setString(1, textField1.getText());
						pstmt.setString(2, textField2.getText());
						pstmt.setString(3, textField3.getText());
						pstmt.setString(4, textField4.getText());
						pstmt.setString(5, textField5.getText());
						pstmt.setString(6, textField6.getText());
						pstmt.setString(7, textField1.getText());
						rs = pstmt.executeQuery();
						tableView.refresh();
						// 정보 수정이 완료되었다는 알림창을 띄움
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText("직원정보 수정 완료!");
						alert.setContentText("직원정보 수정이 완료되었습니다!");
						alert.showAndWait();
						// 예외 처리
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
						// 상황에 관계 없이 무조건 실행됨
					} finally {
						try {
							if (rs != null)
								rs.close();
						} catch (SQLException e) {
						}
						try {
							if (stmt != null)
								stmt.close();
						} catch (SQLException e) {
						}
						try {
							if (con != null)
								con.close();
						} catch (SQLException e) {
						}
					}
				}
			}
		});

		btn2.setOnAction(new EventHandler<ActionEvent>() { // 삭제 버튼을 눌렀을 경우 발생되는 이벤트
			public void handle(ActionEvent event) {
				if (textField1.getText().equals("") || textField2.getText().equals("")
						|| textField3.getText().equals("") || textField4.getText().equals("")) { // 빈 칸이 있을 경우
					// 경고창 띄우기
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("직원정보 삭제 오류!");
					alert.setContentText("직원정보를 확인해주세요!");
					alert.showAndWait();
				} else { // 빈 칸이 없을 경우
					StringBuffer sql = new StringBuffer();
					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					try { // 데이터베이스 연결
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest",
								"mytest");
						// 삭제 쿼리문
						pstmt = con.prepareStatement("delete from cafe_employee where employee_id = ?");
						pstmt.setString(1, textField1.getText());
						rs = pstmt.executeQuery();
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText("직원정보 삭제 완료!");
						alert.setContentText("직원정보 삭제가 완료되었습니다!");
						alert.showAndWait();
						// 예외 처리
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
						// 상황에 관계 없이 무조건 실행됨
					} finally {
						try {
							if (rs != null)
								rs.close();
						} catch (SQLException e) {
						}
						try {
							if (stmt != null)
								stmt.close();
						} catch (SQLException e) {
						}
						try {
							if (con != null)
								con.close();
						} catch (SQLException e) {
						}
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		Application.launch(Employee.class);
	}
}
