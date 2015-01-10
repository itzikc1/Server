package model;

import java.util.Observer;
import task.*;

public interface Model extends Task{
	void selectDomain(String domainName);//select the specific problem
	void selectAlgorithm(String algorithmName);//select the algorithm to solve the problem
	void solveDomain();//to play algorithm
	Solution getSolution();//get solution of the problem
	void addObserver(Observer o);
}	


