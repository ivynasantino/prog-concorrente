package main;

import mirror.Mirror;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		Mirror mirror = new Mirror();
		System.out.println(mirror.reliableRequest());
	}
	
}