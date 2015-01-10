package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Solution implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long time;
	private String problemDescription;//Defined the key for Solutions in solutions.dat
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	private ArrayList<Action> action;	//create array of action
	//return action to Solution
	public ArrayList<Action> getAction()
	{
		return action;	
	}	
	public ArrayList<Action> setAction(ArrayList<Action> action )
	{
		return this.action=action;	
	}
	/////////////get the Defined key for Solutions//////////////////////
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	
}
