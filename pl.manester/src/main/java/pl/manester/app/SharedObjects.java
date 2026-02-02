package pl.manester.app;

import java.sql.Connection;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pl.manester.gui.Gui;

public class SharedObjects {
	
	private Connection conn;
	private DBCon dbconn;
	private Gui gui;
	private Stage stage;
	private TableView<Osoba> tabela;

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

	public TableView<Osoba> getTabela() {
		return tabela;
	}

	public void setTabela(TableView<Osoba> tabela) {
		this.tabela = tabela;
	}
}
