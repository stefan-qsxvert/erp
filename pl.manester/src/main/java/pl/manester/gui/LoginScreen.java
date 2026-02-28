package pl.manester.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import pl.manester.gui.events.CMouseEventHandler;

public class LoginScreen extends Application{
	
	private SharedObjects sharedObjects;
	private TextField userTextField;
	private PasswordField passwordField;
	private TextField addServerTextField;
	private Button loginButton;
	private TableView<ServerMenu> serverListTableView;
	private Stage primaryStage;
	
	public LoginScreen(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		PreparedGuiObjects preparedObjects = sharedObjects.getPreparedObjects();
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		userTextField = preparedObjects.createTextField("login", 34, 34);
		passwordField = preparedObjects.createPasswordField("hasło", 34, 68);
		passwordField.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				actions.loginActions(primaryStage, userTextField.getText(), passwordField.getText());
			}
		});
		
		addServerTextField = new TextField();
		
		primaryStage.setHeight(400);
		primaryStage.setWidth(580);
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));

		Label server = preparedObjects.createLabel("server", 360, 24, 196, 34);
		Pane pn0 = preparedObjects.createPane(360, 240, 196, 68);
		Pane pn1 = preparedObjects.createPane(144, 212, 34, 130);
		pn1.setBackground(preparedObjects.createLoginScreenBackgroundPicture());
		serverListTableView = preparedObjects.createSerTableView();
		
		
		String home = System.getProperty("user.home");
		
		File userProperties = new File(home + "/manester/user.properties");
		if (!userProperties.exists()) {
			userProperties.getParentFile().mkdirs();
			userProperties.createNewFile();
		}else {
			BufferedReader reader = new BufferedReader(new FileReader(userProperties));
			 userTextField.setText(reader.readLine());
	 		 reader.close();
		}
		
		File serversProperties = new File(home + "/manester/server.properties");
		if (!serversProperties.exists()) {
			serversProperties.getParentFile().mkdirs();
			serversProperties.createNewFile();
		}else {
			
			BufferedReader reader = new BufferedReader(new FileReader(serversProperties));
			String line = reader.readLine();
			while (line != null) {
				String[] serverLine = line.split(";");
				try {
					serverListTableView.getItems().add(new ServerMenu(serverLine[0], serverLine[1], serverLine[2]));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				line = reader.readLine();
			}
			
			reader.close();
		}
		
		
		
		addServerTextField.setPrefSize(360, 24);
		addServerTextField.setLayoutX(196);
		addServerTextField.setLayoutY(316);
		addServerTextField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
				String[] newPoz = addServerTextField.getText().split(";");
				serverListTableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2]));
				addServerTextField.clear();
				}catch(Exception e) {
				
				}}
		});
		
		loginButton = preparedObjects.createButton("zaloguj", "11",  144, 24, 34, 98);
		
//		loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent event) {
//				actions.loginActions(primaryStage, userTextField.getText(), passwordField.getText());
//			}
//		});
		
		loginButton.setOnMouseClicked(new CMouseEventHandler(sharedObjects));
			
		pn0.getChildren().addAll(serverListTableView);
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		pane.getChildren().addAll(
				userTextField,
				passwordField,
				pn0,
				server,
				addServerTextField,
				loginButton,
				pn1
				);
		
		primaryStage.setScene(scene);
//		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//			
//			@Override
//			public void handle(WindowEvent event) {
//				
//				if (event.getEventType().toString().equals("WINDOW_CLOSE_REQUEST")) {
//				try {
//					BufferedWriter writer = new BufferedWriter(new FileWriter(userProperties, false));
//					writer.write(userTextField.getText());
//					writer.newLine();
//					writer.close();
//					
//					BufferedWriter servery = new BufferedWriter(new FileWriter(serversProperties,false));
//						for ( int i = 0; i < tableView.getItems().size(); i++) {
//							servery.write(
//									tableView.getItems().get(i).getLp() +  ";" + 
//									tableView.getItems().get(i).getAlias() + ";" +
//									tableView.getItems().get(i).getIp()
//							);
//							servery.newLine();
//						}	
//					
//					servery.close();
//					
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				}}
//		});
		
		this.primaryStage = primaryStage;
		this.userTextField = userTextField;
		this.passwordField = passwordField;
		primaryStage.show();
		
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(TextField userTextField) {
		this.userTextField = userTextField;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public TextField getAddServerTextField() {
		return addServerTextField;
	}

	public void setAddServerTextField(TextField addServerTextField) {
		this.addServerTextField = addServerTextField;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

	public TableView<ServerMenu> getServerListTableView() {
		return serverListTableView;
	}

	public void setServerListTableView(TableView<ServerMenu> serverListTableView) {
		this.serverListTableView = serverListTableView;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

}
