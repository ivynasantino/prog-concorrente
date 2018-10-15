package channel;

public interface Channel {
	
	public void putMessage(String message);
	
	public String takeMessage();
	
	public boolean isFull();
	
	public boolean isEmpty();
	
}
