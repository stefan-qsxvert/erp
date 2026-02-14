package pl.manester.gui;

import java.net.URI;
import java.net.URISyntaxException;

import pl.manester.app.SharedObjects;

public class Graph {
	
	private SharedObjects sharedObjects;
	private URI logoFile;
	private URI slavFile;
	private URI slav_orig;
	private URI slav_main;
	
	public Graph(SharedObjects sharedObjects) throws URISyntaxException {
		this.sharedObjects = sharedObjects;
		logoFile = new URI(sharedObjects.getClass().getResource("/logo.jpg").toString());
		slavFile = new URI(sharedObjects.getClass().getResource("/slav.jpg").toString());
		slav_orig = new URI(sharedObjects.getClass().getResource("/slav_orig.jpg").toString());
		slav_main = new URI(sharedObjects.getClass().getResource("/slav_main.jpg").toString());
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

	public URI getSlav_orig() {
		return slav_orig;
	}

	public void setSlav_orig(URI slav_orig) {
		this.slav_orig = slav_orig;
	}

	public URI getSlav_main() {
		return slav_main;
	}

	public void setSlav_main(URI slav_main) {
		this.slav_main = slav_main;
	}
}
