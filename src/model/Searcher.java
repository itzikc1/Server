package model;

import java.util.ArrayList;

public interface Searcher {
	int getNumberOfNodesEvaluated();
	public ArrayList<Action> saerch (SearchDomain domain); 

}
