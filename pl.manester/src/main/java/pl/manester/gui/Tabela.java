package pl.manester.gui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import pl.manester.app.Person;

public class Tabela {
	
	private TableView<Person> tabela;
	private String Nazwisko;
	private String Imie;
	
	public Tabela() {
		
	}
	
	public void createTable() {
		
	tabela = new TableView<Person>();
	
	TableColumn<Person, String> col0 = new TableColumn<Person, String>();
	TableColumn<Person, String> col1 = new TableColumn<Person, String>();
	TableColumn<Person, String> col2 = new TableColumn<Person, String>();
	TableColumn<Person, String> col3 = new TableColumn<Person, String>();
	
	col0.setCellValueFactory( data -> data.getValue().getNumber());
	col1.setCellValueFactory( data -> data.getValue().getNazwisko());
	col2.setCellValueFactory( data -> data.getValue().getImie());
	
	
	tabela.getColumns().addAll(col0,col1,col2);
	 
	tabela.setEditable(true);
	
//	col0.setEditable(true);
	
	col0.setCellFactory(TextFieldTableCell.forTableColumn());
	col1.setCellFactory(TextFieldTableCell.forTableColumn());
	col2.setCellFactory(TextFieldTableCell.forTableColumn());
	
//	col0.setOnEditCommit(event -> { 
//		Osoba osoba = event.getRowValue(); 
//		osoba.getNazwisko().set(event.getNewValue()); 
//		});
//	
	}

	public TableView<Person> getTabela() {
		return tabela;
	}

	public void setTabela(TableView<Person> tabela) {
		this.tabela = tabela;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.Nazwisko = nazwisko;
	}

	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		this.Imie = imie;
	}
	
}
