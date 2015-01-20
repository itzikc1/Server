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
			row = Integer.parseInt(EightPuzzleOrRow);
			col = Integer.parseInt(colNum);
			
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
		this.row=0;
		this.col=0;
		this.wall=" ";	
	}
}


//this.problem = problem;	
//String[] arr = problem.getDomainName().split(" ");
//int [][] mazeData1=new int[Integer.parseInt(arr[6])+1][Integer.parseInt(arr[7])+1];	
//       for(int k=11;k<arr.length-1;k++)
//       {	    			
//	    mazeData1[Integer.parseInt(arr[k])][Integer.parseInt(arr[k+1])]=1;		
//       }
//setMazeData(mazeData1);	
