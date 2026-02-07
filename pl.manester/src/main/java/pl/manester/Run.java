package pl.manester;

import java.net.PortUnreachableException;

import org.apache.maven.properties.internal.SystemProperties;

import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.DBCon;
import pl.manester.app.SharedObjects;
import pl.manester.events.EventActions;
import pl.manester.events.Events;
import pl.manester.gui.AuxPreperdObjects;
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
		AuxPreperdObjects auxPreperdObjects = new AuxPreperdObjects(sharedObjects);
		sharedObjects.setAuxPreperdObjects(auxPreperdObjects);
				
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
