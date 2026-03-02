package pl.manester.gui.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
import pl.manester.app.SharedObjects;
import pl.manester.gui.ServerMenu;

public class CEventHandler implements EventHandler<ActionEvent>{

	SharedObjects sharedObjects;

	public CEventHandler(SharedObjects sharedObjects) {
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
		case "2":
				sharedObjects.getEventActions().loginToApp();
			break;
		case "3":
			sharedObjects.getEventActions().addServerToTableView();
			break;
		default:
			break;
		}
	}
}
