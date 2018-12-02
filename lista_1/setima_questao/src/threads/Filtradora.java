package threads;

import data.Data;

public class Filtradora implements Runnable {
	
	private Data sequencia;
	
	public Filtradora(Data sequencia) {
		this.sequencia = sequencia;
	}

	public boolean isAlpha(String sequencia) {
		boolean result = true;
		
		for (int i = 0; i < sequencia.length(); i++) {
			if (!Character.isLetter(sequencia.charAt(i))) {
				return false;
			}
		}
		
		return result;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (this.sequencia) {
				while (this.sequencia.isEmpty() && !this.sequencia.isEmptyFilter()) {
					try {
						this.sequencia.wait();
					} catch (InterruptedException e) {}
				}
				String temp = this.sequencia.take();
				if (isAlpha(temp))
					sequencia.putFilter(temp);
					//System.out.println("valor par gerado que foi consumido " + temp);
				this.sequencia.notify();
			}
		}
		
	}

}
