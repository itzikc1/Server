package model;

public abstract class State implements Comparable<State> {

	public Action lastAction;
	public State parent;
	// /// for maze ,rigth,Left
	public boolean wall = false;
	public String matrix;

	private int Gmatrix, Hmatrix = 0;
	int price = 1;

	public State(String matrix) {

		this.matrix = matrix;
	}

	public boolean getWall() {
		return wall;

	}

	public void setWall(boolean wall) {

		this.wall = wall;
	}

	public int getPrice() {

		return this.price;
	}

	public void setPrice(int newPathprice) {

		this.price = newPathprice;
		// String.valueOf(newPathmatrix)
	}

	public void setParent(State parentt) {
		parent = parentt;
	}

	public State getParent() {
		return parent;
	}

	public Action getLastAction() {
		return lastAction;
	}

	public void setlastAction(Action a) {
		this.lastAction = a;
	}

	@Override
	public String toString() {
		return this.matrix;
	}

	public void setGprice(int start) {

		this.Gmatrix = start;

	}

	public void setHprice(int goal) {

		this.Hmatrix = goal;

	}

	public int getHprice() {

		return Hmatrix;
	}

	public int getGprice() {

		return Gmatrix;
	}

	public int getMatrix() {
		return Integer.parseInt(matrix);
	}

	public void setMatrix(String nextState) {
		this.matrix = nextState;

	}
public abstract String stateToString();
}

