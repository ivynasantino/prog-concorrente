package threads;

import data.Data;

public class Impressora implements Runnable {
	
	private Data sequencia;

	public Impressora(Data sequencia) {
		this.sequencia = sequencia;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (this.sequencia) {
				while (this.sequencia.isEmptyFilter()) {
					try {
						this.sequencia.wait();
					} catch (InterruptedException e) {}
				}
				String temp = this.sequencia.takeFilter();
				
				System.out.println(temp);
				this.sequencia.notify();
			}
		}
		
	}

}
