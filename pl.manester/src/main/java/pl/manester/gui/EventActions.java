package pl.manester.gui;

import pl.manester.app.SharedObjects;

public class EventActions {
	private SharedObjects sharedObjects;
	
	public EventActions(SharedObjects sharedObjects) {
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
