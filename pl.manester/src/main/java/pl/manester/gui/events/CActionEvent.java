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

		Integer id_index = event.getSource().toString().indexOf("id=");
		String id = event.getSource().toString().substring(id_index);
		Integer id_size = id.indexOf(", ");
		id = id.substring(3,id_size);
		
		
			
		switch (id) {
		case "3":
			
			TextField addServerTextField = sharedObjects.getLoginScreen().getAddServerTextField();
			TableView<ServerMenu> serverListTableView = sharedObjects.getLoginScreen().getServerListTableView();
			if (addServerTextField!=null) {
				try {
					String[] newPoz = addServerTextField.getText().split(";");
					serverListTableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2], newPoz[3]));
					addServerTextField.clear();
					sharedObjects.getEventActions().writeLastUserAndServerList(addServerTextField, serverListTableView);
				}catch(Exception e) {
				
				}
			}
			break;
		default:
			break;
		}
	}
}
