package pl.manester.gui;


import org.w3c.dom.events.EventException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
import pl.manester.app.SharedObjects;

public class MainMenu extends Application{

	SharedObjects sharedObjects;
	
	public MainMenu(SharedObjects sharedObjects) {
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
		
				
		BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT);
		Border border = new Border(borderStroke);
		Menu menu = new Menu();
		
		Pane graph = new Pane();
		graph.setBackground(slavBackground);
		
		graph.setPrefSize(820,860);
		graph.setLayoutY(36);
//		graph.setBorder(border);
		graph.setLayoutX(420);
		
		TreeItem<LeafMain> br0 = new TreeItem<>(new LeafMain("Menu","60"));
		br0.setExpanded(true);
		TreeItem<LeafMain> treeItem0 = new TreeItem<>(new LeafMain("123", "61"));
		TreeItem<LeafMain> treeItem1 = new TreeItem<>(new LeafMain("234","62"));
		TreeItem<LeafMain> treeItem2 = new TreeItem<>(new LeafMain("345", "63"));
		
		br0.getChildren().addAll(
						treeItem0,
						treeItem1,
						treeItem2
				);
		
		TreeView<LeafMain> tree = new TreeView<>(br0);
		tree.setPrefWidth(408);
		tree.setPrefHeight(820);
		tree.setLayoutX(4);
		tree.setLayoutY(36);
		
		tree.setOnMouseClicked(ev -> {if (ev.getClickCount()==2) {
			try {
			System.out.println(tree.getSelectionModel().getSelectedItem().getValue().getId());
//			System.out.println(ev.getSource());
			}catch(Exception e) {
				
			}
			}
		});
		
		// test click count
		tree.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		    private int counter = 0;

		    @Override
		    public void handle(MouseEvent event) {
		        counter++;
		        System.out.println("Kliknięć: " + counter);
		    }
		});
		//------------------
		
		Pane pane = new Pane();
		pane.getChildren().addAll(
				graph,
				licence,
				tree
				);
		
		
		Scene scene = new Scene(pane);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
}
