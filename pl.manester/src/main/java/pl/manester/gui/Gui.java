package pl.manester.gui;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.manester.app.MainObjects;
import pl.manester.app.Osoba;

public class Gui extends Application {
	
	private MainObjects obiekty;
	private Events ev;
	private String tst;
	
	public Gui(MainObjects obiekty) {
		this.obiekty = obiekty;
		ev = new Events(obiekty);
		tst = "11";
	}
	
	public Gui() {
//		System.out.println(this);
	}
	
	public void run(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField txt = new TextField();
		txt.setPromptText("Wpisz coś");
		txt.setPrefWidth(164);
		txt.setMaxWidth(164);
		txt.setMaxHeight(24);
		
		Tabela tab = new Tabela();
		tab.createTable();
		
		TableView<Osoba> tabela = tab.getTabela();
		
		Button przycisk =new Button();
		przycisk.setText("Klik!");
		przycisk.setOnAction(ev);
		
		StackPane root = new StackPane();
		root.getChildren().addAll(tabela, txt,przycisk);
		
		root.setAlignment(txt, Pos.TOP_LEFT);
		root.setAlignment(przycisk, Pos.BOTTOM_RIGHT);
		
		Scene sc = new Scene(root);
		
		primaryStage.setTitle("Moje okno");
		primaryStage.setScene(sc);
		primaryStage.setHeight(460);
		primaryStage.setWidth(640);
		primaryStage.show();
		
	}
	public MainObjects getObiekty() {
		return obiekty;
	}
	public void setObiekty(MainObjects obiekty) {
		this.obiekty = obiekty;
	}
	
}
