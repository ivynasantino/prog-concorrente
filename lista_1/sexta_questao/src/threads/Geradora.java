package threads;

import valor.Valor;

public class Geradora implements Runnable {
	
	private Valor valor;
	
	public Geradora(Valor valor) {
		this.valor = valor;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (this.valor) {
				while (!this.valor.isEmpty()) {
					try {
						this.valor.wait();
					} catch (InterruptedException e) {}
				}
				int gerado = (int) (Math.random() * 1000 + 1);
				this.valor.put(gerado);
				this.valor.notifyAll();
			}
		}
	}

}
