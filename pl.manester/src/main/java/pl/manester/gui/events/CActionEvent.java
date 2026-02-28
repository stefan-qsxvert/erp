package pl.manester.gui.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.manester.app.SharedObjects;

public class CActionEvent implements EventHandler<ActionEvent>{

	SharedObjects sharedObjects;

	public CActionEvent(SharedObjects sharedObjects) {
		super();
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void handle(ActionEvent event) {
		
//		switch () {
//		case value:
//			
//			break;
//
//		default:
//			break;
//		}
	}
	
	
}
