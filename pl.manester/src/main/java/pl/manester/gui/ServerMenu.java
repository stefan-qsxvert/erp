package pl.manester.gui;

public class ServerMenu {
	
	private String lp;
	private String alias;
	private String ip;
	
	public ServerMenu(String lp, String alias, String ip) {
		this.lp = lp;
		this.alias = alias;
		this.ip = ip;
	}
	
	public String getLp() {
		return lp;
	}
	public void setLp(String lp) {
		this.lp = lp;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
}
