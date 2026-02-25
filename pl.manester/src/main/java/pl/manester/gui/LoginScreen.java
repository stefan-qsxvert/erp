package pl.manester.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.manester.app.AppConfig;
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
		
		TextField textField = new TextField();
		
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
		
		Pane pn1 = new Pane();
		pn1.setLayoutX(34);
		pn1.setLayoutY(130);
		pn1.setPrefSize(144, 212);
//		pn1.setBorder(border);
		
		Image image = new Image(sharedObjects.getGraph().getSlavFile().toString());
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		
		pn1.setBackground(background);
		
		TableView<ServerMenu> tableView = new TableView<>();
		tableView.setPrefSize(358, 240);
		TableColumn<ServerMenu, String> coll_lp = new TableColumn<>();
		TableColumn<ServerMenu, String> coll_text = new TableColumn<>();
		TableColumn<ServerMenu, String> coll_ip = new TableColumn<>();
		
		coll_lp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLp()));
		coll_text.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlias()));
		coll_ip.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIp()));
		
		coll_lp.setPrefWidth(24);
		coll_text.setPrefWidth(116);
		coll_ip.setPrefWidth(196);
		
		coll_lp.setText("lp");
		coll_text.setText("alias");
		coll_ip.setText("ip");
		
		try {
		String home = System.getProperty("user.home");
		Gson gson = new Gson();
		
		File userProperties = new File(home + "/manester/user.properties");
		if (!userProperties.exists()) {
			userProperties.getParentFile().mkdirs();
			userProperties.createNewFile();
		}else {
			
			BufferedReader reader = new BufferedReader(new FileReader(userProperties));
			System.out.println(reader.readLine());
			Type listType = new TypeToken<List<AppConfig>>() {}.getType();
			List<AppConfig> userConfig = gson.fromJson(reader, listType);
			
			for (AppConfig u : userConfig) {
				
				System.out.println(u.getLogin());
				
			}
			
		}
		
		File serverConfig = new File(home + "/manester/server.properties");
		if (!serverConfig.exists()) {
			serverConfig.getParentFile().mkdirs();
			serverConfig.createNewFile();
			
		}else {
			
			JsonReader reader = new JsonReader(new FileReader(serverConfig));
			reader.setLenient(true);
//			BufferedReader reader = new BufferedReader( new FileReader(serverConfig));
			int i =0;
			
			AppConfig config = gson.fromJson(reader, AppConfig.class);
			System.out.println(reader.toString());
			
			
			while (reader.hasNext()) {
				
				System.out.println(i++);
			}
		}
		
		}catch(Exception e) {
			
		}
		
		tableView.getItems().add(new ServerMenu("1", "HSR", "82.165.235.182:7032"));
		
		tableView.getColumns().addAll(coll_lp, coll_text, coll_ip);
		
		tableView.getSelectionModel().selectedItemProperty().addListener((poz, n, o) -> sharedObjects.getDbconn().setIp(poz.getValue().getIp()));
//		tableView.getSelectionModel().selectedItemProperty().addListener((poz, n, o) -> System.out.println(poz.getValue().getIp()));
		
		textField.setPrefSize(360, 24);
		textField.setLayoutX(196);
		textField.setLayoutY(316);
		textField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
				String[] newPoz = textField.getText().split(";");
				tableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2]));
				}catch(Exception e) {
				
				}}
		});
		
		TextField userTextField = preparedObjects.createTextField("login", 34, 34);
		PasswordField passwordField = preparedObjects.createPasswordField("hasło", 34, 68);
		passwordField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				sharedObjects.getDbconn().setUserDB(userTextField.getText());
				sharedObjects.getDbconn().setUserPasswordDB(passwordField.getText());
				
				if (sharedObjects.getTestMode()) {
					try {
						primaryStage.hide();
						sharedObjects.getMainAppScreen().start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					sharedObjects.getDbconn().connectDB();
				
//				sharedObjects.getDbconn().disconnectDB();
				
				if (sharedObjects.getDbconn().getConnectionState()) {
				
				primaryStage.hide();
				try {
//					sharedObjects.getGui().start(new Stage());
					sharedObjects.getMainAppScreen().start(new Stage());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				}
				}
				
			}
		});
		
		Button loginButton = new Button("Zaloguj");
		loginButton.setLayoutX(34);
		loginButton.setLayoutY(98);
		loginButton.setPrefSize(144, 24);
		loginButton.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
//				
				sharedObjects.getDbconn().setUserDB(userTextField.getText());
				sharedObjects.getDbconn().setUserPasswordDB(passwordField.getText());
				
				if (sharedObjects.getTestMode()) {
					try {
						primaryStage.hide();
						sharedObjects.getMainAppScreen().start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					sharedObjects.getDbconn().connectDB();
				
//				sharedObjects.getDbconn().disconnectDB();
				
				if (sharedObjects.getDbconn().getConnectionState()) {
				
				primaryStage.hide();
				try {
//					sharedObjects.getGui().start(new Stage());
					sharedObjects.getMainAppScreen().start(new Stage());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				}
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
				loginButton,
				pn1
				);
		
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				
				if (event.getEventType().toString().equals("WINDOW_CLOSE_REQUEST")) {
//					System.out.println( event.getEventType());
					
					AppConfig appConfig = new AppConfig();
					appConfig.setLogin(userTextField.getText());
					
					try {
//						FileWriter login = new FileWriter(userProperties);
//						gson.toJson(appConfig, login);
//						login.close();
						
//						FileWriter servers = new FileWriter(serverConfig);
						
						for (ServerMenu sr : tableView.getItems()) {
//							gson.toJson(new ServerMenu(sr.getLp(), sr.getAlias(), sr.getIp()), servers);
						}
						
//						servers.close();
//						System.out.println(tableView.getColumns().get(0).getText());
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
			}
		});
		primaryStage.show();
		
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

}
