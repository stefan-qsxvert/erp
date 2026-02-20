package pl.manester;

import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.SharedObjects;
import pl.manester.base.DBCon;
import pl.manester.gui.AuxPreperdObjects;
import pl.manester.gui.REGPanel;
import pl.manester.gui.LoginScreen;
import pl.manester.gui.MainAppScreen;
import pl.manester.gui.MenuLeafActions;
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
		sharedObjects.setAuxPreperdObjects(auxPreperdObjects);
		Graph graph = new Graph(sharedObjects);
		sharedObjects.setGraph(graph);
		MainAppScreen mainAppScreen = new MainAppScreen(sharedObjects);
		sharedObjects.setMainAppScreen(mainAppScreen);
		MenuLeafActions menuLeafActions = new MenuLeafActions(sharedObjects);
		sharedObjects.setMenuLeafActions(menuLeafActions);
				
		sharedObjects.setTestMode(false);
		
		Platform.startup(new Runnable() {
				@Override
				public void run() {
					REGPanel gui = new REGPanel(sharedObjects);
					sharedObjects.setGui(gui);
					
					LoginScreen loginScreen = new LoginScreen(sharedObjects);
					MainAppScreen mainMenu = new MainAppScreen(sharedObjects);
					
//					AdhocQuery testGui = new AdhocQuery(sharedObjects);
					try {
//						mainMenu.start(new Stage());
						loginScreen.start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
