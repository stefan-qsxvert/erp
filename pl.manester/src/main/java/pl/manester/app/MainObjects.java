package pl.manester.app;

import java.sql.Connection;

public class MainObjects {
	
	private Connection conn;
	private DBCon dbconn;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public DBCon getDbconn() {
		return dbconn;
	}

	public void setDbconn(DBCon dbconn) {
		this.dbconn = dbconn;
	}
}
