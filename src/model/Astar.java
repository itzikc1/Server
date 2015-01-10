package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Astar extends SearchProblem {
	
	@Override
	  public ArrayList<Action> saerch(SearchDomain domain)  {
		State start=domain.getStartState();
		State goal=domain.getGoalState();	
	    start.setGprice(domain.GScore(start));		
	    start.setHprice(domain.HScore(start));		 
	    start.setPrice(start.getGprice()+start.getHprice());	    
	    openList.add(start);
	
		while (! openList.isEmpty())
		{		
			State starter= openList.poll();	
			
			if(starter.equals(goal))
			{
				ArrayList<Action> actions = generatePathToGoal(starter);	
				return actions;
			}
			closedList.add(starter);
			HashMap<Action, State> neighbours=domain.getAllPossibleMoves(starter);
		
			for (Action a : neighbours.keySet()) {
				State nextState=neighbours.get(a);//take the key a type action
				int tentative_g_score = domain.GScore(nextState);
				
				//nextState.setFprice
				if (closedList.contains(nextState) && tentative_g_score >=nextState.getGprice()) 
					continue;
				
				if (!openList.contains(nextState) || (tentative_g_score <= nextState.getGprice())) { 
					nextState.setParent(starter);
					nextState.setlastAction(a);
                    nextState.setGprice(tentative_g_score); 
					nextState.setPrice(domain.HScore(nextState)); 

					if (!openList.contains(nextState))
							openList.add(nextState);		
			    }			
		   }	
	   }
		return null;
	}
}
