package pl.manester.app;

import pl.manester.base.DBCon;
import pl.manester.gui.AdhocQuery;
import pl.manester.gui.AuxPreperdObjects;
import pl.manester.gui.Graph;
import pl.manester.gui.Gui;
import pl.manester.gui.LoginScreen;
import pl.manester.gui.MainAppScreen;
import pl.manester.gui.MenuLeafActions;
import pl.manester.gui.PreparedGuiObjects;
import pl.manester.gui.REGPanel;
import pl.manester.gui.events.CActionEvent;
import pl.manester.gui.events.CCellEventHandler;
import pl.manester.gui.events.CKeyPressedEventHandler;
import pl.manester.gui.events.CMouseEventHandler;
import pl.manester.gui.events.EventActions;
import pl.manester.gui.events.Events;
import pl.manester.gui.events.LoginScreenActionEvents;

public class SharedObjects {
		
	private EventActions eventActions;
	private Events events;
	private DBCon dbconn;
	private String eventCase;
	private Person person;
	private CCellEventHandler cellEventHandler;
	private CMouseEventHandler cMouseEventHandler;
	private CKeyPressedEventHandler cKeyPressedEventHandler;
	private CActionEvent cActionEvent;
	private String rootDir;
	private PreparedGuiObjects preparedObjects;
	private AuxPreperdObjects auxPreperdObjects;
	private Graph graph;
	private MainAppScreen mainAppScreen;
	private Boolean testMode;
	private REGPanel regPanel;
	private AdhocQuery adhocQuery;
	private MenuLeafActions menuLeafActions;
	private LoginScreen loginScreen; 
	private LoginScreenActionEvents loginScreenActionEvents;
	private Gui gui;

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

	public CCellEventHandler getCellEventHandler() {
		return cellEventHandler;
	}

	public void setCellEventHandler(CCellEventHandler cellEventHandler) {
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

	public PreparedGuiObjects getPreparedObjects() {
		return preparedObjects;
	}

	public void setPreparedObjects(PreparedGuiObjects preparedObjects) {
		this.preparedObjects = preparedObjects;
	}
	
	public MainAppScreen getMainAppScreen() {
		return mainAppScreen;
	}

	public void setMainAppScreen(MainAppScreen mainAppScreen) {
		this.mainAppScreen = mainAppScreen;
	}

	public Boolean getTestMode() {
		return testMode;
	}

	public void setTestMode(Boolean testMode) {
		this.testMode = testMode;
	}

	public REGPanel getRegPanel() {
		return regPanel;
	}

	public void setRegPanel(REGPanel regPanel) {
		this.regPanel = regPanel;
	}

	public AdhocQuery getAdhocQuery() {
		return adhocQuery;
	}

	public void setAdhocQery(AdhocQuery adhocQuery) {
		this.adhocQuery = adhocQuery;
	}

	public MenuLeafActions getMenuLeafActions() {
		return menuLeafActions;
	}

	public void setMenuLeafActions(MenuLeafActions menuLeafActions) {
		this.menuLeafActions = menuLeafActions;
	}

	public void setAdhocQuery(AdhocQuery adhocQuery) {
		this.adhocQuery = adhocQuery;
	}
	
	public LoginScreenActionEvents getLoginScreenActionEvents() {
		return loginScreenActionEvents;
	}

	public void setLoginScreenActionEvents(LoginScreenActionEvents loginScreenActionEvents) {
		this.loginScreenActionEvents = loginScreenActionEvents;
	}

	public LoginScreen getLoginScreen() {
		return loginScreen;
	}

	public void setLoginScreen(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	public CMouseEventHandler getcMouseEventHandler() {
		return cMouseEventHandler;
	}

	public void setcMouseEventHandler(CMouseEventHandler cMouseEventHandler) {
		this.cMouseEventHandler = cMouseEventHandler;
	}

	public CKeyPressedEventHandler getcKeyPressedEventHandler() {
		return cKeyPressedEventHandler;
	}

	public void setcKeyPressedEventHandler(CKeyPressedEventHandler cKeyPressedEventHandler) {
		this.cKeyPressedEventHandler = cKeyPressedEventHandler;
	}

	public CActionEvent getcActionEvent() {
		return cActionEvent;
	}

	public void setcActionEvent(CActionEvent cActionEvent) {
		this.cActionEvent = cActionEvent;
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}
	
}
