package pl.manester;

import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.DBCon;
import pl.manester.app.SharedObjects;
import pl.manester.gui.AuxPreperdObjects;
import pl.manester.gui.Gui;
import pl.manester.gui.LoginScreen;
import pl.manester.gui.PreparedObjects;
import pl.manester.gui.Graph;
import pl.manester.gui.events.EventActions;
import pl.manester.gui.events.Events;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		SharedObjects sharedObjects = new SharedObjects();
		DBCon dbcon = new DBCon(sharedObjects);
		sharedObjects.setDbconn(dbcon);
		Events events = new Events(sharedObjects);
		sharedObjects.setEvents(events);
		EventActions eventActions = new EventActions(sharedObjects);
		PreparedObjects preparedObjects = new PreparedObjects(sharedObjects);
		sharedObjects.setPreparedObjects(preparedObjects);
		sharedObjects.setEventActions(eventActions);
		AuxPreperdObjects auxPreperdObjects = new AuxPreperdObjects(sharedObjects);
		Graph graph = new Graph(sharedObjects);
		sharedObjects.setGraph(graph);
				
		Platform.startup(new Runnable() {
				@Override
				public void run() {
//					Gui gui = new Gui(sharedObjects);
//					sharedObjects.setGui(gui);
//					Stage primStage = new Stage();
					LoginScreen loginScreen = new LoginScreen(sharedObjects);
					try {
//						gui.start(primStage);
						loginScreen.start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
