package pl.manester.app;

import java.sql.Connection;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.manester.gui.EventAtions;
import pl.manester.gui.Events;
import pl.manester.gui.Gui;

public class SharedObjects {
		
	private Gui gui;
	private EventAtions eventAtions;
	private Events events;
	private Stage stage;
	private TableView<Person> tabela;
	private Connection conn;
	private DBCon dbconn;
	
	
	public SharedObjects() {
	}
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
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
}
