package pl.manester.gui;

import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class Gui {
	
	private SharedObjects sharedObjects;
	
	public Gui(SharedObjects sharedObjects) {
	this.sharedObjects = sharedObjects;	
	}
	
	public void loginScreenStart() {
		try {
			sharedObjects.getLoginScreen().start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mainAppScreenStart() {
		try {
			sharedObjects.getMainAppScreen().start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void regPanelStart() {
		try {
			sharedObjects.getRegPanel().start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adhocQueryStart() {
		try {
			sharedObjects.getAdhocQuery().start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
