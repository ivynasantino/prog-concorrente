package experimento_a;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ConcurrentHashMap<Integer, String> concMap = new ConcurrentHashMap<>();
		FileWriter concMapFile = new FileWriter("concurrentHashMap.csv", true);
		concMapFile.write("execucao, duracao, operacao, colecao" + System.lineSeparator());
		
		Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<Integer, String>());
		FileWriter syncMapFile = new FileWriter("SynchronizedHashMap.csv", true);
		syncMapFile.write("execucao, duracao, operacao, colecao" + System.lineSeparator());		

		
		Produtor produtor = new Produtor(concMap, syncMap);
		Consumidor consumidor = new Consumidor(concMap, syncMap);
		
		Thread t0 = new Thread(produtor);
		Thread t1 = new Thread(consumidor);
		
		t0.start();
		t1.start();
		
		t0.join();
		t1.join();
		
		List<Double> putConAdd = produtor.getConcAdd();
		List<Double> getConGet = consumidor.getConcGet();
		
		int cont = 0;
		for (Double duracao : putConAdd) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",put," + "concurrentHashMap" + System.lineSeparator();
			concMapFile.write(linha);
		}
		
		cont = 0;
		for (Double duracao : getConGet) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",get," + "concurrentHashMap" + System.lineSeparator();
			concMapFile.write(linha);
		}
		
		concMapFile.close();
		
		List<Double> putSyncAdd = produtor.getSyncAdd();		
		List<Double> getSyncGet = consumidor.getSyncGet();
		
		cont = 0;
		for (Double duracao : putSyncAdd) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",put," + "SynchronizedHashMap" + System.lineSeparator();
			syncMapFile.write(linha);
		}
		
		cont = 0;
		for (Double duracao : getSyncGet) {
			cont = cont + 1;
			String linha = cont + "," + duracao + ",get" + "SynchronizedHashMap" + System.lineSeparator();
			syncMapFile.write(linha);
		}		
		
		syncMapFile.close();

	}
	
}
