package pl.manester.gui.events;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.manester.app.SharedObjects;

public class Events implements EventHandler<ActionEvent>{
	
	private SharedObjects sharedObjects;
	
	public Events(SharedObjects sharedObjects) {
//		super();
		this.sharedObjects = sharedObjects;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		
		/*
		String c = actionEvent.getSource().toString();
		
		if (c.contains("connectDB")) {
			sharedObjects.setEventCase("connectDB");
		}
		if (c.contains("disconnectDB")) {
			sharedObjects.setEventCase("disconnectDB");
		}
		if (c.contains("fillTab")) {
			sharedObjects.setEventCase("fillTab");
		}

		switch (sharedObjects.getEventCase()) {
		
		case "connectDB":
			sharedObjects.getDbconn().connectDB();
//			System.out.println(sharedObjects.getDbconn().getConnectionState());
			if (sharedObjects.getDbconn().getConnectionState()) {
//			sharedObjects.getGui().getButton().setId("fillTab");
//			sharedObjects.getGui().getButton().setText("Wypełnij_tabelę");
			}
			break;
			
		case "fillTab":
			sharedObjects.getEventActions().fillTable();
//			System.out.println(sharedObjects.getDbconn().getConnectionState());
//			sharedObjects.getGui().getButton().setId("disconnectDB");
//			sharedObjects.getGui().getButton().setText("RozłączDB");
			break;
			
		case "disconnectDB":
			sharedObjects.getEventActions().disconnectDB();
//			System.out.println(sharedObjects.getDbconn().getConnectionState());
//			sharedObjects.getGui().getButton().setId("connectDB");
//			sharedObjects.getGui().getButton().setText("PołączDB");
			break;
			
		default:
			break;
		}
*/
	}
	
}
