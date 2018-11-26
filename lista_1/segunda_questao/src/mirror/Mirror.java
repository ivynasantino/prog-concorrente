package mirror;

import api.Api;

public class Mirror implements Runnable {
	
	Api api = new Api();
	
	private String serverName;
	
	public Mirror(String serverName) {
		this.setServerName(serverName);
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String reliableRequest() {
		return api.request(serverName);
	}

	@Override
	public void run() {
		System.out.println(this.reliableRequest());
	}
	
}
