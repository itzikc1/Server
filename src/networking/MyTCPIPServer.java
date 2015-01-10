package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import properties.MyProperties;
import properties.GetProperties;
import task.TaskRunnable;

public class MyTCPIPServer {
	private ServerSocket server;
	private ExecutorService executor;
	private Thread thread;
	private int port;
	private int numOfClients;
	public MyTCPIPServer() {
		MyProperties properties = GetProperties.readProperties();//define the server with XML Properties
		this.port = properties.getPort();
		this.numOfClients = properties.getNumOfClients();		
	}
	public MyTCPIPServer(int port, int numOfClients) {
		this.port = port;
		this.numOfClients = numOfClients;
	}
	public void startServer() {
		try {
			server = new ServerSocket(port);			
		    server.setSoTimeout(1000000000);			
			executor = Executors.newFixedThreadPool(numOfClients);//Create thread pool of clients	
			thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(!Thread.interrupted()) {
					try {
						Socket socket = server.accept();//Listing to port
						System.out.println("Got new connection");	
						if (socket != null) {
							ClientCommunicate handler = new ClientCommunicate(socket);
							executor.submit(new TaskRunnable(handler));//enter client to thread pool
						}					
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {						
				  }
				}				
			}			
		});
		thread.start();//start to talk with the client		
	} catch (IOException e1) {
			e1.printStackTrace();
	}		
}	
	public void stopServer() {//stop and close the server		
		try {
			thread.interrupt();// wake up all the thread
			executor.shutdownNow();// shutdown now all the thread 
			//server.isBound();
			server.close();
		} catch (IOException e) {
			System.out.println("no client connect");
			e.printStackTrace();
		}
	}	
}
