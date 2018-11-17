package api;

import factory.MirrorFactory;
import mirror.Mirror;

public class API {
	
	private Mirror mirror;
	private MirrorFactory factory;
	
	public API(String mirror) {
		this.factory = new MirrorFactory();
		this.mirror = factory.factoryMirro(mirror);
	}
	
	public String serverName(String serverName) {
		return null;
	}

}
