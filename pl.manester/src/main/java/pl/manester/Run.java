package pl.manester;

import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.DBCon;
import pl.manester.app.SharedObjects;
import pl.manester.gui.EventActions;
import pl.manester.gui.Events;
import pl.manester.gui.Gui;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		SharedObjects sharedObjects = new SharedObjects();
		DBCon dbcon = new DBCon(sharedObjects);
		sharedObjects.setDbconn(dbcon);
		Events events = new Events(sharedObjects);
		sharedObjects.setEvents(events);
		EventActions eventActions = new EventActions(sharedObjects);
		sharedObjects.setEventActions(eventActions);
		
			Platform.startup(new Runnable() {
				@Override
				public void run() {
					Gui gui = new Gui(sharedObjects);
					sharedObjects.setGui(gui);
					Stage primStage = new Stage();
					try {
						gui.start(primStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
