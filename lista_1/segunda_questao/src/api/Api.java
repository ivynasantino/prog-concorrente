package api;

import channel.Channel;

public class Api {
	
	private Channel channel;
	private int id;
	
	public Api(Channel channel) {
		this.channel = channel;
	}
	
	public synchronized String request(String serverName) {
		try {
			this.channel.putMessage(serverName);
		} catch (UnsupportedOperationException e) {
			System.exit(0);
		}
		return "O primeiro mirror a responder foi " + this.channel.getFirst();	
	}
	
}	
