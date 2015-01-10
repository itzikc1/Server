package model;
import game.*;


public class DomainFactory {
	private int row,col,wall;
	/*DomainName it for the name of Domain and all the other parameter for began */
	public SearchDomain getDomain (String DomainName)
	{
		String[] arr = DomainName.split(" ");
		String domainName = arr[0];
		String EightPuzzleOrRow = arr[1];
		String colNum = arr[2];
		String wallNum = arr[3];
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
}

