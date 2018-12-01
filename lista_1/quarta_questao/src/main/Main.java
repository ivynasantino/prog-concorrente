package main;

import mirror.Cancel;
import mirror.Mirror;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Mirror mirror = new Mirror();
		mirror.make();
		Cancel c = new Cancel(mirror);
		Thread t = new Thread(c);
		
		t.start();
		t.join();
		
	}
	
}