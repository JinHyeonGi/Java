package Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jfree.text.TextBox;

import Vo.EmployeeVo;
import Vo.OrderVo;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Order extends Application {
	Label lb1 = new Label("  개수");
	TextField textField1 = new TextField();
	Button btn1 = new Button("   (HOT) \n아메리카노");
	Button btn2 = new Button("   (HOT) \n카페라떼");
	Button btn3 = new Button("   (HOT) \n카페모카");
	Button btn4 = new Button("    (HOT) \n바닐라라떼");
	Button btn5 = new Button("  (HOT) \n카푸치노");
	Button btn6 = new Button("    (ICE) \n아메리카노");
	Button btn7 = new Button("   (ICE) \n카페라떼");
	Button btn8 = new Button("   (ICE) \n카페모카");
	Button btn9 = new Button("    (ICE) \n바닐라라떼");
	Button btn10 = new Button("   (ICE) \n녹차라떼");
	Button btn11 = new Button("    (ICE) \n자몽에이드");
	Button btn12 = new Button("      (ICE) \n청포도에이드");
	Button btn13 = new Button("      (ICE) \n플레인스무디");
	Button btn14 = new Button("    (ICE) \n딸기스무디");
	Button btn15 = new Button("    (ICE) \n망고스무디");
	Button btn16 = new Button("+");
	Button btn17 = new Button("-");
	Button btn18 = new Button("선택취소");
	Button btn19 = new Button("전체취소");
	Button btn20 = new Button("결제");

	int btn1count = 1;
	int btn1price = 3500;
	int btn2count = 1;
	int btn2price = 3500;
	int btn3count = 1;
	int btn3price = 3500;
	int btn4count = 1;
	int btn4price = 3500;
	int btn5count = 1;
	int btn5price = 3500;
	int btn6count = 1;
	int btn6price = 3500;
	int btn7count = 1;
	int btn7price = 3500;
	int btn8count = 1;
	int btn8price = 3500;
	int btn9count = 1;
	int btn9price = 3500;
	int btn10count = 1;
	int btn10price = 3500;
	int btn11count = 1;
	int btn11price = 3500;
	int btn12count = 1;
	int btn12price = 3500;
	int btn13count = 1;
	int btn13price = 3500;
	int btn14count = 1;
	int btn14price = 3500;
	int btn15count = 1;
	int btn15price = 3500;

	public class PropertyVo {
		private IntegerProperty value = new SimpleIntegerProperty();

		public int getValue() {
			return value.get();
		}

		public void setValue(int value) {
			this.value.set(value);
		}

		public IntegerProperty valueProperty() {
			return value;
		}
	}

	public void start(Stage stage) {
		Pane pane = new Pane();
		GridPane grid = new GridPane();
		textField1.setPrefSize(150, 70);
		btn1.setPrefSize(100, 50);
		btn2.setPrefSize(100, 50);
		btn3.setPrefSize(100, 50);
		btn4.setPrefSize(100, 50);
		btn5.setPrefSize(100, 50);
		btn6.setPrefSize(100, 50);
		btn7.setPrefSize(100, 50);
		btn8.setPrefSize(100, 50);
		btn9.setPrefSize(100, 50);
		btn10.setPrefSize(100, 50);
		btn11.setPrefSize(100, 50);
		btn12.setPrefSize(100, 50);
		btn13.setPrefSize(100, 50);
		btn14.setPrefSize(100, 50);
		btn15.setPrefSize(100, 50);
		btn16.setPrefSize(20, 20);
		btn17.setPrefSize(20, 20);
		btn18.setPrefSize(100, 70);
		btn19.setPrefSize(100, 70);
		btn20.setPrefSize(100, 70);

		PropertyVo propertyVo = new PropertyVo();
		textField1.textProperty().bind(propertyVo.valueProperty().asString());

		BorderPane root = new BorderPane();
		TableView<OrderVo> tableView = new TableView<OrderVo>();
		root.setCenter(tableView);
		TableColumn<OrderVo, String> tc1 = new TableColumn<OrderVo, String>("메뉴명");
		TableColumn<OrderVo, Integer> tc2 = new TableColumn<OrderVo, Integer>("수량");
		TableColumn<OrderVo, Integer> tc3 = new TableColumn<OrderVo, Integer>("가격");
		tc1.setCellValueFactory(new PropertyValueFactory<OrderVo, String>("menu_Name"));
		tc2.setCellValueFactory(new PropertyValueFactory<OrderVo, Integer>("Count"));
		tc3.setCellValueFactory(new PropertyValueFactory<OrderVo, Integer>("Price"));
		tableView.getColumns().setAll(tc1, tc2, tc3);

		List<OrderVo> orderVoList = new ArrayList<OrderVo>();

		btn1.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(HOT)아메리카노", btn1count, btn1price));
				btn1.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(HOT)카페라떼", btn2count, btn2price));
				btn2.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(HOT)카페모카", btn3count, btn3price));
				btn3.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(HOT)바닐라라떼", btn4count, btn4price));
				btn4.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn5.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(HOT)카푸치노", btn5count, btn5price));
				btn5.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)아메리카노", btn6count, btn6price));
				btn6.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn7.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)카페라떼", btn7count, btn7price));
				btn7.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)카페모카", btn8count, btn8price));
				btn8.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn9.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)바닐라라떼", btn9count, btn9price));
				btn9.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn10.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)녹차라떼", btn10count, btn10price));
				btn10.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn11.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)자몽에이드", btn11count, btn11price));
				btn11.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn12.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)청포도에이드", btn12count, btn12price));
				btn12.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn13.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)플레인스무디", btn13count, btn13price));
				btn13.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn14.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)딸기스무디", btn14count, btn14price));
				btn14.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn15.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				tableView.getItems().add(new OrderVo("(ICE)망고스무디", btn15count, btn15price));
				btn15.setDisable(true);
				propertyVo.setValue(propertyVo.getValue() + 3500);
			}
		});
		btn16.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				OrderVo orderVo = (OrderVo) tableView.getSelectionModel().getSelectedItem();
				if (orderVo.getMenu_Name().equals("(HOT)아메리카노")) {
					btn1count++;
					btn1price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)아메리카노", btn1count, btn1price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페라떼")) {
					btn2count++;
					btn2price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카페라떼", btn2count, btn2price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페모카")) {
					btn3count++;
					btn3price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카페모카", btn3count, btn3price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)바닐라라떼")) {
					btn4count++;
					btn4price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)바닐라라떼", btn4count, btn4price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카푸치노")) {
					btn5count++;
					btn5price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카푸치노", btn5count, btn5price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)아메리카노")) {
					btn6count++;
					btn6price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)아메리카노", btn6count, btn6price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페라떼")) {
					btn7count++;
					btn7price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)카페라떼", btn7count, btn7price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페모카")) {
					btn8count++;
					btn8price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)카페모카", btn8count, btn8price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)바닐라라떼")) {
					btn9count++;
					btn9price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)바닐라라떼", btn9count, btn9price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)녹차라떼")) {
					btn10count++;
					btn10price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)녹차라떼", btn10count, btn10price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)자몽에이드")) {
					btn11count++;
					btn11price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)자몽에이드", btn11count, btn11price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)청포도에이드")) {
					btn12count++;
					btn12price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)청포도에이드", btn12count, btn12price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)플레인스무디")) {
					btn13count++;
					btn13price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)플레인스무디", btn13count, btn13price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)딸기스무디")) {
					btn14count++;
					btn14price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)딸기스무디", btn14count, btn14price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)망고스무디")) {
					btn15count++;
					btn15price += 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)망고스무디", btn15count, btn15price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() + 3500);
				}
			}
		});
		btn17.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				OrderVo orderVo = (OrderVo) tableView.getSelectionModel().getSelectedItem();
				if (orderVo.getMenu_Name().equals("(HOT)아메리카노")) {
					btn1count--;
					btn1price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)아메리카노", btn1count, btn1price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페라떼")) {
					btn2count--;
					btn2price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카페라떼", btn2count, btn2price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페모카")) {
					btn3count--;
					btn3price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카페모카", btn3count, btn3price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)바닐라라떼")) {
					btn4count--;
					btn4price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)바닐라라떼", btn4count, btn4price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(HOT)카푸치노")) {
					btn5count--;
					btn5price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(HOT)카푸치노", btn5count, btn5price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)아메리카노")) {
					btn6count--;
					btn6price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)아메리카노", btn6count, btn6price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페라떼")) {
					btn7count--;
					btn7price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)카페라떼", btn7count, btn7price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페모카")) {
					btn8count--;
					btn8price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)카페모카", btn8count, btn8price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)바닐라라떼")) {
					btn9count--;
					btn9price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)바닐라라떼", btn9count, btn9price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)녹차라떼")) {
					btn10count--;
					btn10price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)녹차라떼", btn10count, btn10price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)자몽에이드")) {
					btn11count--;
					btn11price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)자몽에이드", btn11count, btn11price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)청포도에이드")) {
					btn12count--;
					btn12price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)청포도에이드", btn12count, btn12price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)플레인스무디")) {
					btn13count--;
					btn13price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)플레인스무디", btn13count, btn13price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)딸기스무디")) {
					btn14count--;
					btn14price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)딸기스무디", btn14count, btn14price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
				if (orderVo.getMenu_Name().equals("(ICE)망고스무디")) {
					btn15count--;
					btn15price -= 3500;
					tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
					tableView.getItems().add(new OrderVo("(ICE)망고스무디", btn15count, btn15price));
					tableView.getSelectionModel().select(tableView.getFocusModel().getFocusedIndex());
					propertyVo.setValue(propertyVo.getValue() - 3500);
				}
			}
		});
		btn18.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				OrderVo orderVo = (OrderVo) tableView.getSelectionModel().getSelectedItem();
				if (orderVo.getMenu_Name().equals("(HOT)아메리카노")) {
					btn1.setDisable(false);
					btn1count--;
					btn1price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페라떼")) {
					btn2.setDisable(false);
					btn2count--;
					btn2price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(HOT)카페모카")) {
					btn3.setDisable(false);
					btn3count--;
					btn3price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(HOT)바닐라라떼")) {
					btn4.setDisable(false);
					btn4count--;
					btn4price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(HOT)카푸치노")) {
					btn5.setDisable(false);
					btn5count--;
					btn5price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)아메리카노")) {
					btn6.setDisable(false);
					btn6count--;
					btn6price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페라떼")) {
					btn7.setDisable(false);
					btn7count--;
					btn7price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)카페모카")) {
					btn8.setDisable(false);
					btn8count--;
					btn8price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)바닐라라떼")) {
					btn9.setDisable(false);
					btn9count--;
					btn9price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)녹차라떼")) {
					btn10.setDisable(false);
					btn10count--;
					btn10price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)자몽에이드")) {
					btn11.setDisable(false);
					btn11count--;
					btn11price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)청포도에이드")) {
					btn12.setDisable(false);
					btn12count--;
					btn12price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)플레인스무디")) {
					btn13.setDisable(false);
					btn13count--;
					btn13price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)딸기스무디")) {
					btn14.setDisable(false);
					btn14count--;
					btn14price -= 3500;
				}
				if (orderVo.getMenu_Name().equals("(ICE)망고스무디")) {
					btn15.setDisable(false);
					btn15count--;
					btn15price -= 3500;
				}

				tableView.getItems().remove(tableView.getFocusModel().getFocusedIndex());
				propertyVo.setValue(propertyVo.getValue() - orderVo.getPrice());
			}
		});
		btn19.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				btn1count = 1;
				btn1price = 3500;
				btn2count = 1;
				btn2price = 3500;
				btn3count = 1;
				btn3price = 3500;
				btn4count = 1;
				btn4price = 3500;
				btn5count = 1;
				btn5price = 3500;
				btn6count = 1;
				btn6price = 3500;
				btn7count = 1;
				btn7price = 3500;
				btn8count = 1;
				btn8price = 3500;
				btn9count = 1;
				btn9price = 3500;
				btn10count = 1;
				btn10price = 3500;
				btn11count = 1;
				btn11price = 3500;
				btn12count = 1;
				btn12price = 3500;
				btn13count = 1;
				btn13price = 3500;
				btn14count = 1;
				btn14price = 3500;
				btn15count = 1;
				btn15price = 3500;
				btn1.setDisable(false);
				btn2.setDisable(false);
				btn3.setDisable(false);
				btn4.setDisable(false);
				btn5.setDisable(false);
				btn6.setDisable(false);
				btn7.setDisable(false);
				btn8.setDisable(false);
				btn9.setDisable(false);
				btn10.setDisable(false);
				btn11.setDisable(false);
				btn12.setDisable(false);
				btn13.setDisable(false);
				btn14.setDisable(false);
				btn15.setDisable(false);
				tableView.getItems().clear();
				propertyVo.setValue(0);
			}
		});
		btn20.setOnAction(new EventHandler<ActionEvent>() { // btn 클릭 시 발생되는 Action
			public void handle(ActionEvent event) {
				btn1count = 1;
				btn1price = 3500;
				btn2count = 1;
				btn2price = 3500;
				btn3count = 1;
				btn3price = 3500;
				btn4count = 1;
				btn4price = 3500;
				btn5count = 1;
				btn5price = 3500;
				btn6count = 1;
				btn6price = 3500;
				btn7count = 1;
				btn7price = 3500;
				btn8count = 1;
				btn8price = 3500;
				btn9count = 1;
				btn9price = 3500;
				btn10count = 1;
				btn10price = 3500;
				btn11count = 1;
				btn11price = 3500;
				btn12count = 1;
				btn12price = 3500;
				btn13count = 1;
				btn13price = 3500;
				btn14count = 1;
				btn14price = 3500;
				btn15count = 1;
				btn15price = 3500;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("정보");
				alert.setHeaderText("결제 완료!");
				alert.setContentText("주문이 완료되었습니다. \n 이용해주셔서 감사합니다.");
				alert.showAndWait();
				btn1.setDisable(false);
				btn2.setDisable(false);
				btn3.setDisable(false);
				btn4.setDisable(false);
				btn5.setDisable(false);
				btn6.setDisable(false);
				btn7.setDisable(false);
				btn8.setDisable(false);
				btn9.setDisable(false);
				btn10.setDisable(false);
				btn11.setDisable(false);
				btn12.setDisable(false);
				btn13.setDisable(false);
				btn14.setDisable(false);
				btn15.setDisable(false);
				tableView.getItems().clear();
				propertyVo.setValue(0);
			}
		});
		

		grid.add(tableView, 0, 0, 1, 6);
		grid.add(textField1, 0, 6);
		grid.add(btn1, 2, 0);
		grid.add(btn2, 2, 1);
		grid.add(btn3, 2, 2);
		grid.add(btn4, 2, 3);
		grid.add(btn5, 2, 4);
		grid.add(btn6, 3, 0);
		grid.add(btn7, 3, 1);
		grid.add(btn8, 3, 2);
		grid.add(btn9, 3, 3);
		grid.add(btn10, 3, 4);
		grid.add(btn11, 4, 0);
		grid.add(btn12, 4, 1);
		grid.add(btn13, 4, 2);
		grid.add(btn14, 4, 3);
		grid.add(btn15, 4, 4);
		grid.add(btn16, 2, 5);
		grid.add(lb1, 3, 5);
		grid.add(btn17, 4, 5);
		grid.add(btn18, 2, 6);
		grid.add(btn19, 3, 6);
		grid.add(btn20, 4, 6);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 700, 450);
		stage.setScene(scene);
		stage.setTitle("주문정보 화면");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(Order.class);
	}
}
