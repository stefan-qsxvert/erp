package pl.manester.app;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.manester.gui.EventActions;
import pl.manester.gui.Events;
import pl.manester.gui.Gui;

public class SharedObjects {
		
	private Gui gui;
	private EventActions eventActions;
	private Events events;
	private Stage stage;
	private TableView<Person> tabela;
	private DBCon dbconn;
	private String eventCase;

	public SharedObjects() {
		eventCase = new String();
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

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public TableView<Person> getTabela() {
		return tabela;
	}

	public void setTabela(TableView<Person> tabela) {
		this.tabela = tabela;
	}
	
	public EventActions getEventAtions() {
		return getEventAtions();
	}

	public void setEventActions(EventActions eventActions) {
		this.eventActions = eventActions;
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
}
