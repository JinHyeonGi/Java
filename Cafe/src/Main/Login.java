/*	구현하지 못한 기능
 * 로그인을 성공했을 경우 MainView를 띄우는 기능 
 * 아이디가 여러개일 경우 여러 아이디 모두 로그인 가능하게 하는 기능 (지금은 하나만 가능)
 */
package Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Login extends Application {
	// DB에서 가져온 값을 저장할 변수
	static String one;
	static String two;
	// 화면 디자인
	Label label1 = new Label();
	Label label2 = new Label();
	TextField textField1 = new TextField();
	PasswordField textField2 = new PasswordField();
	Button btn = new Button("로그인");

	public static Connection connect() {	// 데이터베이스 연결
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			// 데이터베이스 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			pstmt = con.prepareStatement("select employee_id, password from cafe_employee");	// 쿼리문에 의해 발생된 결과의 값을 가져와 pstmt에 대입
			rs = pstmt.executeQuery();	// pstmt 객체값을 rs에 대입

			while (rs.next()) {	// rs의 다음값이 없을 때 까지 반복
				// 로그인 기능을 위해 값을 변수로 따로 지정해 저장
				String i = rs.getString(1);
				one = i;
				String j = rs.getString(2);
				two = j;
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
		return con;
	}

	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		// 창, 글씨, 버튼 등의 크기와 위치를 설정
		label1.setText("ID: ");
		label1.setLayoutX(10);
		label1.setLayoutY(15);

		label2.setText("PW: ");
		label2.setLayoutX(7);
		label2.setLayoutY(50);

		textField1.setPrefSize(175, 30);
		textField1.setLayoutX(30);
		textField1.setLayoutY(10);

		textField2.setPrefSize(175, 30);
		textField2.setLayoutX(30);
		textField2.setLayoutY(45);

		btn.setPrefSize(80, 65);
		btn.setLayoutX(215);
		btn.setLayoutY(10);

		// 화면에 라벨, 버튼, 텍스트필드 등을 표시
		pane.getChildren().addAll(label1, label2, btn, textField1, textField2);
		// 창 크기, 제목 설정 후 창을 띄운다
		Scene scene = new Scene(pane, 300, 90);
		stage.setScene(scene);
		stage.setTitle("로그인 화면");
		stage.show();

		btn.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				// 입력 칸이 빈칸 또는 ID와 PASSWORD가 DB와 다를 경우는 경고창을 띄우고 맞으면 창을 종료한 후 MainView 창을 띄운다
				if (textField1.getText().equals(one) && textField2.getText().equals(two)) { // ID와 PASSWORD가 일치할 경우
					// 창 종료
					Stage stage1 = (Stage) btn.getScene().getWindow();
					stage1.close();
				} else {	// ID와 PASSWORD가 일치하지 않을 경우
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("로그인 오류!");
					alert.setContentText("아이디와 비밀번호를 확인해주세요!");
					alert.showAndWait();
				}
			}
		});
	}

	public static void main(String[] args) {
		connect();
		Application.launch(Login.class);
	}
}