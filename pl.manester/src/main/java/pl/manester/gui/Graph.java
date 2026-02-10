package pl.manester.gui;

import javafx.scene.image.Image;
import pl.manester.app.SharedObjects;

public class Graph {
	
	private SharedObjects sharedObjects;
	private Image logo;
	
	public Graph(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
		logo =  new Image(sharedObjects.getClass().getResource("/logo.jpg").toString(), false);
	}
	

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
	
	
	
	
	
}
