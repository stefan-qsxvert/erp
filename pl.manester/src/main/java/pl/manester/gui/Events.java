package pl.manester.gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import pl.manester.app.DBCon;
import pl.manester.app.MainObjects;

public class Events implements EventHandler<ActionEvent>{
	
	private MainObjects obiekty;
	
	public Events(MainObjects obiekty) {
//		super();
		this.obiekty = obiekty;
	}

	@Override
	public void handle(ActionEvent event) {

		DBCon dbconn = obiekty.getDbconn();
		dbconn.connectDB();
		ResultSet rs = null;
		try {
			rs =  dbconn.getResult("select * from danepodstawowe;");
		
		
		while (rs.next()) {
			for(int i = 1; i <= 3; i++) {
				String str = rs.getString(i);
				System.out.print(str+" ");
			}
			System.out.println();
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		dbconn.setConnClose();
		
//		System.out.println(textf.getText());
//		tab.getItems().add(new Osoba("Jan", "Kowalski")); 
//		tab.getItems().add(new Osoba("Anna", "Nowak"));
		
	}
	
	
}
