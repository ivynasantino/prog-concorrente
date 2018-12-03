package experimento_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Produtor implements Runnable {

	private ConcurrentHashMap<Integer, String> concMap;
	private Map<Integer, String> syncMap; 
	private List<Double> tempAddConcMap;
	private List<Double> tempAddSyncMap;
	private int contador;
	
	public Produtor(ConcurrentHashMap<Integer, String> concMap, Map<Integer, String> syncMap) {
		this.concMap = concMap;
		this.syncMap = syncMap;
		this.tempAddConcMap = new ArrayList<>();
		this.tempAddSyncMap = new ArrayList<>();
		this.contador = 0;
	}
	
	@Override
	public void run() {
		putConcMap();
		putSyncMap();
	}
	
	
	private synchronized void putConcMap() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			concMap.put(i, "valor " + i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			tempAddConcMap.add(duracao);
			System.out.println("PutConc " + i + " " + duracao);
		}
	}
	
	private synchronized void putSyncMap() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			syncMap.put(i, "valor " + i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			tempAddSyncMap.add(duracao);
			System.out.println("PutSync " + i + " " + duracao);
		}
	}
	
	public List<Double> getConcAdd() {
		return this.tempAddConcMap;
	}
	
	public List<Double> getSyncAdd() {
		return this.tempAddConcMap;
	}
	
}
