package pl.manester.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	
	private MainObjects obiekty;
	private Connection conn;
	
	public DBCon(MainObjects obiekty) {
		this.obiekty = obiekty;
	}
	
	public void connectDB() {
		String url = "jdbc:postgresql://10.8.0.10:5432/manester";
//		String port;
		String usr = "manester";
		String pass = "274591";
		
		try {

			conn = DriverManager.getConnection(url, usr, pass);
			
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
	
	public ResultSet getResult(String query) throws SQLException {
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
//		while (rs.next()) {
//		for(int i = 1; i <= 3; i++) {
//			String str = rs.getString(i);
//			System.out.print(str+" ");
//		}
//		System.out.println();
//		}
		return rs;
//		obiekty.getConn().close();
	}
	
	public void setConnClose() {
		try {
			obiekty.getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getConnState() throws SQLException {
		return conn.isClosed();
	}
}
