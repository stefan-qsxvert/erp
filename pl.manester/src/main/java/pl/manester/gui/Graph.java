package pl.manester.gui;

import java.io.File;

import pl.manester.app.SharedObjects;

public class Graph {
	
	private SharedObjects sharedObjects;
	private File logoFile;
	
	public Graph(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
		logoFile =  new File(sharedObjects.getClass().getResource("/logo.jpg").toString());
	}
	

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public File getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(File logoFile) {
		this.logoFile = logoFile;
	}
	
	
	
	
	
}
