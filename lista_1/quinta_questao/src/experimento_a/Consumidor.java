package experimento_a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Consumidor implements Runnable {
	
	private ConcurrentHashMap<Integer, String> concMap;
	private Map<Integer, String> syncMap; 
	private List<Double> tempGetConcMap;
	private List<Double> tempGetSyncMap;
	
	public Consumidor(ConcurrentHashMap<Integer, String> concMap, Map<Integer, String> syncMap) {
		this.concMap = concMap;
		this.syncMap = syncMap;
		this.tempGetConcMap = new ArrayList<>();
		this.tempGetSyncMap = new ArrayList<>();
	}
	
	@Override
	public void run() {
		getConcMap();
		getSyncMap();		
	}
	
	private synchronized void getConcMap() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			String value = concMap.get(i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			tempGetConcMap.add(duracao);
			System.out.println("GetConc " + i + " " + duracao);
		}		
	}
	
	private synchronized void getSyncMap() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			String value = syncMap.get(i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			tempGetSyncMap.add(duracao);
			System.out.println("GetSync " + i + " " + duracao);
		}
	}
	
	
	public List<Double> getConcGet() {
		return this.tempGetConcMap;
	}
	
	public List<Double> getSyncGet() {
		return this.tempGetConcMap;
	}

}
