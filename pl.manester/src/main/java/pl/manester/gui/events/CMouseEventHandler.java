package pl.manester.gui.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import pl.manester.app.SharedObjects;

public class CMouseEventHandler implements EventHandler<MouseEvent>{
	
	SharedObjects sharedObjects;
	EventActions eventActions;
	
	public CMouseEventHandler(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
		this.eventActions = new EventActions(sharedObjects);
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		Integer id_index = event.getSource().toString().indexOf("id=");
		String id = event.getSource().toString().substring(id_index);
		Integer id_size = id.indexOf(", ");
		id = id.substring(3,id_size);

		switch (id) {
		case "4":
				sharedObjects.getEventActions().loginToApp();
			break;

		default:
			break;
		}
	}
	
	

}
