package process;

import java.util.Random;

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
		while (true) {
			synchronized (channel) {
				while (this.channel.isFull()) {
					try {
						this.channel.wait();
						
					} catch (Exception e) {
						System.out.println("bloqueia esperando consumir");
						break;
					}
				}
				int produced = new Random().nextInt(11);
				String message = "Message: " + produced;
				this.channel.putMessage(message);
				System.out.println("Sended message: " + message);
				this.channel.notifyAll();
			}
			
			
		}
	}
	
	private int getCounter() {
		if (counter < this.channel.getLimit()) 
			return this.counter++;
		return this.counter;
	}
	
}
