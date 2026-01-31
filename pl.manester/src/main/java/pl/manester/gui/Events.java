package pl.manester.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class Events implements EventHandler<ActionEvent>{
	
	TextField textf;
	
	public Events(TextField textf) {
		this.textf = textf;
	}
	

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		System.out.println(textf.getText());
	}
	
	
}
