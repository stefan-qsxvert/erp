package pl.manester.app;

import pl.manester.gui.events.CellEventHandler;
import pl.manester.gui.events.EventActions;
import pl.manester.gui.events.Events;
import pl.manester.gui.AuxPreperdObjects;
import pl.manester.gui.Gui;
import pl.manester.gui.Images;

public class SharedObjects {
		
	private Gui gui;
	private EventActions eventActions;
	private Events events;
	private DBCon dbconn;
	private String eventCase;
	private Person person;
	private CellEventHandler cellEventHandler;
	private String rootDir;
	private AuxPreperdObjects auxPreperdObjects;
	private Images images;

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

	public AuxPreperdObjects getAuxPreperdObjects() {
		return auxPreperdObjects;
	}

	public void setAuxPreperdObjects(AuxPreperdObjects auxPreperdObjects) {
		this.auxPreperdObjects = auxPreperdObjects;
	}

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}
}
