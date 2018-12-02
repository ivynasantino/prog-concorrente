package valor;

public class Valor {
	
	private int valor = -1;
	
	public void put(int valor) {
		this.valor = valor;
	}
	
	public int take() {
		int temp = valor;
		valor = -1;
		return temp;
	}
	
	public boolean isEmpty() {
		return valor == -1;
	}
}
