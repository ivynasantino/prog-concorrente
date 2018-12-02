package main;

import threads.Geradora;
import threads.Impressora;
import valor.Valor;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Valor valor = new Valor();
		
		Geradora geradora = new Geradora(valor);
		Impressora impressora = new Impressora(valor);
		
		Thread t0 = new Thread(geradora);
		Thread t1 = new Thread(impressora);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
	}

}
