package pl.manester.gui;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class LoginScreen extends Application{
	
	private SharedObjects sharedObjects;
	
	public LoginScreen(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		PreparedObjects preparedObjects = sharedObjects.getPreparedObjects();
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		primaryStage.setHeight(400);
		primaryStage.setWidth(580);
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));

		Label server = new Label("server");
		server.setLayoutX(196);
		server.setLayoutY(34);
		server.setBorder(border);
		server.setPrefWidth(360);
		server.setPrefHeight(24);
		
		
		Pane pn0 = new Pane();
		pn0.setBorder(border);
		pn0.setPrefSize(360, 240);
		pn0.setLayoutX(196);
		pn0.setLayoutY(68);
		
		TableView<String> tableView = new TableView<>();
		tableView.setPrefSize(358, 240);
		TableColumn<String, String> coll_lp = new TableColumn<String, String>();
		TableColumn<String, String> coll_text = new TableColumn<String, String>();
		TableColumn<String, String> coll_ip = new TableColumn<String, String>();
		
		coll_lp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		coll_text.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		coll_ip.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		
		coll_lp.setPrefWidth(8);
		coll_text.setPrefWidth(116);
		coll_ip.setPrefWidth(116);
		
		tableView.getItems().add(new String("10.8.0.10:5432"));
		
		tableView.getColumns().addAll(coll_lp, coll_text, coll_ip);
		
		TextField textField = new TextField();
		textField.setPrefSize(360, 24);
		textField.setLayoutX(196);
		textField.setLayoutY(316);
		textField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				tableView.getItems().add (new String(textField.getText()));
			}
		});
		
		TextField userTextField = preparedObjects.createTextField("login", 34, 34);
		PasswordField passwordField = preparedObjects.createPasswordField("hasło", 34, 68);
		
		Button loginButton = new Button("Zaloguj");
		loginButton.setLayoutX(34);
		loginButton.setLayoutY(98);
		loginButton.setPrefSize(144, 24);
		loginButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
//				sharedObjects.getDbconn().setUserDB(userTextField.getText());
//				sharedObjects.getDbconn().setUserPasswordDB(passwordField.getText());
//				sharedObjects.getDbconn().connectDB();
//				System.out.println(sharedObjects.getDbconn().getConnectionState());
//				sharedObjects.getDbconn().disconnectDB();
				
				primaryStage.hide();
				try {
					sharedObjects.getGui().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		tableView.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				if (event.toString().contains("code = DELETE")) {
				System.out.println(event.toString());
				}
			}
		});
		
		pn0.getChildren().addAll(tableView);
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		pane.getChildren().addAll(
				userTextField,
				passwordField,
				pn0,
				server,
				textField,
				loginButton
				);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

}
