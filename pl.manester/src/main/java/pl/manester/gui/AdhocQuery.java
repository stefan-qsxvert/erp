package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
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

//		Leaf leaf = new Leaf();
		
		Pane menuPane = new Pane();
		Label menuLabel = new Label("Menu");
		menuPane.getChildren().addAll(menuLabel);
		
		Statement statement = sharedObjects.getDbconn().getConn().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from its;");
		
		TreeItem<String> item= new TreeItem<>("MENU");
		
		String rowType = new String();
		while(resultSet.next()) {
			rowType=resultSet.getString(6);
			
			if (rowType.equals("i") ) {
				item.getChildren().add(new TreeItem<>(resultSet.getString(2) + " " + resultSet.getString(3)));
			}else if (rowType.equals("p")){
				for(TreeItem<String> tr : item.getChildren()) {
//					System.out.println(tr.getValue().toString().substring(0, 4));
					if (tr.getValue().toString().substring(0, 4).equals(resultSet.getString(2))) {
						tr.getChildren().add(new TreeItem<String>(resultSet.getString(5)  + " " + resultSet.getString(4)));
					}
				}
			}
		}
		
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
		                } else if (item == "MENU") {
							setText(item);
							setGraphic(null);
						}else {
		                    setText(null);
		                    setGraphic(sharedObjects.getPreparedObjects().createLeaf(item));
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
