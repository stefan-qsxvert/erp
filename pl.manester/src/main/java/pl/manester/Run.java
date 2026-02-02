package pl.manester;

import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import pl.manester.app.DBCon;
import pl.manester.app.SharedObjects;
import pl.manester.gui.Gui;

public class Run {
	
	public static void main(String[] args) throws Exception {
		
		SharedObjects obiekty = new SharedObjects();
		DBCon dbcon = new DBCon(obiekty);
		obiekty.setDbconn(dbcon);
		
				
		
//		public void newLaunch() {
			Platform.startup(new Runnable() {
				@Override
				public void run() {
					Gui gui = new Gui(obiekty);
					obiekty.setGui(gui);
					Stage primStage = new Stage();
					obiekty.setStage(primStage);
					try {
						gui.start(primStage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
