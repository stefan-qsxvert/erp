package pl.manester.gui;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
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
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;
import pl.manester.gui.events.CellEventHandler;

public class PreparedObjects {
	
	SharedObjects sharedObjects;
	
	public PreparedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public Button createButton(String text, String id, Integer layoutX, Integer layoutY) {
		Button przycisk =new Button();
		przycisk.setText(text);
		przycisk.setOnAction(sharedObjects.getEvents());
		przycisk.setId(id);
		przycisk.setMaxSize(88,24);
		przycisk.setMinSize(88, 24);
		przycisk.setLayoutX(layoutX);
		przycisk.setLayoutY(layoutY);
		return przycisk;
	}
	public TextField createTextField(String text, Integer layoutX, Integer layoutY) {
		
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		TextField textField = new TextField();
		textField.setPromptText(text);
//		textField.setPrefWidth(164);
		textField.setLayoutX(layoutX);
		textField.setLayoutY(layoutY);
		textField.setMaxSize(144, 24);
		textField.setMinSize(144, 24);
		textField.setBorder(border);
		return textField;
	}
	
	public PasswordField createPasswordField(String password, Integer layoutX, Integer layoutY) {
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText(password);
		passwordField.setMaxSize(144, 24);
		passwordField.setMinSize(144, 24);
		passwordField.setLayoutX(layoutX);
		passwordField.setLayoutY(layoutY);
//		passwordField.setOnAction(ev -> {
//			sharedObjects.getDbconn().connectDB();
//			sharedObjects.getEventActions().fillTable();
//			sharedObjects.getDbconn().disconnectDB();
//		});
		return passwordField;
	}
	
	public TableView<Person> createPersonTableView(Integer layoutX, Integer layoutY) {
		
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		TableView<Person> tableView = new TableView<>();
		
		TableColumn<Person, String> col0 = new TableColumn<Person, String>();
		TableColumn<Person, String> col1 = new TableColumn<Person, String>();
		TableColumn<Person, String> col2 = new TableColumn<Person, String>();
		TableColumn<Person, String> col3 = new TableColumn<Person, String>();
		
		col0.setCellValueFactory( data -> data.getValue().getNumber());
		col1.setCellValueFactory( data -> data.getValue().getNazwisko());
		col2.setCellValueFactory( data -> data.getValue().getImie());
		
		col0.setMinWidth(24);
		col0.setMaxWidth(640);
		col1.setMinWidth(56);
		col1.setMaxWidth(640);
		col2.setMinWidth(56);
		col2.setMaxWidth(640);
		
		col0.setText("Lp");
		col1.setText("Nazwisko");
		col2.setText("Imię");
		
		col0.setOnEditCommit(new CellEventHandler(sharedObjects, "0"));
		col1.setOnEditCommit(new CellEventHandler(sharedObjects, "1"));
		col2.setOnEditCommit(new CellEventHandler(sharedObjects, "2"));
		
		col0.setResizable(true);
		col1.setResizable(true);
		col2.setResizable(true);
		
		tableView.getColumns().addAll(col0,col1,col2);
		 
		tableView.setEditable(true);
		
		col0.setCellFactory(TextFieldTableCell.forTableColumn());
		col1.setCellFactory(TextFieldTableCell.forTableColumn());
		col2.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView.setMinSize(504, 524);
		tableView.setMaxSize(504, 524);
		tableView.setLayoutX(layoutX);
		tableView.setLayoutY(layoutY);
		
		tableView.setBorder(border);
		
		return tableView;
	}
	
	public Image createLogo() {
		Image logo = new Image(sharedObjects.getClass().getResource("/1765051670049.jpg").toString(), false);
		return logo;
	}
	
	public Pane createPane(Integer w, Integer h, Integer layoutX, Integer layoutY) {
		Pane pane = new Pane();
		
		pane.setPrefSize(w, h);
		pane.setLayoutX(layoutX);
		pane.setLayoutY(layoutY);
		
		return pane;
	}
	
	public Pane createLeaf(String item) {
		
//		Background background = sharedObjects.getAuxPreperdObjects().createLeafBackground();
		Image backImage = new Image(sharedObjects.getGraph().getLeaf_bcg().toString());
		BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		Pane pane = new Pane();
//		pane.setBorder(sharedObjects.getAuxPreperdObjects().createSolidBorder());
		
		Label textPos = new Label(item);
//		textPos.setBackground(background);
		textPos.setPrefWidth(272);
		textPos.setTextFill(Color.BLACK);
		
		CheckBox filterCheckbox = new CheckBox();
		CheckBox raportCheckbox = new CheckBox();
		
		filterCheckbox.setLayoutX(206);
		raportCheckbox.setLayoutX(246);
		
		pane.getChildren().addAll(
				textPos,
				filterCheckbox,
				raportCheckbox				
				);
		
//		pane.setBackground(Background.fill(Color.LIGHTGREY));
		pane.setBackground(new Background(backgroundImage));
		pane.setOpacity(0.9);
		pane.setPrefWidth(244);
		return pane;
	}
	
}
