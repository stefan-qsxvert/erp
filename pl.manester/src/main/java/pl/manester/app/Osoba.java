package pl.manester.app;

import javafx.beans.property.SimpleStringProperty;

public class Osoba {

	private SimpleStringProperty Nazwisko = new SimpleStringProperty();
	private SimpleStringProperty Imie = new SimpleStringProperty();
	
	public Osoba( String Imie, String Nazwisko) {
		this.Nazwisko.set(Nazwisko);
		this.Imie.set(Imie);

	}
	
	public SimpleStringProperty getNazwisko() {
		return Nazwisko;
	}
	public void setNazwisko(SimpleStringProperty nazwisko) {
		Nazwisko = nazwisko;
	}
	public SimpleStringProperty getImie() {
		return Imie;
	}
	public void setImię(SimpleStringProperty imie) {
		Imie = imie;
	}

}
