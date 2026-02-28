package pl.manester.gui.events;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import pl.manester.app.SharedObjects;

public class CKeyPressedEventHandler implements EventHandler<KeyEvent>{
	
	SharedObjects sharedObjects;
	
	public CKeyPressedEventHandler (SharedObjects sharrObjects) {
		this.sharedObjects = sharrObjects;
	}

	@Override
	public void handle(KeyEvent event) {
		System.out.println();
		
	}

}
