package pl.manester.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;

public class Gui extends Application {
	
	PreparedObjects preparedObjects;
	private SharedObjects sharedObjects;
	private Events ev;

	
	public Gui(SharedObjects sharedObjects) {
		preparedObjects = new PreparedObjects(sharedObjects);
		this.sharedObjects = sharedObjects;
		ev = new Events(sharedObjects);
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
		
		TableView<Person> tabela = tab.getTabela();
		sharedObjects.setTabela(tabela);
		
		tabela.setMaxSize(360, 420);
		
		Button przycisk = preparedObjects.getButton("klik!", "connectDB");
		
		StackPane root = new StackPane();
		root.getChildren().addAll(tabela, txt,przycisk);
		StackPane r2 = new StackPane();
		r2.setMaxSize(96, 124);;
		
		root.setAlignment(txt, Pos.TOP_LEFT);
		root.setAlignment(przycisk, Pos.BOTTOM_RIGHT);
				
		Scene sc = new Scene(root, 260, 320);
//		Scene sc = new S
		
		primaryStage.setTitle("Moje okno");
		primaryStage.setScene(sc);
		primaryStage.setHeight(460);
		primaryStage.setWidth(640);
		primaryStage.show();
		
	}
	public SharedObjects getObiekty() {
		return sharedObjects;
	}
	public void setObiekty(SharedObjects obiekty) {
		this.sharedObjects = obiekty;
	}
	
}
