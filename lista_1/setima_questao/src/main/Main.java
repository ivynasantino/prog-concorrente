package main;


import data.Data;
import threads.Filtradora;
import threads.Geradora;
import threads.Impressora;

public class Main {

	public static void main(String[] args) {
		Data sequencia = new Data();
		Geradora geradora = new Geradora(sequencia);
		Filtradora filtradora = new Filtradora(sequencia);
		Impressora impressora = new Impressora(sequencia);
		
		Thread t0 = new Thread(geradora);
		Thread t1 = new Thread(filtradora);
		Thread t2 = new Thread(impressora);
		
		t0.start();
		t1.start();
		t2.start();
		
	}
}
