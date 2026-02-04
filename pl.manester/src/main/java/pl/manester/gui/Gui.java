package pl.manester.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
		
		TextField ip = preparedObjects.createTextField(4, 4);
		TextField user = preparedObjects.createTextField(200, 4);
		PasswordField passwordField = preparedObjects.createPasswordField(400, 1);
		
		TableView<Person> tabela = preparedObjects.createPersonTableView(4, 36);
		
		
		Button przycisk = preparedObjects.createButton("klik!", "connectDB", 420, 394);
		
		Pane root = new Pane();

		root.getChildren().addAll(tabela, ip, user,przycisk, passwordField);
		
//		Pane r2 = new StackPane();
//		r2.setMaxSize(96, 124);;
		
//		root.setAlignment(txt, Pos.TOP_LEFT);

				
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
