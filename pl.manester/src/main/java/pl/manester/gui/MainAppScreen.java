package pl.manester.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pl.manester.app.SharedObjects;

public class MainAppScreen extends Application{

	SharedObjects sharedObjects;
	String id0 = "", id1 = "";
	
	public MainAppScreen(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Image slav = new Image(sharedObjects.getGraph().getSlav_main().toString());
		
		BackgroundImage bcg = new BackgroundImage(slav, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background slavBackground = new Background(bcg);
		
		primaryStage.setHeight(980);
		primaryStage.setWidth(1256);
		
		Label licence = new Label("Wszystkie prawa zastrzeżone");
		licence.setLayoutX((primaryStage.getWidth()/2-36));
		licence.setLayoutY(primaryStage.getHeight() - 64);
			
		Pane graph = new Pane();
		graph.setBackground(slavBackground);
		
		graph.setPrefSize(820,860);
		graph.setLayoutY(36);
//		graph.setBorder(border);
		graph.setLayoutX(420);
		
		TreeItem<LeafData> br0 = new TreeItem<>(new LeafData("Menu","60"));
		br0.setExpanded(true);
		TreeItem<LeafData> treeItem0 = new TreeItem<>(new LeafData("Reg panel", "10"));
		TreeItem<LeafData> treeItem1 = new TreeItem<>(new LeafData("Adhoc query","20"));
		TreeItem<LeafData> treeItem2 = new TreeItem<>(new LeafData("345", "63"));
		
		br0.getChildren().addAll(
						treeItem0,
						treeItem1,
						treeItem2
				);
		
		TreeView<LeafData> tree = new TreeView<>(br0);
		tree.setPrefWidth(408);
		tree.setPrefHeight(820);
		tree.setLayoutX(4);
		tree.setLayoutY(36);
		

		tree.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		    private int counter = 0;

		    @Override
		    public void handle(MouseEvent event) {
		        counter++;
		        
		        switch (counter) {
		        case 1:
		        	id0 = tree.getSelectionModel().selectedItemProperty().getValue().getValue().getId();
		        	break;
		        case 2:
		        	id1 = tree.getSelectionModel().selectedItemProperty().getValue().getValue().getId();
		        	counter = 0;
		         	break;
		         default:
		        	 break;
		        }
	
		        if (id0 == id1) {
		        	
	        
		        	switch (id0) {
		        	case "10":
		        		sharedObjects.getMenuLeafActions().runREGPanel();
		        		break;
		        	case "20":
		        		sharedObjects.getMenuLeafActions().runAdhocQuery();
		        		break;
		        	}
		        }}
		});
		//------------------
		
		Pane pane = new Pane();
		pane.getChildren().addAll(
				graph,
				licence,
				tree
				);
		
		
		Scene scene = new Scene(pane);
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				sharedObjects.getDbconn().disconnectDB();	}
		});
		
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
}
