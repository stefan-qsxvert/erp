package pl.manester.gui;

import com.sun.tools.javac.comp.Enter;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTableCell;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;
import pl.manester.events.CellEventHandler;

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
		przycisk.setMaxSize(196,36);
		przycisk.setLayoutX(layoutX);
		przycisk.setLayoutY(layoutY);
		return przycisk;
	}
	public TextField createTextField(String text, Integer layoutX, Integer layoutY) {
		
		TextField textField = new TextField();
		textField.setPromptText(text);
//		textField.setPrefWidth(164);
		textField.setLayoutX(layoutX);
		textField.setMaxHeight(layoutY);
		textField.setMaxSize(196, 36);
		return textField;
	}
	
	public PasswordField createPasswordField(String password, Integer layoutX, Integer layoutY) {
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText(password);
		passwordField.setMaxSize(196, 36);
		passwordField.setLayoutX(layoutX);
		passwordField.setLayoutY(layoutY);
		passwordField.setOnAction(ev -> {
			sharedObjects.getDbconn().connectDB();
			sharedObjects.getEventActions().fillTable();
			sharedObjects.getDbconn().disconnectDB();
		});
		return passwordField;
	}
	
	public TableView<Person> createPersonTableView(Integer layoutX, Integer layoutY) {
		
		TableView<Person> tableView = new TableView<>();
		
		TableColumn<Person, String> col0 = new TableColumn<Person, String>();
		TableColumn<Person, String> col1 = new TableColumn<Person, String>();
		TableColumn<Person, String> col2 = new TableColumn<Person, String>();
		TableColumn<Person, String> col3 = new TableColumn<Person, String>();
		
		col0.setCellValueFactory( data -> data.getValue().getNumber());
		col1.setCellValueFactory( data -> data.getValue().getNazwisko());
		col2.setCellValueFactory( data -> data.getValue().getImie());
		
		col0.setMinWidth(24);
		col0.setMaxWidth(24);
		col1.setMinWidth(124);
		col2.setMinWidth(124);
		
		col0.setText("Lp");
		col1.setText("Nazwisko");
		col2.setText("Imię");
		
		
		col0.setOnEditCommit(new CellEventHandler(sharedObjects, "0"));
		col1.setOnEditCommit(new CellEventHandler(sharedObjects, "1"));
		col2.setOnEditCommit(new CellEventHandler(sharedObjects, "2"));

		
		tableView.getColumns().addAll(col0,col1,col2);
		 
		tableView.setEditable(true);
		
		col0.setCellFactory(TextFieldTableCell.forTableColumn());
		col1.setCellFactory(TextFieldTableCell.forTableColumn());
		col2.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView.setMinSize(274, 580);
		tableView.setMaxSize(274, 580);
		tableView.setLayoutX(layoutX);
		tableView.setLayoutY(layoutY);
		
		return tableView;
	}
	
	public TreeView<String> createTreeMenu(){
		TreeItem<String> root = new TreeItem<>("Menu"); 
		root.setExpanded(true);
		
		TreeItem<String> file = new TreeItem<>("Plik"); 
		TreeItem<String> edit = new TreeItem<>("Edycja"); 
		TreeItem<String> view = new TreeItem<>("Widok"); 
		// podmenu 
		file.getChildren().addAll( new TreeItem<>("Nowy"), new TreeItem<>("Otwórz"), new TreeItem<>("Zapisz") ); 
		edit.getChildren().addAll( new TreeItem<>("Kopiuj"), new TreeItem<>("Wklej") ); 
		view.getChildren().addAll( new TreeItem<>("Powiększ"), new TreeItem<>("Pomniejsz") ); 
		// dodanie do korzenia 
		root.getChildren().addAll(file, edit, view); 
		TreeView<String> treeView = new TreeView<>(root);
		treeView.setLayoutX(4);
		treeView.setLayoutY(48);
		treeView.setPrefWidth(200); 
		treeView.setPrefHeight(300); 
		treeView.setShowRoot(true);
		
		return treeView;
	}
	public TreeView<Button> createTreeButtonMenu(){
		TreeItem<Button> root = new TreeItem<>(new Button()); 
		root.setExpanded(true);
		
		TreeItem<Button> file = new TreeItem<>(new Button("0")); 
		TreeItem<Button> edit = new TreeItem<>(new Button("1")); 
		TreeItem<Button> view = new TreeItem<>(new Button("2")); 
		// podmenu 
		file.getChildren().addAll( new TreeItem<>(new Button()), new TreeItem<>(new Button()), new TreeItem<>(new Button())); 
		edit.getChildren().addAll( new TreeItem<>(new Button()), new TreeItem<>(new Button()), new TreeItem<>(new Button())); 
		view.getChildren().addAll( new TreeItem<>(new Button()), new TreeItem<>(new Button()), new TreeItem<>(new Button()));
		// dodanie do korzenia 
		root.getChildren().addAll(file, edit, view); 
		TreeView<Button> treeView = new TreeView<>(root);
		treeView.setLayoutX(4);
		treeView.setLayoutY(48);
		treeView.setPrefWidth(200); 
		treeView.setPrefHeight(300); 
		treeView.setShowRoot(true);
		
		return treeView;
	}
}
