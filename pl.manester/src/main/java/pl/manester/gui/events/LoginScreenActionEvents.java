package pl.manester.gui.events;

import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class LoginScreenActionEvents {
	
	SharedObjects sharedObjects;
	
	public LoginScreenActionEvents(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void loginActions(Stage stage, String user, String pass){
		
				sharedObjects.getDbconn().setUserDB(user);
				sharedObjects.getDbconn().setUserPasswordDB(pass);
				
				if (sharedObjects.getTestMode()) {
					try {
						stage.hide();
						sharedObjects.getMainAppScreen().start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else {
					sharedObjects.getDbconn().connectDB();
				
//				sharedObjects.getDbconn().disconnectDB();
				
				if (sharedObjects.getDbconn().getConnectionState()) {
				
				stage.hide();
				try {
//					sharedObjects.getGui().start(new Stage());
					sharedObjects.getMainAppScreen().start(new Stage());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				}
				}
			}
	

	}
