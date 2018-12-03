package experimento_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Produtor implements Runnable {
	
	private CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
	private List<Integer> synchList;
	private List<Double> tempCopyWrite;
	private List<Double> tempSyncList;
	
	public Produtor(CopyOnWriteArrayList<Integer> copyOnWriteArrayList, List<Integer> synchList) {
		this.copyOnWriteArrayList = copyOnWriteArrayList;
		this.synchList = synchList;
		this.tempCopyWrite = new ArrayList<>();
		this.tempSyncList = new ArrayList<>();
	}

	@Override
	public void run() {
		getCopyOnWritePut();
		getSyncPut();
		
	}
	
	private synchronized void getCopyOnWritePut() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			copyOnWriteArrayList.add(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			tempCopyWrite.add(duracao);
		}
	}
	
	private synchronized void getSyncPut() {
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			synchList.add(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			tempSyncList.add(duracao);
		}
	}
	
	public List<Double> getSyncListPut() {
		return this.tempSyncList;
	}
	
	public List<Double> getCopyWritePut() {
		return this.tempCopyWrite;
	}

}
