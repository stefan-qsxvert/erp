package pl.manester.app;

import java.sql.Connection;

public class MainObjects {
	
	private Connection conn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
