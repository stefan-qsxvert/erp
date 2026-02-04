package pl.manester;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.DBCon;
import pl.manester.app.SharedObjects;
import pl.manester.gui.EventAtions;
import pl.manester.gui.Gui;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		SharedObjects sharedObjects = new SharedObjects();
		DBCon dbcon = new DBCon(sharedObjects);
		sharedObjects.setDbconn(dbcon);
		EventAtions eventAtions = new EventAtions(sharedObjects);
		sharedObjects.setEventAtions(eventAtions);
		
		
			Platform.startup(new Runnable() {
				@Override
				public void run() {
					Gui gui = new Gui(sharedObjects);
					sharedObjects.setGui(gui);
					Stage primStage = new Stage();
					sharedObjects.setStage(primStage);
					try {
						gui.start(primStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
