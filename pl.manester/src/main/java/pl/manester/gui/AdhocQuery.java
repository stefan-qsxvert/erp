package pl.manester.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
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
		
		TreeItem<String> item= new TreeItem<>("op1");
		TreeItem<String> item1= new TreeItem<>("op2");
		TreeItem<String> item2= new TreeItem<>("op3");
		TreeItem<String> item3= new TreeItem<>("op4");
		
		item.getChildren().addAll(item1, item2, item3);
		item.setExpanded(true);
		
		TreeView<String> tree = new TreeView<>(item);
		
		tree.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {

		    @Override
		    public TreeCell<String> call(TreeView<String> param) {

		        return new TreeCell<String>() {

		            @Override
		            protected void updateItem(String item, boolean empty) {
		                super.updateItem(item, empty);

		                if (empty || item == null) {
		                    setText(null);
		                    setGraphic(null);
		                } else {
		                    setText(item);
		                    setGraphic(sharedObjects.getPreparedObjects().createLeaf());
		                }
		            }
		        };
		    }
		});
		
		tree.setPrefSize(320, 512);
		Pane pane = new Pane();
		pane.setPrefSize(1256, 1024);
		pane.getChildren().add(tree);
		
		Scene scene = new Scene(pane);
//		
		primaryStage.setHeight(1024);
		primaryStage.setWidth(1256);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
