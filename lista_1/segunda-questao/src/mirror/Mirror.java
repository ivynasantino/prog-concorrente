package mirror;

public abstract class Mirror {
	
	protected String serverName;
	
	public String getServerName() {
		return this.serverName;
	}
	
	public abstract String reliableRequest();

}
