package pl.manester.gui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import pl.manester.app.SharedObjects;

public class AuxPreperdObjects {
	
	SharedObjects sharedObjects;
		
	public AuxPreperdObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public Label createMenuLabel(String text) {
		
		Image img = new Image(sharedObjects.getClass().getResource("/menuPosImg.jpg").toString());
		BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bcg = new Background(backgroundImage);
		Label label = new Label();
		
		label.setBackground(bcg);
		label.setMinSize(64, 16);
		label.setMaxSize(64, 16);
		label.setText(text);
		
		return label;		
	}

}
