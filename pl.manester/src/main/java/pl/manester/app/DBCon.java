package pl.manester.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	
	private SharedObjects sharedObjects;
	private Connection conn;
	private Boolean connectionState;
	private String userDB;
	private String userPasswordDB;
	private String ip;
	
	public DBCon(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
		userDB = new String();
		userPasswordDB = new String();
		ip = new String();
	}
	
	public void connectDB() {

//		String usr = sharedObjects.getGui().getUserTextField().getText();
//		String pass = sharedObjects.getGui().getPasswordField().getText();
		
//		String ip = sharedObjects.getGui().getIpTextField().getText();
		
		String dataBase = "manester"; //sharedObjects.getGui().getDatabaseTextField().getText();
		System.out.println(userDB);
		System.out.println(userPasswordDB);
		
		ip = "10.8.0.10:5432";
		
		String url = "jdbc:postgresql://"+ ip + "/" + dataBase;
		System.out.println(url);
		connectionState = false;
		
		try {
			conn = DriverManager.getConnection(url, userDB, userPasswordDB);
			connectionState = !conn.isClosed();
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
			connectionState = !conn.isClosed();
			System.out.println("Baza rozłączona!");
		} catch (SQLException e) {
			e.printStackTrace();
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
		return userPasswordDB;
	}

	public void setUserPasswordDB(String userPasswordDB) {
		this.userPasswordDB = userPasswordDB;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
