package api;


public class Api {
	
	private int id;
	
	public synchronized String request(String serverName) {
		return serverName + " foi o " + ++id + "º a responder.";	
	}
	
}	
