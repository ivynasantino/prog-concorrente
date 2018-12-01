package main;

import api.Api;
import mirror.Mirror;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Api api = new Api();
		
		Mirror mirrorCom = new Mirror(api, "mirror1.com");
		Mirror mirrorBr = new Mirror(api, "mirror2.br");
		Mirror mirrorEdu = new Mirror(api, "mirror3.edu");
		
		Thread t0 = new Thread(mirrorCom);
		Thread t1 = new Thread(mirrorBr);
		Thread t2 = new Thread(mirrorEdu);
		
		t0.start();
		t1.start();
		t2.start();
		
		t0.join();
		t1.join();
		t2.join();
		
	}
	
}