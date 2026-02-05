package pl.manester.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;

public class Gui extends Application {
	
	private PreparedObjects preparedObjects;
	private SharedObjects sharedObjects;
	private Events ev;
	private TextField ipTextField;
	private TextField userTextField;
	private PasswordField passwordField;
	private TextField databaseTextField;
	private Button button;
	private TableView<Person> tablePersonList;
	private Stage primaryStageCopy;

	
	public Gui(SharedObjects sharedObjects) {
		preparedObjects = new PreparedObjects(sharedObjects);
		this.sharedObjects = sharedObjects;
		ev = new Events(sharedObjects);
	}
	
	public Gui() {
	}
	
	public void run(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStageCopy = primaryStage;
		
		ipTextField = preparedObjects.createTextField("ip:port", 4, 4);
		userTextField = preparedObjects.createTextField("User", 320, 4);
		passwordField = preparedObjects.createPasswordField("Password", 480, 1);
		databaseTextField = preparedObjects.createTextField("baza danych", 164, 4);
		button = preparedObjects.createButton("Połącz!", "connectDB", 640, 4);
		
		tablePersonList = preparedObjects.createPersonTableView(4, 36);
		
		ipTextField.appendText("10.8.0.10:5432");
		userTextField.appendText("manester");
		passwordField.appendText("");
		databaseTextField.appendText("manester");
		
		Pane root = new Pane();

		root.getChildren().addAll(tablePersonList, ipTextField, userTextField, databaseTextField, button, passwordField);
		
		Scene sc = new Scene(root, 260, 320);
		
		primaryStage.setTitle("Moje okno");
		primaryStage.setScene(sc);
		primaryStage.setHeight(680);
		primaryStage.setWidth(796);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public SharedObjects getObiekty() {
		return sharedObjects;
	}
	public void setObiekty(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public PreparedObjects getPreparedObjects() {
		return preparedObjects;
	}

	public void setPreparedObjects(PreparedObjects preparedObjects) {
		this.preparedObjects = preparedObjects;
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public Events getEv() {
		return ev;
	}

	public void setEv(Events ev) {
		this.ev = ev;
	}

	public TextField getIpTextField() {
		return ipTextField;
	}

	public void setIp(TextField ipTextField) {
		this.ipTextField = ipTextField;
	}

	public TextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(TextField useTextField) {
		this.userTextField = useTextField;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public TableView<Person> getTablePersonList() {
		return tablePersonList;
	}

	public void setTablePersonList(TableView<Person> tablePersonList) {
		this.tablePersonList = tablePersonList;
	}

	public TextField getDatabaseTextField() {
		return databaseTextField;
	}

	public void setDatabaseTextField(TextField databaseTextField) {
		this.databaseTextField = databaseTextField;
	}

	public void setIpTextField(TextField ipTextField) {
		this.ipTextField = ipTextField;
	}

	public Stage getPrimaryStageCopy() {
		return primaryStageCopy;
	}

	public void setPrimaryStageCopy(Stage primaryStageCopy) {
		this.primaryStageCopy = primaryStageCopy;
	}
	
}
