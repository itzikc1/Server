package model;

import java.util.ArrayList;
import java.util.Observable;


public class MyModel extends Observable implements Model {
	private SearchDomain domain;
	private Searcher algorithm;
	private Solution solution;
	//select the specific problem
	@Override
	public void selectDomain(String domainName) {
		DomainFactory domainFactory=new DomainFactory();
		 domain = domainFactory.getDomain(domainName);
	}
	//select the algorithm to solve the problem
	@Override
	public void selectAlgorithm(String algorithmName) {
		AlgorithmsFactory algorithmFactory=new AlgorithmsFactory();
		algorithm = algorithmFactory.getAlgorithm(algorithmName);
		//this.notifyObservers();
	}
	//to play algorithm
	@Override
	public void solveDomain() {	
		solution = new Solution();
		solution.setProblemDescription(domain.getProblemDescription());
		//Check in HashMap of Solution Manager if the Solution inside him
//		if(SolutionManager.getInstance().getSolution(domain.getProblemDescription())!=null)
//		{
//		solution=SolutionManager.getInstance().getSolution(domain.getProblemDescription());
//		System.out.println("the Solution from Solution file");	
//		}
		//else{
		ArrayList<Action> actions = algorithm.saerch(domain); 
	    long startTimeMillis = System.nanoTime();//set the timer
	    solution.setAction(actions);
	    long endTimeMillis = System.nanoTime();
	    long time = endTimeMillis - startTimeMillis;//get the time to scream
	    solution.setTime(time);
	   //add the solution to HashMap of SolutionManager
	    SolutionManager.getInstance().addSolution(solution);
		//}
   }
	//get solution of the problem
	@Override
	public Solution getSolution() {	
		return solution;
	}
	@Override
	public void doTask() {
		solveDomain();
	}
}
