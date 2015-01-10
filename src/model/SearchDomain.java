package model;

import java.util.HashMap;

public interface SearchDomain  {
	//define the problem of the game
	public State getStartState() ;
	public State getGoalState();	
	public HashMap<Action, State> getAllPossibleMoves(State state) ;
	//////////A star Parameters////////////////////////////////////
	public int HScore(State current);
	public int GScore(State current);
	//////////////Defined the key for this solution game////////////////
	String getProblemDescription();
	

}
