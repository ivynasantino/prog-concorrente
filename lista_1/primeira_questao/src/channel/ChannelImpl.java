package channel;

import java.util.LinkedList;
import java.util.Queue;

public class ChannelImpl implements Channel {

	private Queue<String> channel;
	private int limit;
	
	public ChannelImpl(int limit) {
		this.channel = new LinkedList<>();
		this.limit = limit;
	}

	@Override
	public void putMessage(String message){
		if (!isFull()) {
			this.channel.add(message);
		} else {
			throw new UnsupportedOperationException("The channel is full.");
		}

	}

	@Override
	public String takeMessage() {
		String message = this.channel.peek();
		
		if (!isEmpty()) {
			this.channel.remove();
		} else {
			throw new UnsupportedOperationException("The channel is empty.");
		}
		
		return message;
		
	}
	
	@Override
	public boolean isFull() {
		return this.getLimit() == this.channel.size();
	}
	
	@Override
	public boolean isEmpty() {
		return this.channel.isEmpty();
	}
	
	private int getLimit() {
		return this.limit;
	}
	
	

}
