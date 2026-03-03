package pl.manester.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.manester.gui.Graph;
import pl.manester.gui.PreparedGuiObjects;

public class TestScreen extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		SharedObjects sharedObjects = new SharedObjects();
		Graph graph = new Graph(sharedObjects);
		sharedObjects.setGraph(graph);
		PreparedGuiObjects preparedGuiObjects = new PreparedGuiObjects(sharedObjects);
		
		TreeCell<String> trC = new TreeCell<>();
		
		trC.setGraphic(preparedGuiObjects.createLeaf("a25","Agd"));
		
		
		
		TreeItem<String> trI = new TreeItem<String>();
		TreeItem<String> trII = new TreeItem<String>();
		trII.setGraphic(preparedGuiObjects.createLeaf("sddd", "SD"));
		
		trI.getChildren().add(trII);
		
		
		TreeView<String> trV = new TreeView<String>(trI);
		Pane pn = new Pane();
		pn.getChildren().add(trV);
		Scene sc = new Scene(pn);
		primaryStage.setScene(sc);
		primaryStage.setWidth(720);
		primaryStage.setHeight(480);
		primaryStage.show();
		
		
	}
	

}
