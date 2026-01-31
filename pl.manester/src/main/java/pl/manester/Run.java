package pl.manester;

import java.sql.SQLException;


import pl.manester.app.MainObjects;
import pl.manester.gui.Gui;

public class Run {
	
	public static void main(String[] args) throws SQLException {
		
		MainObjects obiekty = new MainObjects();
		Gui gui = new Gui(obiekty);
		gui.setObiekty(obiekty);
		gui.run(args);
 
		
//		DBCon con = new DBCon(obiekty);
//		
//		con.test();
//		con.connectDB();
//		
		
//		obiekty.getConn().close();
//		
//		System.out.println("połączenie zamknięte? " + obiekty.getConn().isClosed());
		
//		
	}

}
