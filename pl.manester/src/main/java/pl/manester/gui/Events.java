package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;

public class Events implements EventHandler<ActionEvent>{
	
	private SharedObjects sharedObjects;
	
	public Events(SharedObjects sharedObjects) {
//		super();
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		String c = actionEvent.getSource().toString();
		
		if (c.contains("connectDB")) {
			sharedObjects.setEventCase("connectDB");
		}
		if (c.contains("disconnectDB")) {
			sharedObjects.setEventCase("disconnectDB");
		}

		switch (sharedObjects.getEventCase()) {
		
		case "connectDB":
			sharedObjects.getEventActions().connectDB();
			System.out.println(sharedObjects.getDbconn().getConnectionState());
			break;
			
		case "disconnectDB":
			sharedObjects.getEventActions().disconnectDB();
			System.out.println(sharedObjects.getDbconn().getConnectionState());
			break;
		default:
			break;
		}

	}
}
