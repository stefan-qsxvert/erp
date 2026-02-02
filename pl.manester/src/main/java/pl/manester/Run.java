package pl.manester;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import pl.manester.app.DBCon;
import pl.manester.app.MainObjects;
import pl.manester.gui.Gui;

public class Run {
	
	public static void main(String[] args) throws SQLException {
		
		MainObjects obiekty = new MainObjects();
		DBCon dbcon = new DBCon(obiekty);
		obiekty.setDbconn(dbcon);
		
		Gui gui = new Gui(obiekty);
		gui.newLaunch();
//		gui.setObiekty(obiekty);
//		gui.run(args);
		
//		Application.launch(Gui.class,args);
		
		
		
		dbcon.setConnClose();
		
		
		
		System.out.println("Bazo odłączona: " + dbcon.getConnState());
		
		
	}

}
