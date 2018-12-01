package mirror;


public class Cancel implements Runnable {

	private Mirror mirror;
	
	public Cancel(Mirror mirror) {
		this.mirror = mirror;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}
		mirror.cancel();
		
		
	}

}
