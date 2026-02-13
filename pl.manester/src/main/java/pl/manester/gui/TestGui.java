package pl.manester.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestGui extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		Leaf leaf = new Leaf();
		
		TreeItem<Pane> item= new TreeItem<>(new Pane());
		TreeItem<Pane> item1= new TreeItem<>(leaf.createLeaf());
		TreeItem<Pane> item2= new TreeItem<>(leaf.createLeaf());
		TreeItem<Pane> item3= new TreeItem<>(leaf.createLeaf());
		
		
		item.getChildren().addAll(item1, item2, item3);
		
		TreeView<Pane> tree = new TreeView<>(item);
		tree.setPrefSize(620, 212);

		Pane pane = new Pane();
		pane.setPrefSize(640, 260);
		pane.getChildren().add(tree);
		
		Scene scene = new Scene(pane);
//		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
