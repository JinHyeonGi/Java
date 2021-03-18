package Main;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
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

public class MainView extends Application {
	Button btn1 = new Button("직원관리");
	Button btn2 = new Button("회원관리");
	Button btn3 = new Button("주문");
	Button btn4 = new Button("재료관리");

	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();

		btn1.setPrefSize(100, 70);
		btn1.setLayoutX(30);
		btn1.setLayoutY(30);

		btn2.setPrefSize(100, 70);
		btn2.setLayoutX(130);
		btn2.setLayoutY(30);

		btn3.setPrefSize(100, 70);
		btn3.setLayoutX(230);
		btn3.setLayoutY(30);

		btn4.setPrefSize(100, 70);
		btn4.setLayoutX(330);
		btn4.setLayoutY(30);

		pane.getChildren().addAll(btn1, btn2, btn3, btn4);

		Scene scene = new Scene(pane, 450, 130);
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
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage stage1 = (Stage) btn3.getScene().getWindow();
				stage1.close();
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage stage1 = (Stage) btn4.getScene().getWindow();
				stage1.close();
			}
		});
	}

	public static void main(String[] args) {
		Application.launch(MainView.class);
	}
}
