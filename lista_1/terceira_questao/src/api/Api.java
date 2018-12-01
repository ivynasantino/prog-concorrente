package api;

public class Api {
	
	public String primeiro = "";
	
	public synchronized String request(String serverName) throws InterruptedException {
		synchronized (primeiro) {
			int soneca = (int) (Math.random() * 2499 + 1);
			Thread.sleep(soneca);
			if (this.primeiro.equals("")) {
				this.primeiro = serverName;
			}
			return primeiro + " respondeu em " + soneca / 1000.0 + "s";
		}
	}
}