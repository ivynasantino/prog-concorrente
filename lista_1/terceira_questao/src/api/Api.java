package api;

public class Api {
	
	private int id;
	
	public synchronized String request(String serverName) throws InterruptedException {
		int soneca = (int) (Math.random() * 2499 + 1);
		Thread.sleep(soneca);
		return serverName + " foi o " + ++id + "º a responder.";	
	}
}
