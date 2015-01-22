package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public abstract class SearchProblem implements Searcher {
	 protected HashSet<State> closedList;
	 PriorityQueue<State> openList;
		 private int evaluatedNodes;
		 public SearchProblem() {
		  openList=new PriorityQueue<State>();
		  closedList=new HashSet<State>();
		  evaluatedNodes=0;
		 }
///////////////////////////open/close set////////////////////////
		 protected void addToOpenList(State s) {
		  openList.add(s);
		  evaluatedNodes++;
		 }
		 public int getNumberOfNodesEvaluated() {
		  return evaluatedNodes;
		 }
		 protected ArrayList<Action> generatePathToGoal(State state) {
				ArrayList<Action> Action = new ArrayList<Action>();
				ArrayList<Action> Actiontamp = new ArrayList<Action>();
				do {
					Action.add(state.lastAction);
					state = state.parent;
				} while (state.parent != null);			
				
				for(int i=Action.size();i>0;i--)
				{
					Actiontamp.add(Action.get(i-1));
				}
				return Actiontamp;
			}	
}


