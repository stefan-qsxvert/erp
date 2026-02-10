package pl.manester.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;
import pl.manester.gui.events.Events;

public class Gui extends Application {
	
	private PreparedObjects preparedObjects;
	private SharedObjects sharedObjects;
	private Events ev;
	private TextField ipTextField;
	private TextField userTextField;
	private TextField itTextField;
	private TextField swTextField;
	private TextField ewidNr;
	private PasswordField passwordField;
	private TextField databaseTextField;
	private Button button;
	private TableView<Person> tablePersonList;
	private Stage primaryStageCopy;
	private Image logo;
	private Graph graph;
	
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
		graph = new Graph(sharedObjects);
		sharedObjects.setGraph(graph);
		primaryStage.getIcons().add(graph.getLogo());
		primaryStage.setTitle("ERP");
		
		primaryStageCopy = primaryStage;
		
//		primaryStage.getIcons().add(sharedObjects.getImages().getLogo());
		
		ipTextField = preparedObjects.createTextField("ip:port", 4, 4);
		databaseTextField = preparedObjects.createTextField("baza danych", 164, 4);
		itTextField = preparedObjects.createTextField("IT", 224, 660);
		swTextField = preparedObjects.createTextField("SW", 586, 660);
		ewidNr = preparedObjects.createTextField("Numer ewidencyjny lub PESEL", 224, 36);
		userTextField = preparedObjects.createTextField("User", 320, 4);
		passwordField = preparedObjects.createPasswordField("Password", 480, 4);
		button = preparedObjects.createButton("Połącz!", "connectDB", 640, 4);
		logo = preparedObjects.createLogo();
		tablePersonList = preparedObjects.createPersonTableView(224, 126);
		
		itTextField.setMinSize(344, 24);
		itTextField.setMaxSize(344, 24);
				
//		BackgroundImage bgimg = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, 12.0);
		
		BackgroundImage bgimg = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		
		Background bcg =new Background(bgimg);
		
		ipTextField.appendText("10.8.0.10:5432");
		userTextField.appendText("manester");
		passwordField.appendText("");
		databaseTextField.appendText("manester");
		
		Pane root = new Pane();
//		VBox vb = new VBox();
//		vb.setBackground(bcg);
//		vb.setMinSize(180, 160);
//		vb.setLayoutX(580);
//		vb.setLayoutY(36);

		sharedObjects.getGui().getTablePersonList().getItems().add(new Person("1", "Nowak", "Krystna"));
		
		root.getChildren().addAll(ewidNr, itTextField, swTextField, tablePersonList, ipTextField, userTextField, databaseTextField, button, passwordField, preparedObjects.createTreeMenu());
		root.setBackground(bcg);
		Scene sc = new Scene(root, 260, 320);
		
		primaryStage.setTitle("Moje okno");
		primaryStage.setScene(sc);
		primaryStage.setHeight(770);
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

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
}
