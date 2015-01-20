package model;
import game.*;


public class DomainFactory {
	private int row,col;
	private String wall;
	private String  colNum,EightPuzzleOrRow;
	/*DomainName it for the name of Domain and all the other parameter for began */
	public SearchDomain getDomain (String DomainName)
	{
		settingNull();		
		String[] arr = DomainName.split(" ");
		String domainName = arr[0];
		if (arr.length >= 3) {
			EightPuzzleOrRow = arr[7];
			colNum = arr[8];
			for(int i=12;i<arr.length;i++)
			wall += arr[i]+" ";
		
		}
		else{
			EightPuzzleOrRow = arr[1];
		}
		//start the maze
		if (domainName.equalsIgnoreCase("maze"))
		{
			row += Integer.parseInt(EightPuzzleOrRow);
			col += Integer.parseInt(colNum);
			
			return new MazeGameDomain(row,col,wall);//enter the number to start Maze
		}
		if(domainName.equalsIgnoreCase("EightPuzzle"))
		{
			return new EightPuzzleDomain(EightPuzzleOrRow);		
		}
		return null;	
	}
	private void settingNull(){
		this.colNum=null;
		this.EightPuzzleOrRow=null;
		this.row=1;
		this.col=1;
		this.wall=" ";	
	}
}



