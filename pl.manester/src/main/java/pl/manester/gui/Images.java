package pl.manester.gui;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.scene.image.Image;
import pl.manester.app.SharedObjects;

public class Images {
	
	private SharedObjects sharedObjects;
	private Image logo1;
	
	public Images(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public void init() {
		logo1 =  new Image(sharedObjects.getClass().getResource("/logo.jpg").toString(), false);

	}
	

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public Image getLogo() {
		return logo1;
	}

	public void setLogo(Image logo) {
		this.logo1 = logo;
	}
	
	
	
	
	
}
