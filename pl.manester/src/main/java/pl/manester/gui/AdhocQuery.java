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
		
		TreeItem<LeafData> treeItem = new TreeItem<>(new LeafData("MENU", "00"));
		
		String rowType = new String();

		while(resultSet.next()) {
			rowType = resultSet.getString(6);
			itNum = resultSet.getString(2);
			
			if (rowType.equals("i") ) {
				treeItem.getChildren().add(new TreeItem<LeafData>( new LeafData(itNum + " " + resultSet.getString(3), itNum) ));
			}else if (rowType.equals("p")){
				for(TreeItem<LeafData> tr : treeItem.getChildren()) {
					if (tr.getValue().toString().substring(0, 4).equals(resultSet.getString(2))) {
						tr.getChildren().add(new TreeItem<LeafData>(new LeafData(resultSet.getString(4), resultSet.getString(2))));
						tr.setGraphic(null);
					}
				}
			}
		}
		
		treeItem.setExpanded(true);
		
		TreeView<LeafData> tree = new TreeView<>(treeItem);
		tree.setCellFactory(new Callback<TreeView<LeafData>, TreeCell<LeafData>>() {

		    @Override
		    public TreeCell<LeafData> call(TreeView<LeafData> param) {

		         TreeCell<LeafData> treeCell = new TreeCell<LeafData>() {

		            @Override
		            protected void updateItem(LeafData item, boolean empty) {
		            	
		                super.updateItem(item, empty);
		                if (empty || item == null) {
		                    setText(null);
		                    setGraphic(null);
		                } else if (item.getName() == "MENU") {
							setText(item.getName());
							setGraphic(null);
						}else if (getGraphic()==null){
		                    setText(null);
		                    setGraphic(sharedObjects.getPreparedObjects().createLeaf(item.getId()));
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
