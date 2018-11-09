package process;

import channel.Channel;

public class Receiver implements Runnable {

	private Channel channel;
	
	public Receiver(Channel channel) {
		this.channel = channel;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (channel) {
				while(this.channel.isEmpty()) {
					try {
						this.channel.wait();
	
					} catch(Exception e) {
					System.out.println("bloqueia esperando produzir");
						
					}
				}
				
				String message = this.channel.takeMessage();
				System.out.println("Received message: " + message);
				this.channel.notifyAll();
				
			}
		}
	}

}
