package pl.manester.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pl.manester.app.SharedObjects;

public class DBCon {
	
	private SharedObjects sharedObjects;
	private Connection conn;
	private Boolean connectionState;
	private String userDB;
	private char[] userPasswordDB;
	private String ip;
	
	public DBCon(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
		userDB = new String();
//		userPasswordDB = new String();
		ip = new String();
		connectionState = false;
	}
	
	public void connectDB() {

		String dataBase = "manester";
		String url = "jdbc:postgresql://"+ ip + "/" + dataBase;
		
		connectionState = false;
		
		try {
			System.out.println(userPasswordDB.toString());
			conn = DriverManager.getConnection(url, userDB, userPasswordDB.toString());
			System.out.println("Baza połączona!");
		} catch (Exception e) {
			System.out.println("Nie tym razem!");
			//e.printStackTrace();
		}
	}
	
	public ResultSet getResult(String query) throws SQLException {
		
		ResultSet rs = null;
		
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println();
		}
		
		return rs;
	}
	
	public void disconnectDB() {
		try {
			conn.close();
			System.out.println("Baza odłączona!");
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Baza odłączona!");
		}
	}
	
	public boolean getConnState() throws SQLException {
		return !conn.isClosed();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public Boolean getConnectionState() {
		try {
			connectionState = !conn.isClosed();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Baza odłączona!");
		}
		return connectionState;
	}

	public void setConnectionState(Boolean connectionState) {
		this.connectionState = connectionState;
	}

	public String getUserDB() {
		return userDB;
	}

	public void setUserDB(String userDB) {
		this.userDB = userDB;
	}

	public String getUserPasswordDB() {
		return "@gjs4#5Gt+";
	}

	public void setUserPasswordDB(String userPasswordDB) {
		this.userPasswordDB = userPasswordDB.toCharArray();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
