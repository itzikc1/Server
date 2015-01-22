package networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import model.*;
import task.Task;
import task.TaskRunnable;

public class ClientCommunicate implements Task{
	private Socket socket;
	public ClientCommunicate(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void doTask() {
		ObjectInputStream in = null;
		ObjectOutputStream out = null;		
		try {
			in = new ObjectInputStream(socket.getInputStream());//in get the input from socket
			out = new ObjectOutputStream(socket.getOutputStream());	//out send the solution to socket
			Problem problem = new Problem();
			problem=(Problem)in.readObject();	
			//start the model machine with all parameter 
			Model model = new MyModel();
			model.selectDomain(problem.getDomainName());
			model.selectAlgorithm(problem.getAlgorithm());	
		    model.solveDomain();
		    Solution solution = model.getSolution();//get the Solution
		    for (Action a : solution.getAction())
			{	
				System.out.print( a.getActionName());
				System.out.print( " -> ");
			}	
		    out.writeObject(solution);//send the Solution				
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
				//stopThreadPool();//stop all Thread Pool
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}			
	}
}