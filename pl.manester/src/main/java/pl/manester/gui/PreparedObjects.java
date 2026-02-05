package pl.manester.gui;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import jdk.javadoc.internal.doclets.formats.html.taglets.ReturnTaglet;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;

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
		passwordField.setMaxSize(360, 36);
		passwordField.setLayoutX(layoutX);
		passwordField.setLayoutY(layoutY);
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
		
		
		tableView.getColumns().addAll(col0,col1,col2);
		 
		tableView.setEditable(true);
		
		col0.setCellFactory(TextFieldTableCell.forTableColumn());
		col1.setCellFactory(TextFieldTableCell.forTableColumn());
		col2.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableView.setMaxSize(360, 720);
		tableView.setLayoutX(layoutX);
		tableView.setLayoutY(layoutY);
		
		return tableView;
	}
}
