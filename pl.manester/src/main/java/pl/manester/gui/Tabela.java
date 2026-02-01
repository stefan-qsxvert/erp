package pl.manester.gui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import pl.manester.app.Osoba;

public class Tabela {
	
	private TableView<Osoba> tabela;
	private String Nazwisko;
	private String Imie;
	
	public Tabela() {
		
	}
	
	public void createTable() {
		
	tabela = new TableView<Osoba>();
	
	TableColumn<Osoba, String> col0 = new TableColumn<Osoba, String>();
	TableColumn<Osoba, String> col1 = new TableColumn<Osoba, String>();
	
	col0.setCellValueFactory( data -> data.getValue().getNazwisko());
	col1.setCellValueFactory( data -> data.getValue().getImie());
	
	tabela.getItems().add(new Osoba("Jan", "Kowalski")); 
	tabela.getItems().add(new Osoba("Anna", "Nowak"));
	
	tabela.getColumns().addAll(col0,col1);
	
	tabela.setEditable(true);
	
	col0.setEditable(true);
	
	col0.setCellFactory(TextFieldTableCell.forTableColumn());
	col1.setCellFactory(TextFieldTableCell.forTableColumn());
	
	col0.setOnEditCommit(event -> { 
		Osoba osoba = event.getRowValue(); 
		osoba.getNazwisko().set(event.getNewValue()); 
		});
	
	}

	public TableView<Osoba> getTabela() {
		return tabela;
	}

	public void setTabela(TableView<Osoba> tabela) {
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
