package pl.manester.gui.events;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class CMouseEventHandler implements EventHandler<MouseEvent>{
	
	SharedObjects sharedObjects;
	
	public CMouseEventHandler(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	@Override
	public void handle(MouseEvent event) {
		System.out.println(event.getSource().toString().contains("id=11"));
		String user = sharedObjects.getLoginScreen().getUserTextField().getText();
		String passDB = sharedObjects.getLoginScreen().getPasswordField().getText();
		Stage stage = sharedObjects.getLoginScreen().getPrimaryStage();
		
		sharedObjects.getLoginScreenActionEvents().loginActions(stage, user, passDB);
	}
	
	

}
