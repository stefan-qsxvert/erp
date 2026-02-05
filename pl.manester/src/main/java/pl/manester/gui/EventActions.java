package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import pl.manester.app.Person;
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
	
		try {
//			sharedObjects.getDbconn().connectDB();
			
			ResultSet rs = sharedObjects.getDbconn().getResult("select * from danepodstawowe;" );
			sharedObjects.getGui().getTablePersonList().getItems().clear();
			while (rs.next()) {
				sharedObjects.getGui().getTablePersonList().getItems().addAll(new Person(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
			
			sharedObjects.getGui().getButton().setText("Rozłącz");
			sharedObjects.getGui().getButton().setId("disconnectDB");
			sharedObjects.setEventCase("disconnectDB");
			sharedObjects.getDbconn().disconnectDB();
			
		} catch (SQLException e) {

		}
	}
	
	public void disconnectDB() {
		sharedObjects.getDbconn().disconnectDB();
	}
}
