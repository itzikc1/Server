package game;

import model.State;

public class EightPuzzleState extends State{

	public EightPuzzleState(String matrix ) {
		super(matrix );		
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
		 if(object instanceof State && (((EightPuzzleState)object).getMatrix()==this.getMatrix())){
		     return true;
		 }
		  else {
		     return false;
		 }
	 }
	@Override
	public String stateToString() {//to do	
		return matrix;
	}
    
}
