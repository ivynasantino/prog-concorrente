package process;

import channel.Channel;

public class Sender implements Runnable {

	private Channel channel;
	private int counter;
	
	public Sender(Channel channel) {
		this.channel = channel;
		this.counter = 0;
	}

	@Override
	public void run() {
		while (!this.channel.isFull()) {
			String message = "Message: " + this.getCounter();
			this.channel.putMessage(message);
		}
	}
	
	private int getCounter() {
		return this.counter++;
	}
	
}
