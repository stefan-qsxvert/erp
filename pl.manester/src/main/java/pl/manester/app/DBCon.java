package pl.manester.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	
	private SharedObjects obiekty;
	private Connection conn;
	
	public DBCon(SharedObjects obiekty) {
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
		
		return rs;
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
