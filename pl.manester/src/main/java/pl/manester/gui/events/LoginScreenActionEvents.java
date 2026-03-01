package pl.manester.gui.events;

import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class LoginScreenActionEvents {
	
	SharedObjects sharedObjects;
	
	public LoginScreenActionEvents(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void loginActions(Stage stage){
				
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
				
						try {
//							sharedObjects.getGui().start(new Stage());
							stage.hide();
							sharedObjects.getMainAppScreen().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
				}
			}
	

	}
