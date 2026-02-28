package pl.manester.gui;

public class ServerMenu {
	
	private String lp;
	private String alias;
	private String ip;
	private String base;
	
	public ServerMenu(String lp, String alias, String ip, String base) {
		this.lp = lp;
		this.alias = alias;
		this.ip = ip;
		this.base = base;
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

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
}
