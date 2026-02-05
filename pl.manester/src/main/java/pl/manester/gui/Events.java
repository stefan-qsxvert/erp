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
		
		switch (sharedObjects.getEventCase()) {
		case "connectDB":
			
			try {
				sharedObjects.getDbconn().connectDB();
				
				ResultSet rs = sharedObjects.getDbconn().getResult("select * from danepodstawowe;" );
				sharedObjects.getGui().getTablePersonList().getItems().clear();
				while (rs.next()) {
					sharedObjects.getGui().getTablePersonList().getItems().addAll(new Person(rs.getString(1), rs.getString(2), rs.getString(3)));
				}
				
				sharedObjects.getDbconn().disconnectDB();
				
			} catch (SQLException e) {
				e.printStackTrace();
				sharedObjects.getDbconn().disconnectDB();
				try {
					System.out.println(sharedObjects.getDbconn().getConnState());
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
			
			break;
		default:
			break;
		}

//			sharedObjects.getTabela().getItems().clear();
			
			
			
//		while (rs.next()) {
//
//				//sharedObjects.getTabela().getItems().addAll( new Person( rs.getString(1),rs.getString(2), rs.getString(3)));
//				
//
//			}
//			System.out.println();
//			}
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//			
//		dbconn.disconnectDB();
//		
//		System.out.println(textf.getText());
//		tab.getItems().add(new Osoba("Jan", "Kowalski")); 
//		tab.getItems().add(new Osoba("Anna", "Nowak"));
//
	}
	
	
}
