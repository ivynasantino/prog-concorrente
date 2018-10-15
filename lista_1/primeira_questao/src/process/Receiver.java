package process;

import channel.Channel;

public class Receiver implements Runnable {

	private Channel channel;
	
	public Receiver(Channel channel) {
		this.channel = channel;
	}
	
	@Override
	public void run() {
		while(!this.channel.isEmpty()) {
			String message = this.channel.takeMessage();
			System.out.println("Received message: " + message);
		}
	}

}
