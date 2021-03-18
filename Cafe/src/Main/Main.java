package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application{
	// 화면 디자인
	Label label1 = new Label();
	Button btn1 = new Button("회원가입");
	Button btn2 = new Button("로그인");
	
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		// 내용, 위치, 폰트 설정
		label1.setText("Cafeteria");
		label1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
		label1.setLayoutX(48);
		label1.setLayoutY(15);
		
		btn1.setPrefSize(100, 70);
		btn1.setLayoutX(50);
		btn1.setLayoutY(100);

		btn2.setPrefSize(100, 70);
		btn2.setLayoutX(150);
		btn2.setLayoutY(100);
		
		pane.getChildren().addAll(label1, btn1, btn2);
		// 화면 크기 설정
		Scene scene = new Scene(pane, 300, 200);
		stage.setScene(scene);
		stage.setTitle("로그인 화면");
		stage.show();
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage stage1 = (Stage) btn1.getScene().getWindow();
			    stage1.close();
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
		Application.launch(Main.class);
	}
}
		