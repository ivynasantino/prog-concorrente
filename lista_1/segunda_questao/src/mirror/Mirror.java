package mirror;

import api.Api;

public class Mirror implements Runnable {
	
	private Api api; 
	private String serverName;
	
	public Mirror(Api api, String serverName) {
		this.setServerName(serverName);
		this.api = api;
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
		System.exit(0);
	}
	
}
