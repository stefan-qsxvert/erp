package pl.manester.app;

import pl.manester.base.DBCon;
import pl.manester.gui.AuxPreperdObjects;
import pl.manester.gui.Graph;
import pl.manester.gui.REGPanel;
import pl.manester.gui.PreparedObjects;
import pl.manester.gui.events.CellEventHandler;
import pl.manester.gui.events.EventActions;
import pl.manester.gui.events.Events;

public class SharedObjects {
		
	private REGPanel gui;
	private EventActions eventActions;
	private Events events;
	private DBCon dbconn;
	private String eventCase;
	private Person person;
	private CellEventHandler cellEventHandler;
	private String rootDir;
	private PreparedObjects preparedObjects;
	private AuxPreperdObjects auxPreperdObjects;
	private Graph graph;

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

	public REGPanel getGui() {
		return gui;
	}

	public void setGui(REGPanel gui) {
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

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public PreparedObjects getPreparedObjects() {
		return preparedObjects;
	}

	public void setPreparedObjects(PreparedObjects preparedObjects) {
		this.preparedObjects = preparedObjects;
	}
	
}
