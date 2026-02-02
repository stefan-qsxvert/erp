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
		
		
		String usr = "manester";
		String pass = "274591";
		String ip = "10.8.0.10";
		String port = "5432";
		String dataBase = "manester";
		
		String url = "jdbc:postgresql://"+ ip + ":" + port + "/" + dataBase;
		
		try {

			conn = DriverManager.getConnection(url, usr, pass);
			
			if (!conn.isClosed()){
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
	
	public void disconnectDB() {
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
