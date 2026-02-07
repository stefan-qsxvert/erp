package pl.manester.app;

import pl.manester.events.CellEventHandler;
import pl.manester.events.EventActions;
import pl.manester.events.Events;
import pl.manester.gui.Gui;

public class SharedObjects {
		
	private Gui gui;
	private EventActions eventActions;
	private Events events;
	private DBCon dbconn;
	private String eventCase;
	private Person person;
	private CellEventHandler cellEventHandler;
	private String rootDir;

	public SharedObjects() {
		eventCase = new String();
		rootDir = System.getProperty("user.dir");
	}

	public DBCon getDbconn() {
		return dbconn;
	}

	public void setDbconn(DBCon dbconn) {
		this.dbconn = dbconn;
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public String getEventCase() {
		return eventCase;
	}

	public void setEventCase(String eventCase) {
		this.eventCase = eventCase;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public EventActions getEventActions() {
		return eventActions;
	}

	public void setEventActions(EventActions eventActions) {
		this.eventActions = eventActions;
	}

	public CellEventHandler getCellEventHandler() {
		return cellEventHandler;
	}

	public void setCellEventHandler(CellEventHandler cellEventHandler) {
		this.cellEventHandler = cellEventHandler;
	}
	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}
}
