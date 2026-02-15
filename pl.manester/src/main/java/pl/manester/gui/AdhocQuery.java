package pl.manester.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class AdhocQuery extends Application{
	
	private SharedObjects sharedObjects;
	
	public AdhocQuery(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Leaf leaf = new Leaf();
		
		Pane menuPane = new Pane();
		Label menuLabel = new Label("Menu");
		menuPane.getChildren().addAll(menuLabel);
		
		TreeItem<Pane> item= new TreeItem<>(menuPane);
		TreeItem<Pane> item1= new TreeItem<>(leaf.createLeaf());
		TreeItem<Pane> item2= new TreeItem<>(leaf.createLeaf());
		TreeItem<Pane> item3= new TreeItem<>(leaf.createLeaf());
		
		item.getChildren().addAll(item1, item2, item3);
		item.setExpanded(true);
		
		TreeView<Pane> tree = new TreeView<>(item);
		
		tree.setPrefSize(320, 512);
		tree.setOpacity(50);
		Pane pane = new Pane();
		pane.setPrefSize(1460, 1024);
		pane.getChildren().add(tree);
		
		Scene scene = new Scene(pane);
//		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
