package properties;

import java.io.Serializable;

public class MyProperties implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int port;//number port
	private int numOfClients;//number of clients can use the server
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getNumOfClients() {
		return numOfClients;
	}
	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}
	public MyProperties(int port, int numOfClients) {
		super();
		this.port = port;
		this.numOfClients = numOfClients;
	}	
	public MyProperties() { }
}
