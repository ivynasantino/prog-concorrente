package mirror;

import api.Api;

public class Mirror {
	
	private boolean cancel = false;
		
	public String reliableRequest() throws InterruptedException {
					
		Api api = new Api();
		Cancel cancelador = new Cancel(this);
		Thread t = new Thread(cancelador);
		
		Server com = new Server("mirror1.com", api);
		Server br = new Server("mirror2.br", api);
		Server edu = new Server("mirror3.edu", api);
		
		Thread t1 = new Thread(com);
		Thread t2 = new Thread(br);
		Thread t3 = new Thread(edu);
		
		t1.start();
		t2.start();
		t3.start();
		t.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		return api.primeiro;
	
	}
	
	public synchronized void make() throws InterruptedException {
		while (!cancel) {
			System.out.println(reliableRequest());
		}
		
	}
	
	public void cancel() {
		this.cancel = true;
	}

}
