package experimento_a;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		ConcurrentHashMap<Integer, String> concMap = new ConcurrentHashMap<>();
		FileWriter concMapFile = new FileWriter("concurrentHashMap.csv", true);
		concMapFile.write("duracao, operacao, colecao" + System.lineSeparator());
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			concMap.put(i, "valor " + i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			concMapFile.write(duracao+",put,ConcurrentHashMap" + System.lineSeparator());			
		}

		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			String value = concMap.get(i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			concMapFile.write(duracao+",get,ConcurrentHashMap" + System.lineSeparator());			
		}		
		concMapFile.close();
		
		Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<Integer, String>());
		FileWriter syncMapFile = new FileWriter("SynchronizedHashMap.csv", true);
		syncMapFile.write("duracao, operacao, colecao" + System.lineSeparator());		
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			syncMap.put(i, "valor " + i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			syncMapFile.write(duracao+",put,SynchronizedHashMap" + System.lineSeparator());			
		}

		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			String value = syncMap.get(i);
			long fim = System.nanoTime();
			double duracao =  (fim - inicio) / 1000000.0;
			syncMapFile.write(duracao+",get,SynchronizedHashMap" + System.lineSeparator());			
		}		
		syncMapFile.close();
	}
	
}
