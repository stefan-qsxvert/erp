package pl.manester.gui.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.manester.app.SharedObjects;
import pl.manester.gui.ServerMenu;

public class CActionEvent implements EventHandler<ActionEvent>{

	SharedObjects sharedObjects;

	public CActionEvent(SharedObjects sharedObjects) {
		super();
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void handle(ActionEvent event) {
		
		TextField addServerTextField = sharedObjects.getLoginScreen().getAddServerTextField();
		TableView<ServerMenu> serverListTableView = sharedObjects.getLoginScreen().getServerListTableView();
		try {
			String[] newPoz = addServerTextField.getText().split(";");
			serverListTableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2], newPoz[3]));
			addServerTextField.clear();
			sharedObjects.getEventActions().writeLastUserAndServerList(addServerTextField, serverListTableView);
			}catch(Exception e) {
			
			}
		
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
