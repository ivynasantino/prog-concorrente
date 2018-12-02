package threads;

import java.util.Random;

import data.Data;

public class Geradora implements Runnable {
	
	private Data sequencia;
	
	public Geradora(Data sequencia) {
		this.sequencia = sequencia;
	}

	public String geraAleatorio(int qntCaracteres) {
		Random rand = new Random();
		char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇ0123456789".toCharArray();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < qntCaracteres; i++) {
	        int ch = rand.nextInt (letras.length);
	        sb.append (letras[ch]);
	    }
	    
	   return sb.toString();
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (sequencia) {
				while (!sequencia.isEmpty()) {
					try {
						this.sequencia.wait();
					} catch (InterruptedException e) {
						
					}
					
				}
				
				String sequenciaGerada = geraAleatorio(5);
				this.sequencia.put(sequenciaGerada);
				this.sequencia.notify();
			}
		}
		
	}

}
