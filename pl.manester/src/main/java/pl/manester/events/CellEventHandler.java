package pl.manester.events;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import pl.manester.app.Person;
import pl.manester.app.SharedObjects;

public class CellEventHandler implements EventHandler<CellEditEvent<Person, String>>{
	
	SharedObjects sharedObjects;
	String type;
	
	public CellEventHandler(SharedObjects sharedObjects, String type){
		this.sharedObjects = sharedObjects;
		this.type = type;
	}

	@Override
	public void handle(CellEditEvent<Person, String> event) {
		
		Person person = event.getRowValue();
		System.out.println(person.getImie().get());
		System.out.println(person.getNazwisko().get());
		
		if (person.getImie().get()!=null && person.getNazwisko().get()!=null&&person.getNazwisko().get()!=null) {
			sharedObjects.getGui().getTablePersonList().getItems().add(new Person(null,null,null));
		}
		
		switch (type) {
		case "0":
			person.setNumber(event.getNewValue());
			break;
		case "1":
			person.setNazwisko(event.getNewValue());
		break;		
		case "2":
			person.setImie(event.getNewValue());
			break;
		default:
			break;
		}
	}
}
