package pl.manester.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
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
import javafx.util.Callback;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;
import pl.manester.gui.events.CCellEventHandler;

public class PreparedGuiObjects {
	
	SharedObjects sharedObjects;
	
	public PreparedGuiObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public Button createButton(String text, String id, Integer width, Integer height, Integer layoutX, Integer layoutY) {
		Button przycisk =new Button();
		przycisk.setText(text);
		przycisk.setOnAction(sharedObjects.getEvents());
		przycisk.setId(id);
		przycisk.setPrefSize(width, height);
//		przycisk.setMaxSize(88,24);
//		przycisk.setMinSize(88, 24);
		przycisk.setLayoutX(layoutX);
		przycisk.setLayoutY(layoutY);
		return przycisk;
	}
	public TextField createTextField(String text, Integer layoutX, Integer layoutY) {
		
		Border border = new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
		
		TextField textField = new TextField();
		textField.setPromptText(text);
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
		
		col0.setOnEditCommit(new CCellEventHandler(sharedObjects, "0"));
		col1.setOnEditCommit(new CCellEventHandler(sharedObjects, "1"));
		col2.setOnEditCommit(new CCellEventHandler(sharedObjects, "2"));
		
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
		
		Image backImage = new Image(sharedObjects.getGraph().getLeaf_bcg().toString());
		BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

		Pane pane = new Pane();
		
		Label textPos = new Label(item);
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
		
		pane.setBackground(new Background(backgroundImage));
		pane.setOpacity(0.9);
		pane.setPrefWidth(244);
		return pane;
	}
	
	public Label createLabel(String text, Integer width, Integer height, Integer layoutX, Integer layoutY) {
		
		Label label = new Label(text);
		label.setLayoutX(layoutX);
		label.setLayoutY(layoutY);
//		label.setBorder(border);
		label.setPrefWidth(width);
		label.setPrefHeight(height);
		
		return label;
	}
	
	public Background createLoginScreenBackgroundPicture() {
		
		Image image = new Image(sharedObjects.getGraph().getSlavFile().toString());
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		
		return background;
	}
	
	public TableView<ServerMenu> createServerTableView(){
		
		TableView<ServerMenu> serverListTableView = new TableView<>();
		serverListTableView.setPrefSize(358, 240);
		TableColumn<ServerMenu, String> coll_lp = new TableColumn<>();
		TableColumn<ServerMenu, String> coll_text = new TableColumn<>();
		TableColumn<ServerMenu, String> coll_ip = new TableColumn<>();
		TableColumn<ServerMenu, String> coll_base = new TableColumn<>();
		
		coll_lp.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLp()));
		coll_text.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAlias()));
		coll_ip.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getIp()));
		coll_base.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ServerMenu,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ServerMenu, String> param) {
				return new SimpleStringProperty(param.getValue().getBase());
//				return null;
			}
		});
		
		coll_lp.setPrefWidth(24);
		coll_text.setPrefWidth(84);
		coll_ip.setPrefWidth(104);
		coll_base.setPrefWidth(104);
		
		coll_lp.setText("lp");
		coll_text.setText("alias");
		coll_ip.setText("ip");
		coll_base.setText("baza");
		
		serverListTableView.getColumns().addAll(coll_lp, coll_text, coll_ip, coll_base);
		serverListTableView.getSelectionModel().selectedItemProperty().addListener((poz, n, o) -> sharedObjects.getDbconn().setIp(poz.getValue().getIp()));
		serverListTableView.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().toString().equals("DELETE")) {					
					serverListTableView.getItems().remove(serverListTableView.getSelectionModel().getSelectedIndex());
				}
			}
		});
		
		serverListTableView.setEditable(true);
		
		return serverListTableView;
	}
	
}
