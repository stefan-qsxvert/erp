package pl.manester.gui;

public class ServerMenu {
	
	private String lp;
	private String ip;
	private String alias;
	
	public ServerMenu(String lp, String ip, String alias) {
		this.lp = lp;
		this.ip = ip;
		this.alias = alias;
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
