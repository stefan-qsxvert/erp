package pl.manester.gui;

import javax.swing.border.StrokeBorder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class LoginScreen extends Application{
	
	private SharedObjects sharedObjects;
	
	public LoginScreen(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		PreparedObjects preparedObjects = sharedObjects.getPreparedObjects();
		Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

		primaryStage.setHeight(368);
		primaryStage.setWidth(580);
		primaryStage.getIcons().add(new Image(sharedObjects.getGraph().getLogoFile().toString(), false));

		Label server = new Label("server");
		server.setLayoutX(196);
		server.setLayoutY(34);
		server.setBorder(border);
		server.setPrefWidth(360);
		server.setPrefHeight(24);
		
		Pane pn0 = new Pane();
		pn0.setBorder(border);
		pn0.setPrefSize(360, 240);
		pn0.setLayoutX(196);
		pn0.setLayoutY(68);
		
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		pane.getChildren().addAll(
				preparedObjects.createTextField("login", 34, 34),
				preparedObjects.createPasswordField("hasło", 34, 68),
				pn0,
				server
				);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

}
