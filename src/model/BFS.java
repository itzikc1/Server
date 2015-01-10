package model;

import java.util.ArrayList;
import java.util.HashMap;

	public class BFS extends SearchProblem {
		
    public ArrayList<Action> saerch (SearchDomain domain) {
    	        //solve the problem end get the price of all state
    			//public State start=domain.getStartState();
    			//private State goal=domain.getGoalState();	
			this.openList.add((State) domain.getStartState());	
			//start.setPrice(1);
			while (!openList.isEmpty())
			{			
				State state = openList.poll();
				
				closedList.add(state);
				if (state.equals(domain.getGoalState()) )
				{	
					ArrayList<Action> actions = generatePathToGoal(state);			    
					return actions;
				}				
				//next States is started whit start hash map
				HashMap<Action, State> nextStates = domain.getAllPossibleMoves(state);
				//go on all key action and check all the neighbors
				for (Action a : nextStates.keySet())
					// this point get new state in to the list end came 1
				{
					State nextState = nextStates.get(a);
					int newPathPrice = state.getPrice() + a.getAction();
					//check if the nextState already in open/close list
					if (!openList.contains(nextState) && !closedList.contains(nextState))
					{					
						nextState.setParent(state);
						nextState.setlastAction(a);
						nextState.setPrice(newPathPrice);
						openList.add(nextState);
					}
					else
					{			
						//if the nextState in list check the price end delete the bigger
						if (newPathPrice < nextState.getPrice())
						{
							if (!openList.contains(nextState))
								openList.add(nextState);
							else {
								nextState.setPrice(newPathPrice);
							}		
						}
					}		
				}				
			}	
			return null;
		}
	}
		
		
