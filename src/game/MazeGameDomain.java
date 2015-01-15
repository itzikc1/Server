package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import model.Action;
import model.SearchDomain;
import model.State;

public class MazeGameDomain implements SearchDomain{
	MazeGameState start,goal;
	public  MazeGameState [][] maze;
	private int row,coll;
	int numberOfWalls;
	//add to String the wall for the key in solution file
	public String wall1=null;
	public String getWall1() {
		return wall1;
	}
	public  MazeGameDomain(int row , int coll, int numberOfWalls)
	{
		this.numberOfWalls=numberOfWalls;
		this.row=row;
		this.coll=coll;
		maze=new MazeGameState[row][coll];
		createRandomMaze();
		createWallMaze();	
		start=maze[0][0];	
		goal=maze[row-1][coll-1];
	 System.out.println("\n");
	}
	public void createRandomMaze()
	{
		for(int i=0 ; i<row ; i++)
		{
			for(int j=0 ; j<coll ; j++)
			{
				System.out.print("|");
				maze[i][j]= new MazeGameState(i, j,String.valueOf(1));             
			}	
			System.out.println("");	
			}
	}		
	 public State getStartState() {	
		return start;
	}
	@Override
	public State getGoalState() {
		
		return goal;
	}
	//Create the All Possible Moves
	@Override
	public HashMap<Action, State> getAllPossibleMoves(State current) {
		HashMap<Action,State> moves=new  HashMap<>();		
		MazeGameState a=(MazeGameState)current;
		Action left=new Action("Left");
		Action right=new Action("Right");
		Action down=new Action("Down");
		Action up=new Action("Up");	
		if(current.getWall() == false)
		{	
		if(a.stateX>0)
		{
			moves.put(left, maze[a.stateX-1][a.stateY]);	
		}
		if (a.stateX<(coll-1))
		{		
			moves.put(right, maze[a.stateX+1][a.stateY]);
		}
		if (a.stateY>0 )
		{
			moves.put(up, maze[a.stateX][a.stateY-1]);
		}
		if (a.stateY<row-1)
		{
			moves.put(down, maze[a.stateX][a.stateY+1]);		
		}
		}	
		return moves;
 }
	//create Wall Maze
	public void createWallMaze()
	{	
		Random rand= new Random();
		int arr[]= new int[numberOfWalls];
		
		for (int i=0; i<arr.length;i++){
		int  n = rand.nextInt(coll);
		arr[i]=n;}		
		Arrays.sort(arr);	
		for (int i=0; i<arr.length;i++){
			int  n = rand.nextInt(coll);
			arr[i]=n;}
		
		int num=0;
		for (int i=0; i<arr.length;i++){
		maze[arr[i]][num++].setWall(true);
		//add to string the wall for the key in solution file
		this.wall1+=String.valueOf(arr[i]);
		this.wall1+=" ";
		this.wall1+=String.valueOf(num++);
		this.wall1+=" ";
		}		
	}
	@Override
	public int GScore(State current) {
		MazeGameState a=(MazeGameState)current;
		if(a.stateX>start.stateX)
			a.setHprice(a.getHprice()+a.stateX-start.stateX);
	    else a.setHprice(a.getHprice()+start.stateX-a.stateX);
			
			if(a.stateY>start.stateY)
				a.setHprice(a.getHprice()+a.stateY-start.stateY);
			else a.setHprice(a.getHprice()+start.stateY-a.stateY);
			
			if(a.equals(start))
				return 0;
			
			return a.getGprice();	
	}
 
	@Override
	public int HScore(State current) {
		MazeGameState a=(MazeGameState)current;
		if(a.stateX>goal.stateX)
			a.setHprice(a.getHprice()+a.stateX-goal.stateX);
	    else a.setHprice(a.getHprice()+goal.stateX-a.stateX);
			if(a.stateY>goal.stateY)
				a.setHprice(a.getHprice()+a.stateY-goal.stateY);
			else a.setHprice(a.getHprice()+goal.stateY-a.stateY);
		if(a.equals(goal))
			return 0;		
					return a.getHprice();
	   }
	//Create the key for this specific maze 
	@Override
	public String getProblemDescription() {
		return "start State:" + getStartState().stateToString() + ",final State:" + getGoalState().stateToString() + ",walls State:" + getWall1() ;
		
	}
}