package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import pl.manester.app.SharedObjects;

public class AdhocQuery extends Application{
	
	private SharedObjects sharedObjects;
	private String itNum;
	
	public AdhocQuery(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane menuPane = new Pane();
		Label menuLabel = new Label("Menu");
		menuPane.getChildren().addAll(menuLabel);
		
		Statement statement = sharedObjects.getDbconn().getConn().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from its order by lp asc;");
		
		TreeItem<String>treeItem = new TreeItem<>("MENU");
		
		String rowType = new String();

		while(resultSet.next()) {
			rowType = resultSet.getString(6);
			itNum = resultSet.getString(2);
			
			if (rowType.equals("i") ) {
				treeItem.getChildren().add(new TreeItem<>(itNum + " " + resultSet.getString(3)));
			}else if (rowType.equals("p")){
				for(TreeItem<String> tr : treeItem.getChildren()) {
					if (tr.getValue().toString().substring(0, 4).equals(resultSet.getString(2))) {
						tr.getChildren().add(new TreeItem<String>(resultSet.getString(4) ));
						tr.setGraphic(null);
						itNum = resultSet.getString(2);
					}
				}
			}
		}
		
		treeItem.setExpanded(true);
		
		TreeView<String> tree = new TreeView<>(treeItem);
		tree.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {

		    @Override
		    public TreeCell<String> call(TreeView<String> param) {

		         TreeCell<String> treeCell = new TreeCell<String>() {

		            @Override
		            protected void updateItem(String item, boolean empty) {
		                super.updateItem(item, empty);
		                if (empty || item == null) {
		                    setText(null);
		                    setGraphic(null);
		                } else if (item == "MENU") {
							setText(item);
							setGraphic(null);
						}else if (getGraphic()==null){
		                    setText(null);
		                    setGraphic(sharedObjects.getPreparedObjects().createLeaf(item, itNum));
		                
						}
		            }
		        };
		        
		        return treeCell;
		    }
		});
		
		resultSet.close();
		
		tree.setPrefSize(380, 512);
		Pane pane = new Pane();
		pane.setPrefSize(1256, 1024);
		pane.getChildren().add(tree);
		
		Scene scene = new Scene(pane);
		
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));
//		
		primaryStage.setHeight(1024);
		primaryStage.setWidth(1256);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
