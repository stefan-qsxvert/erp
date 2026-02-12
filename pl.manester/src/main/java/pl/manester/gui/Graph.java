package pl.manester.gui;

import java.net.URI;
import java.net.URISyntaxException;

import pl.manester.app.SharedObjects;

public class Graph {
	
	private SharedObjects sharedObjects;
	private URI logoFile;
	private URI slavFile;
	
	public Graph(SharedObjects sharedObjects) throws URISyntaxException {
		this.sharedObjects = sharedObjects;
		logoFile = new URI(sharedObjects.getClass().getResource("/logo.jpg").toString());
		slavFile = new URI(sharedObjects.getClass().getResource("/slav.jpg").toString());
	}
	

	public SharedObjects getSharedObjects() {
		return sharedObjects;
	}

	public void setSharedObjects(SharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	public URI getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(URI logoFile) {
		this.logoFile = logoFile;
	}

	public URI getSlavFile() {
		return slavFile;
	}

	public void setSlavFile(URI slavFile) {
		this.slavFile = slavFile;
	}
}
