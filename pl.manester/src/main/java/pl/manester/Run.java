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
import pl.manester.gui.PreparedGuiObjects;
import pl.manester.gui.Graph;
import pl.manester.gui.Gui;
import pl.manester.gui.events.CEventHandler;
import pl.manester.gui.events.CKeyPressedEventHandler;
import pl.manester.gui.events.CMouseEventHandler;
import pl.manester.gui.events.EventActions;
import pl.manester.gui.events.Events;
import pl.manester.gui.events.LoginScreenActionEvents;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		SharedObjects sharedObjects = new SharedObjects();
		DBCon dbcon = new DBCon(sharedObjects);
		sharedObjects.setDbconn(dbcon);
		Events events = new Events(sharedObjects);
		sharedObjects.setEvents(events);
		EventActions eventActions = new EventActions(sharedObjects);
		sharedObjects.setEventActions(eventActions);
		PreparedGuiObjects preparedObjects = new PreparedGuiObjects(sharedObjects);
		sharedObjects.setPreparedObjects(preparedObjects);
		AuxPreperdObjects auxPreperdObjects = new AuxPreperdObjects(sharedObjects);
		sharedObjects.setAuxPreperdObjects(auxPreperdObjects);
		Graph graph = new Graph(sharedObjects);
		sharedObjects.setGraph(graph);
		MainAppScreen mainAppScreen = new MainAppScreen(sharedObjects);
		sharedObjects.setMainAppScreen(mainAppScreen);
		MenuLeafActions menuLeafActions = new MenuLeafActions(sharedObjects);
		sharedObjects.setMenuLeafActions(menuLeafActions);
		LoginScreen loginScreen = new LoginScreen(sharedObjects);
		sharedObjects.setLoginScreen(loginScreen);
		LoginScreenActionEvents loginScreenActionEvents = new LoginScreenActionEvents(sharedObjects);
		sharedObjects.setLoginScreenActionEvents(loginScreenActionEvents);
		CMouseEventHandler cMouseEventHandler = new CMouseEventHandler(sharedObjects);
		sharedObjects.setcMouseEventHandler(cMouseEventHandler);
		CKeyPressedEventHandler cKeyPressedEventHandler = new CKeyPressedEventHandler(sharedObjects);
		sharedObjects.setcKeyPressedEventHandler(cKeyPressedEventHandler);
		CEventHandler cEventHandler = new CEventHandler(sharedObjects);
		sharedObjects.setcEventHandler(cEventHandler);
		Gui gui = new Gui(sharedObjects);
		sharedObjects.setGui(gui);
		
				
		sharedObjects.setTestMode(false);
		
		REGPanel regPanel = new REGPanel(sharedObjects);
					sharedObjects.setRegPanel(regPanel);;
					
//		LoginScreen loginScreen = new LoginScreen(sharedObjects);
		MainAppScreen mainMenu = new MainAppScreen(sharedObjects);
		
		Platform.startup(new Runnable() {
				@Override
				public void run() {
					
					try {
						loginScreen.start(new Stage());
//						regPanel.start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
