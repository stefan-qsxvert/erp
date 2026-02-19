package pl.manester.gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class REGPanel extends Application {
	
	private PreparedObjects preparedObjects;
	private SharedObjects sharedObjects;
	private Events ev;
	private TextField itTextField;
	private TextField swTextField;
	private TextField ewidNr;
	private TableView<Person> tablePersonList;
	private Stage primaryStageCopy;
	private Image logo;
	private Graph graph;
	private Pane root;
	
	public REGPanel(SharedObjects sharedObjects) {
		preparedObjects = new PreparedObjects(sharedObjects);
		this.sharedObjects = sharedObjects;
		ev = new Events(sharedObjects);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getSlavFile().toString(),false));
		
		PreparedObjects preparedObjects = sharedObjects.getPreparedObjects();
		AuxPreperdObjects auxPreperdObjects = sharedObjects.getAuxPreperdObjects();
				
		primaryStageCopy = primaryStage;
		
		itTextField = preparedObjects.createTextField("IT", 224, 660);
		swTextField = preparedObjects.createTextField("SW", 586, 660);
		ewidNr = preparedObjects.createTextField("Numer ewidencyjny lub PESEL", 224, 4);
		ewidNr.setOnAction(ev -> {
//			sharedObjects.getDbconn().connectDB();
			sharedObjects.getEventActions().fillTable();
//			sharedObjects.getDbconn().disconnectDB();
		});
			
		;
		logo = preparedObjects.createLogo();
		tablePersonList = preparedObjects.createPersonTableView(224, 126);
		
		itTextField.setMinSize(96, 24);
		itTextField.setMaxSize(96, 24);
				
		BackgroundImage bgimg = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		
		Background bcg =new Background(bgimg);
			
		root = new Pane();

		Button button = new Button("Nowe okno");
		button.setLayoutX(640);
		button.setLayoutY(4);
		
		button.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				try {
					sharedObjects.getGui().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		
		});
		
		Pane listPane = preparedObjects.createPane(212, 660, 4, 36);
		listPane.setBorder(auxPreperdObjects.createSolidBorder());
		
		tablePersonList.getItems().add(new Person("1", "Nowak", "Krystna"));
		
		root.getChildren().addAll(
									ewidNr, 
									itTextField, 
									swTextField, 
									tablePersonList,
									listPane
									);

		
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


	public TableView<Person> getTablePersonList() {
		return tablePersonList;
	}

	public void setTablePersonList(TableView<Person> tablePersonList) {
		this.tablePersonList = tablePersonList;
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

	public TextField getItTextField() {
		return itTextField;
	}

	public void setItTextField(TextField itTextField) {
		this.itTextField = itTextField;
	}

	public TextField getSwTextField() {
		return swTextField;
	}

	public void setSwTextField(TextField swTextField) {
		this.swTextField = swTextField;
	}

	public TextField getEwidNr() {
		return ewidNr;
	}

	public void setEwidNr(TextField ewidNr) {
		this.ewidNr = ewidNr;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}
}
