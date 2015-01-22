package game;

import java.util.Scanner;
import model.State;
public class MazeGameState extends State{
	int stateX,stateY;
	//private String input;
	public MazeGameState(int stateX,int stateY,String price ) {		
		super(price);
		this.stateX=stateX;
		this.stateY=stateY;
	
	}
	public int getStateX()
	{
		return this.stateX;		
	}
	
	public int getStateY()
	{
		return this.stateY;	
	}
	@Override
	public int compareTo(State state) {
		if(this.getPrice()>state.getPrice())
		return 1;
		
		if(this.getPrice()<state.getPrice())
			return -1;
		else return 0;
	}
	@Override
	public boolean equals(Object object){
		 if(object instanceof State && (((MazeGameState)object).stateX==this.stateX )&& ((MazeGameState)object).stateY==this.stateY){
		     return true;
		 }
		  else {
		     return false;
		 }
	 }
	//convert state To String
	@Override
	public String stateToString() {
		String sStateX=String.valueOf(stateX);
		String sStatey=String.valueOf(stateY);
		return sStateX+" "+sStatey;
	}	
}
