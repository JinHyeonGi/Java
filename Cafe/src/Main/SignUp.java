/*	구현하지 못한 기능
 * 회원가입 아이디 중복확인 기능
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUp extends Application {
	static String one;
	static String two;
	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	Label label6 = new Label();
	TextField textField1 = new TextField();
	TextField textField2 = new TextField();
	PasswordField textField3 = new PasswordField();
	TextField textField4 = new TextField();
	TextField textField5 = new TextField();
	TextField textField6 = new TextField();
	Button btn1 = new Button("가입");
	Button btn2 = new Button("취소");

	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();

		label1.setText("사원번호: ");
		label1.setLayoutX(12);
		label1.setLayoutY(15);

		label2.setText("이름: ");
		label2.setLayoutX(12);
		label2.setLayoutY(55);

		label3.setText("암호: ");
		label3.setLayoutX(12);
		label3.setLayoutY(100);

		label4.setText("E-MAIL: ");
		label4.setLayoutX(12);
		label4.setLayoutY(140);

		label5.setText("성별: ");
		label5.setLayoutX(12);
		label5.setLayoutY(180);

		label6.setText("전화번호: ");
		label6.setLayoutX(12);
		label6.setLayoutY(220);

		textField1.setPrefSize(200, 30);
		textField1.setLayoutX(65);
		textField1.setLayoutY(10);

		textField2.setPrefSize(200, 30);
		textField2.setLayoutX(65);
		textField2.setLayoutY(50);

		textField3.setPrefSize(200, 30);
		textField3.setLayoutX(65);
		textField3.setLayoutY(95);

		textField4.setPrefSize(200, 30);
		textField4.setLayoutX(65);
		textField4.setLayoutY(135);

		textField5.setPrefSize(200, 30);
		textField5.setLayoutX(65);
		textField5.setLayoutY(175);

		textField6.setPrefSize(200, 30);
		textField6.setLayoutX(65);
		textField6.setLayoutY(215);

		btn1.setPrefSize(50, 30);
		btn1.setLayoutX(70);
		btn1.setLayoutY(255);

		btn2.setPrefSize(50, 30);
		btn2.setLayoutX(150);
		btn2.setLayoutY(255);

		pane.getChildren().addAll(label1, label2, label3, label4, label5, label6, btn1, btn2, textField1, textField2,
				textField3, textField4, textField5, textField6);

		Scene scene = new Scene(pane, 270, 300);
		stage.setScene(scene);
		stage.setTitle("회원가입 화면");
		stage.show();

		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (textField1.getText().equals("") || textField2.getText().equals("")
						|| textField3.getText().equals("") || textField4.getText().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("회원가입 오류!");
					alert.setContentText("입력 내용을 확인해주세요!");
					alert.showAndWait();
				} else {
					Connection con = null;
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest",
								"mytest");
						pstmt = con.prepareStatement("insert into cafe_employee values(?, ?, ?, ?, ?, ?)");
						pstmt.setString(1, textField1.getText());
						pstmt.setString(2, textField2.getText());
						pstmt.setString(3, textField3.getText());
						pstmt.setString(4, textField4.getText());
						pstmt.setString(5, textField5.getText());
						pstmt.setString(6, textField6.getText());
						rs = pstmt.executeQuery();
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText("회원가입 완료!");
						alert.setContentText("회원가입이 성공하였습니다!");
						alert.showAndWait();
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
					Stage stage1 = (Stage) btn1.getScene().getWindow();
					stage1.close();
				}
			}
		});

		btn2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage stage1 = (Stage) btn2.getScene().getWindow();
				stage1.close();
			}
		});
	}

	public static void main(String[] args) {
		Application.launch(SignUp.class);
	}
}