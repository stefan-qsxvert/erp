package pl.manester.gui.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

//		Stage stage = sharedObjects.getLoginScreen().getPrimaryStage();
				
//		sharedObjects.getLoginScreenActionEvents().loginActions(stage);
		if (sharedObjects.getDbconn().getConnectionState()) {
		sharedObjects.getLoginScreen().getPrimaryStage().hide();
		sharedObjects.getGui().mainAppScreenStart();
		}else {
			
		}
		
		eventActions.writeLastUserAndServerList(
				sharedObjects.getLoginScreen().getUserTextField(),
				sharedObjects.getLoginScreen().getServerListTableView()
				);
		
	}
	
	

}
