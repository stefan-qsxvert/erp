package pl.manester.gui;

import javafx.scene.control.Button;
import pl.manester.app.SharedObjects;

public class PreparedObjects {
	
	SharedObjects sharedObjects;
	
	public PreparedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public Button getButton(String text, String id) {
		Button przycisk =new Button();
		przycisk.setText(text);
		przycisk.setOnAction(sharedObjects.getEvents());
		przycisk.setId(id);
		return przycisk;
	}

}
