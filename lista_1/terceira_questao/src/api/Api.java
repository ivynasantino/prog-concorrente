package api;

import channel.Channel;

public class Api {
	
	private Channel channel;
	
	public Api(Channel channel) {
		this.channel = channel;
	}
	
	public synchronized String request(String serverName) throws InterruptedException {
		int soneca = (int) (Math.random() * 2499 + 1);
		try {
			this.channel.putMessage(serverName);
			Thread.sleep(soneca);
		} catch (UnsupportedOperationException e) {
			System.exit(0);
		}
		return this.channel.getFirst() + " respondeu em " + soneca / 1000.0 + "s";
	}
}