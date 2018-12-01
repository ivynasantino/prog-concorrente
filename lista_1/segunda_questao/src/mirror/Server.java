package mirror;

import api.Api;

public class Server implements Runnable {
	
	private String serverName;
	private Api api;
	
	public Server(String serverName, Api api){
		this.serverName = serverName;
		this.api = api;
	}
	
	@Override
	public void run() {
		this.api.request(serverName);
	}

}
