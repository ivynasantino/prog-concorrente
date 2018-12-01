package api;

public class Api {
	
	public String primeiro = "";
	
	public Api() {
	}
	
	public String request(String serverName) {
		synchronized (primeiro) {
			this.primeiro = serverName;
			return this.primeiro;
		}	
	}
}	
