package pl.manester.gui;

import javafx.stage.Stage;
import pl.manester.app.SharedObjects;

public class MenuLeafActions {

	SharedObjects sharedObjects;
	
	public MenuLeafActions(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}
	
	public void runREGPanel() {
		REGPanel regPanel = new REGPanel(sharedObjects);
		try {
			regPanel.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runAdhocQuery() {
		AdhocQuery adhocQery = new AdhocQuery(sharedObjects);
		try {
			adhocQery.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
