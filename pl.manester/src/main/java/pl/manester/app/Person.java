package pl.manester.app;

import javafx.beans.property.SimpleStringProperty;

public class Person {

	private SimpleStringProperty Number = new SimpleStringProperty();	
	private SimpleStringProperty Nazwisko = new SimpleStringProperty();
	private SimpleStringProperty Imie = new SimpleStringProperty();
	
	public Person(String number, String nazwisko, String imie) {
		super();
		this.Number.set(number);
		this.Nazwisko.set(nazwisko);
		this.Imie.set(imie);
	}

	public SimpleStringProperty getNumber() {
		return Number;
	}

	public void setNumber(SimpleStringProperty number) {
		Number = number;
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

	public void setImie(SimpleStringProperty imie) {
		Imie = imie;
	}
		
}
