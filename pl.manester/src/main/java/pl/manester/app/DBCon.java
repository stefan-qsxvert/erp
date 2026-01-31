package pl.manester.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	
	MainObjects obiekty;
	
	public DBCon(MainObjects obiekty) {
		this.obiekty = obiekty;
	}
	
	public void test() {
		System.out.println("DBCon ok! ");
	}
	
	public void connectDB() {
		String url = "jdbc:postgresql://10.8.0.10:5432/manester";
//		String port;
		String usr = "manester";
		String pass = "274591";
		
		try {

			Connection conn = DriverManager.getConnection(url, usr, pass);
			
			if (!conn.isClosed()){
			System.out.println("Baza połączona!");
			obiekty.setConn(conn);
//			conn.close();
			}
		} catch (Exception e) {
			System.out.println("Nie tym razem!");
			e.printStackTrace();
		}
	}
}
