package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.manester.app.DBCon;
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
		
		switch (sharedObjects.getEventCase()) {
		case "connectDB":
			
			try {
				sharedObjects.getDbconn().connectDB();
				System.out.println(sharedObjects.getDbconn().getConnState());
				sharedObjects.getDbconn().disconnectDB();
				System.out.println(sharedObjects.getDbconn().getConnState());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		default:
			break;
		}
/*		
		DBCon dbconn = sharedObjects.getDbconn();
		dbconn.connectDB();
		ResultSet rs = null;
		try {
			rs =  dbconn.getResult("select * from danepodstawowe;");
		
			sharedObjects.getTabela().getItems().clear();
		while (rs.next()) {
//			for(int i = 2; i <= 3; i++) {
//				String str = rs.getString(i);
				sharedObjects.getTabela().getItems().addAll( new Person( rs.getString(1),rs.getString(2), rs.getString(3)));
				
//				System.out.print(str+" ");
//			}
			System.out.println();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		dbconn.disconnectDB();
		
//		System.out.println(textf.getText());
//		tab.getItems().add(new Osoba("Jan", "Kowalski")); 
//		tab.getItems().add(new Osoba("Anna", "Nowak"));
		*/
	}
	
	
}
