package experimento_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Consumidor implements Runnable {

	private CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
	private List<Integer> synchList;
	private List<Double> tempCopyWrite;
	private List<Double> tempSyncList;
	
	public Consumidor(CopyOnWriteArrayList<Integer> copyOnWriteArrayList, List<Integer> synchList) {
		this.copyOnWriteArrayList = copyOnWriteArrayList;
		this.synchList = synchList;
		this.tempCopyWrite = new ArrayList<>();
		this.tempSyncList = new ArrayList<>();
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		getCopyWrite();
		getSyncList();
		
	}
	
	private synchronized void getCopyWrite() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			int value = copyOnWriteArrayList.get(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			tempCopyWrite.add(duracao);
		}		
	}
	
	private synchronized void getSyncList() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			int value = synchList.get(i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			tempSyncList.add(duracao);
		}
	}
	
	public List<Double> getCopyWriteGet() {
		return this.tempCopyWrite;
	}
	
	public List<Double> getSyncListGet() {
		return this.tempSyncList;
	}

}
