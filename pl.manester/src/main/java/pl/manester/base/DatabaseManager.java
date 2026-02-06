package pl.manester.base;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseManager {
	
	 private final HikariDataSource dataSource;
	 
	 public DatabaseManager(String url, String user, String password) {
		 HikariConfig config = new HikariConfig(); 
		 config.setJdbcUrl(url); 
		 config.setUsername(user); 
		 config.setPassword(password); 
		 config.setMaximumPoolSize(10); // ile połączeń w puli 
		 config.setMinimumIdle(2); // ile połączeń ma być zawsze gotowych 
		 config.setIdleTimeout(60000); // zamykanie nieużywanych połączeń 
		 config.setConnectionTimeout(30000); // timeout na pobranie połączenia 
		 this.dataSource = new HikariDataSource(config); 
		 } 
	 
	 	public Connection getConnection() throws SQLException { 
	 		return dataSource.getConnection(); // pobiera połączenie z puli 
		 } 
		 
		 public void close() { 
			 dataSource.close(); // zamyka całą pulę przy zamykaniu aplikacji 
			 }
	 }
