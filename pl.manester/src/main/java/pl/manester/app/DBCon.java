package pl.manester.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sonatype.plexus.components.sec.dispatcher.PasswordDecryptor;

import javafx.scene.control.PasswordField;

public class DBCon {
	
	private SharedObjects sharedObjects;
	private Connection conn;
	
	public DBCon(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void connectDB() {

		String usr = sharedObjects.getGui().getUserTextField().getText();
		String pass = sharedObjects.getGui().getPasswordField().getText();
		
		String ip = sharedObjects.getGui().getIpTextField().getText();
		String dataBase = sharedObjects.getGui().getDatabaseTextField().getText();
		
		String url = "jdbc:postgresql://"+ ip + "/" + dataBase;
		
		try {
			conn = DriverManager.getConnection(url, usr, pass);
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
			conn.close();
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
}
