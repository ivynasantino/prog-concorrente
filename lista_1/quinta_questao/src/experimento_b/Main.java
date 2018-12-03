package experimento_b;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		FileWriter copyOnWrite = new FileWriter("CopyOnWriteArrayList.csv", true);
		copyOnWrite.write("execucao, duracao, operacao, colecao" + System.lineSeparator());
		
		List<Integer> synchList = Collections.synchronizedList(new ArrayList<Integer>());
		FileWriter synchListFile = new FileWriter("SynchronizedList.csv", true);
		synchListFile.write("execucao, duracao, operacao, colecao" + System.lineSeparator());	

		
		Produtor produtor = new Produtor(copyOnWriteArrayList, synchList);
		Consumidor consumidor = new Consumidor(copyOnWriteArrayList, synchList);
		
		Thread t0 = new Thread(produtor);
		Thread t1 = new Thread(consumidor);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		List<Double> putCopyWritePut = produtor.getCopyWritePut();
		List<Double> getCopyWriteGet = consumidor.getCopyWriteGet();
		
		int cont = 0;
		for (Double duracao : putCopyWritePut) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",put," + "CopyOnWriteArrayList" +System.lineSeparator();
			copyOnWrite.write(linha);
		}
		
		cont = 0;
		for (Double duracao : getCopyWriteGet) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",get," + "CopyOnWriteArrayList" + System.lineSeparator();
			copyOnWrite.write(linha);
		}
		
		copyOnWrite.close();
		
		List<Double> putSyncListPut = produtor.getSyncListPut();		
		List<Double> getSyncListGet = consumidor.getSyncListGet();
		
		cont = 0;
		for (Double duracao : putSyncListPut) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",put," + "SynchronizedList" +System.lineSeparator();
			synchListFile.write(linha);
		}
		
		cont = 0;
		for (Double duracao : getSyncListGet) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",get," + "SynchronizedList" + System.lineSeparator();
			synchListFile.write(linha);
		}		
		
		synchListFile.close();

	}
	
}
