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
	
	public DBCon(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void connectDB() {

		String usr = sharedObjects.getGui().getUserTextField().getText();
		String pass = sharedObjects.getGui().getPasswordField().getText();
		
		String ip = sharedObjects.getGui().getIpTextField().getText();
		String dataBase = sharedObjects.getGui().getDatabaseTextField().getText();
		
		String url = "jdbc:postgresql://"+ ip + "/" + dataBase;
		connectionState = false;
		
		try {
			conn = DriverManager.getConnection(url, usr, pass);
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
}
