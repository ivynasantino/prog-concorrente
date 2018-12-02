package threads;

import valor.Valor;

public class Impressora implements Runnable {
	
	private Valor valor;
	
	public Impressora(Valor valor) {
		this.valor = valor;
	}
	
	private boolean isEven(int valor) {
		return (valor % 2) == 0; 
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (this.valor) {
				while (this.valor.isEmpty()) {
					try {
						this.valor.wait();
					} catch (InterruptedException e) {}
				}
				int temp = this.valor.take();
				if (isEven(temp))
					System.out.println("valor par gerado que foi consumido " + temp);
				this.valor.notifyAll();
			}
		}
	}

}
