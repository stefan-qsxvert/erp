package pl.manester.gui.events;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;
import pl.manester.gui.ServerMenu;

public class EventActions {
	private SharedObjects sharedObjects;
	
	public EventActions(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void addServerToTableView() {
		
		TextField addServerTextField = sharedObjects.getLoginScreen().getAddServerTextField();
		TableView<ServerMenu> serverListTableView = sharedObjects.getLoginScreen().getServerListTableView();
		if (addServerTextField!=null) {
			try {
				String[] newPoz = addServerTextField.getText().split(";");
				serverListTableView.getItems().add(new ServerMenu(newPoz[0], newPoz[1], newPoz[2], newPoz[3]));
				addServerTextField.clear();
				sharedObjects.getEventActions().writeLastUserAndServerList(addServerTextField, serverListTableView);
			}catch(Exception e) {
			
			}
		}
		
	}

	public void loginToApp() {
		sharedObjects.getDbconn().connectDB();
		if (sharedObjects.getDbconn().getConnectionState()) {
			sharedObjects.getLoginScreen().getPrimaryStage().hide();
			sharedObjects.getGui().mainAppScreenStart();
		}else {
		
		}
	}
	
	public void fillTable() {
	
		try {
		
			ResultSet rs = sharedObjects.getDbconn().getResult("select * from danepodstawowe;" );
			sharedObjects.getRegPanel().getTablePersonList().getItems().clear();
			while (rs.next()) {
				sharedObjects.getRegPanel().getTablePersonList().getItems().addAll(new Person(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
				sharedObjects.getRegPanel().getTablePersonList().getItems().add(new Person(null, null, null));
				
		} catch (SQLException e) {
		}
	}
	
	public void disconnectDB() {
		sharedObjects.getDbconn().disconnectDB();
	}
	
	public void loadServerList(TableView<ServerMenu> serverListTableView) {
		
		String home = System.getProperty("user.home");
	try {	
		File serversProperties = new File(home + "/manester/server.properties");
		if (!serversProperties.exists()) {
			serversProperties.getParentFile().mkdirs();
			serversProperties.createNewFile();
		}else {
			
			BufferedReader reader = new BufferedReader(new FileReader(serversProperties));
			String line = reader.readLine();
			while (line != null) {
				String[] serverLine = line.split(";");
					try {
						serverListTableView.getItems().add(new ServerMenu(serverLine[0], serverLine[1], serverLine[2], serverLine[3]));
					}catch(Exception e){
						e.printStackTrace();
					}
					line = reader.readLine();
			}
			reader.close();
		}
	}catch(Exception e) {
		
	}
		
	}
	
	public void loadLastUser(TextField userTextField ) {
		
		String home = System.getProperty("user.home");
		try {
			File userProperties = new File(home + "/manester/user.properties");
			if (!userProperties.exists()) {
				userProperties.getParentFile().mkdirs();
				userProperties.createNewFile();
			}else {
				BufferedReader reader = new BufferedReader(new FileReader(userProperties));
				userTextField.setText(reader.readLine());
				reader.close();
			}
		}catch (Exception e) {
	
		}
	}
	
	public void writeLastUserAndServerList(TextField userTextField, TableView<ServerMenu> tableView) {
		String home = System.getProperty("user.home");
		File userProperties = new File(home + "/manester/user.properties");
		File serversProperties = new File(home + "/manester/server.properties");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(userProperties, false));
				writer.write(userTextField.getText());
				writer.newLine();
				writer.close();
				
				BufferedWriter servery = new BufferedWriter(new FileWriter(serversProperties,false));
					for ( int i = 0; i < tableView.getItems().size(); i++) {
						servery.write(
								tableView.getItems().get(i).getLp() +  ";" + 
								tableView.getItems().get(i).getAlias() + ";" +
								tableView.getItems().get(i).getIp() + ";" +
								tableView.getItems().get(i).getBase()
						);
						servery.newLine();
					}	
				
				servery.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
