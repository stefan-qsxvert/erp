package pl.manester.gui;

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
		
		this.primaryStage = primaryStage;
		
		PreparedGuiObjects preparedObjects = sharedObjects.getPreparedObjects();
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		userTextField = preparedObjects.createTextField("login", 34, 34);
		passwordField = preparedObjects.createPasswordField("hasło", 34, 68);
		passwordField.setOnAction(sharedObjects.getcActionEvent());
		
		addServerTextField = new TextField();
		
		primaryStage.setHeight(400);
		primaryStage.setWidth(580);
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));

		Label server = preparedObjects.createLabel("server", 360, 24, 196, 34);
		Pane pn0 = preparedObjects.createPane(360, 240, 196, 68);
		Pane pn1 = preparedObjects.createPane(144, 212, 34, 130);
		pn1.setBackground(preparedObjects.createLoginScreenBackgroundPicture());
		serverListTableView = preparedObjects.createServerTableView();
		
		addServerTextField.setPrefSize(360, 24);
		addServerTextField.setLayoutX(196);
		addServerTextField.setLayoutY(316);
		addServerTextField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
				String[] newPoz = addServerTextField.getText().split(";");
				serverListTableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2], newPoz[3]));
				addServerTextField.clear();
				sharedObjects.getEventActions().writeLastUserAndServerList(userTextField, serverListTableView);
				}catch(Exception e) {
				
				}}
		});
		
		loginButton = preparedObjects.createButton("zaloguj", "11",  144, 24, 34, 98);		
		loginButton.setOnMouseClicked(sharedObjects.getcMouseEventHandler());
			
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
		
		sharedObjects.getEventActions().loadLastUser(userTextField);
		sharedObjects.getEventActions().loadServerList(serverListTableView);
		
		primaryStage.setScene(scene);
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
