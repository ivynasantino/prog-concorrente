package factory;

import mirror.Mirror;
import mirror.MirrorBr;
import mirror.MirrorCom;
import mirror.MirrorEdu;

public class MirrorFactory {

	private Mirror mirror;
	
	public Mirror factoryMirro(String mirror) {
		if (mirror.equalsIgnoreCase("mirror1.com")) {
			this.mirror = new MirrorCom();
		} else if (mirror.equalsIgnoreCase("mirror2.br")) {
			this.mirror = new MirrorBr();
		} else if (mirror.equalsIgnoreCase("mirror3.edu")) {
			this.mirror = new MirrorEdu();
		}
		
		return this.mirror;
	}
	
	
}
