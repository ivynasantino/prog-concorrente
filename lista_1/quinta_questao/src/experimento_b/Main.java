package experimento_b;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		FileWriter copyOnWrite = new FileWriter("CopyOnWriteArrayList.csv", true);
		copyOnWrite.write("duracao, operacao, colecao" + System.lineSeparator());
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			copyOnWriteArrayList.add(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			copyOnWrite.write(duracao+",add,CopyOnWriteArrayList" + System.lineSeparator());
		}
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			copyOnWriteArrayList.get(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			copyOnWrite.write(duracao+",get,CopyOnWriteArrayList" + System.lineSeparator());
		}
		
		copyOnWrite.close();
		
		List<Integer> synchList = Collections.synchronizedList(new ArrayList<Integer>());
		FileWriter synchListFile = new FileWriter("SynchronizedList.csv", true);
		synchListFile.write("duracao, operacao, colecao" + System.lineSeparator());
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			synchList.add(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			synchListFile.write(duracao+",add,SynchronizedList" + System.lineSeparator());
		}
		
		for (int i = 0; i < 100; i++) {
			long inicio = System.nanoTime();
			synchList.get(i);
			long fim = System.nanoTime();
			double duracao = (fim - inicio) / 1000000.0;
			synchListFile.write(duracao+",get,SynchronizedList" + System.lineSeparator());
		}
		
		synchListFile.close();
		
	}
	
}
