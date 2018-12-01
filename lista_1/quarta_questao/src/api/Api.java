package api;

public class Api {
	
	public String primeiro = "";
	
	public String request(String serverName) {
		synchronized (primeiro) {
			this.primeiro = serverName;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				
			}
			return this.primeiro;
		}	
	}
}
