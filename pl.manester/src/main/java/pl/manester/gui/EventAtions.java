package pl.manester.gui;

import java.sql.DriverManager;

import pl.manester.app.SharedObjects;

public class EventAtions {
	private SharedObjects sharedObjects;
	
	public EventAtions(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public void connectDB() {
		sharedObjects.getDbconn().connectDB();
	}
	
	public void fillTable() {
		
		
	}
	
	public void disconnectDB() {
		sharedObjects.getDbconn().disconnectDB();
	}
}
