package model;

import java.io.Serializable;



public class Action implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String action;//name of Description action
	
	public Action( String action )
	{	
		this.action=action;	
		
	}
	 public String getActionName() {		
			return action;
		}
	 public int getAction() {
		return 1;
	}
	 public void setAction(String action){
		 
		 this.action=action;
	 }
     public void setActionPrice(int actionPrice){
		 
		 this.action=String.valueOf(actionPrice);
	 }
     @Override
 	public int hashCode() {
 		
 		return action.hashCode();
 	}
}

	
