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
			return "Erro: " + serverName + " demorou muito para responder";
		return resposta;
	}

	@Override
	public void run() {		
		try {
			System.out.println(this.reliableRequest());
		} catch (InterruptedException e) {
		}
	}
}
