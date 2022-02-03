package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] data;

	public Message(byte[] data) {
		this.data = data;

		if(data == null || data.length >= 127){
			throw new UnsupportedOperationException("Array is empty or it's length is more than 127");
		}
	}

	public byte[] getData() {
		return this.data; 
	}

}
