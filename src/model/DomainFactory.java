package model;
import game.*;


public class DomainFactory {
	private int row,col,wall;
	private String  colNum,EightPuzzleOrRow,wallNum;
	/*DomainName it for the name of Domain and all the other parameter for began */
	public SearchDomain getDomain (String DomainName)
	{
		settingNull();		
		String[] arr = DomainName.split(" ");
		String domainName = arr[0];
		if (arr.length >= 3) {
			EightPuzzleOrRow = arr[1];
			colNum = arr[2];
			wallNum = arr[3];			
		}
		else{
			EightPuzzleOrRow = arr[1];
		}
		//start the maze
		if (domainName.equalsIgnoreCase("maze"))
		{
			row = Integer.parseInt(EightPuzzleOrRow);
			col = Integer.parseInt(colNum);
			wall =Integer.parseInt(wallNum);
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
		this.wallNum=null;
		this.row=0;
		this.col=0;
		this.wall=0;	
	}
}

