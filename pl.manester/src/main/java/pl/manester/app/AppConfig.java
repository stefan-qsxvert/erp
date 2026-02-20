package pl.manester.app;

public class AppConfig {
	
	private String login;
	private String server_id;
	private String server_alias;
	private String server_ip;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getServer_id() {
		return server_id;
	}
	public void setServer_id(String server_id) {
		this.server_id = server_id;
	}
	public String getServer_alias() {
		return server_alias;
	}
	public void setServer_alias(String server_alias) {
		this.server_alias = server_alias;
	}
	public String getServer_ip() {
		return server_ip;
	}
	public void setServer_ip(String server_ip) {
		this.server_ip = server_ip;
	}
}
