package mirror;

import api.Api;

public class Mirror {
	
	public String reliableRequest() throws InterruptedException {
		
		Api api = new Api();
		
		Server com = new Server("mirror1.com", api);
		Server br = new Server("mirror2.br", api);
		Server edu = new Server("mirror3.edu", api);
		
		Thread t1 = new Thread(com);
		Thread t2 = new Thread(br);
		Thread t3 = new Thread(edu);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		return api.primeiro;
	}

}
