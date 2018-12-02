package data;

public class Data {
	
	private String sequencia = "";
	private String filtro = "";
	
	public void put(String sequencia) {
		this.sequencia = sequencia;
	}
	
	public void putFilter(String seq) {
		this.filtro = seq;
	}
	
	public String take() {
		String temp = sequencia;
		sequencia = "";
		return temp;
	}
	
	public String takeFilter() {
		String temp = filtro;
		filtro = "";
		return temp;
	}
	
	public boolean isEmpty() {
		return sequencia.equals("");
	}
	
	public boolean isEmptyFilter() {
		return filtro.equals("");
	}
	

}
