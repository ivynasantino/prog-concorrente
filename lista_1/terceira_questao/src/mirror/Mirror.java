package mirror;

import api.Api;

public class Mirror implements Runnable{

	private Api api; 
	private String serverName;
	
	public Mirror(Api api, String serverName) {
		this.setServerName(serverName);
		this.api = api;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String reliableRequest() throws InterruptedException {
		long inicio = System.currentTimeMillis();
		String resposta = api.request(serverName);
		long fim = System.currentTimeMillis();
		long duracao = fim - inicio;
		if (duracao > 2000)
			return "Erro: " + serverName + " demorou muito para responder (" + duracao / 1000.0 + "s)";
		return resposta;
	}

	@Override
	public void run() {		
		try {
			System.out.println(this.reliableRequest());
			
			// p testar se muda o mirror descomentar aqui
//			while (true)
//				System.out.println(this.reliableRequest());
		} catch (InterruptedException e) {
		}
	}
}
