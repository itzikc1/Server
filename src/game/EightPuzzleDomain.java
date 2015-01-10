package game;

import java.util.HashMap;
import java.util.Random;
import model.Action;
import model.SearchDomain;
import model.State;

public class EightPuzzleDomain implements SearchDomain {
	private String problem;// Problem Description
	private EightPuzzleState start;
	private EightPuzzleState goal = new EightPuzzleState("012345678");

	public EightPuzzleDomain(String matrix) {
		this.problem = matrix;
		this.start = new EightPuzzleState(matrix);
		System.out.println("\n");
	}

	@Override
	public State getStartState() {
		return start;
	}

	@Override
	public State getGoalState() {
		return goal;
	}

	@Override
	public HashMap<Action, State> getAllPossibleMoves(State current) {
		HashMap<Action, State> moves = new HashMap<>();
		Action up = new Action(current + "1");
		Action down = new Action(current + "2");
		Action right = new Action(current + "3");
		Action left = new Action(current + "4");
		int a = current.matrix.indexOf("0");

		if (a > 2) {

			String nextState = String.valueOf(current.getMatrix()).substring(0,
					a - 3)
					+ "0"
					+ String.valueOf(current.getMatrix()).substring(a - 2, a)
					+ String.valueOf(current.getMatrix()).charAt(a - 3)
					+ String.valueOf(current.getMatrix()).substring(a + 1);
			EightPuzzleState nextCurrentUp = new EightPuzzleState(nextState);

			moves.put(up, nextCurrentUp);

		}

		if (a != 0 && a != 3 && a != 6) {

			String nextState = String.valueOf(current.getMatrix()).substring(0,
					a - 1)
					+ "0"
					+ String.valueOf(current.getMatrix()).charAt(a - 1)
					+ String.valueOf(current.getMatrix()).substring(a + 1);

			EightPuzzleState nextCurrentLeft = new EightPuzzleState(nextState);

			moves.put(left, nextCurrentLeft);

		}

		if (a < 6) {

			String nextState;
			if (a != 0) {
				nextState = String.valueOf(current.getMatrix()).substring(0, a)
						+ String.valueOf(current.getMatrix()).substring(a + 3,
								a + 4)
						+ String.valueOf(current.getMatrix()).substring(a + 1,
								a + 3) + "0"
						+ String.valueOf(current.getMatrix()).substring(a + 4);
			} else {
				nextState = String.valueOf(current.getMatrix()).substring(0, a)
						+ String.valueOf("0" + current.getMatrix()).substring(
								a + 3, a + 4)
						+ String.valueOf("0" + current.getMatrix()).substring(
								a + 1, a + 3)
						+ "0"
						+ String.valueOf("0" + current.getMatrix()).substring(
								a + 4);
			}
			EightPuzzleState nextCurrentDown = new EightPuzzleState(nextState);

			moves.put(down, nextCurrentDown);

		}

		if (a != 2 && a != 5 && a != 8) {

			String nextState;
			if (a != 0) {
				nextState = String.valueOf(current.getMatrix()).substring(0, a)
						+ String.valueOf(current.getMatrix()).charAt(a + 1)
						+ "0"
						+ String.valueOf(current.getMatrix()).substring(a + 2);
			} else {
				nextState = String.valueOf("0" + current.getMatrix())
						.substring(0, a)
						+ String.valueOf("0" + current.getMatrix()).charAt(
								a + 1)
						+ "0"
						+ String.valueOf("0" + current.getMatrix()).substring(
								a + 2);
			}
			EightPuzzleState nextCurrentRight = new EightPuzzleState(nextState);

			moves.put(right, nextCurrentRight);

		}

		return moves;
	}

	@Override
	public int HScore(State current) {

		EightPuzzleState a = (EightPuzzleState) current;
		if (a.getMatrix() > start.getMatrix())
			a.setHprice(a.getHprice() + a.getMatrix() - start.getMatrix());
		else
			a.setHprice(a.getHprice() + start.getMatrix() - a.getMatrix());

		if (a.getMatrix() > start.getMatrix())
			a.setHprice(a.getHprice() + a.getMatrix() - start.getMatrix());
		else
			a.setHprice(a.getHprice() + start.getMatrix() - a.getMatrix());

		if (a.equals(start))
			return 0;

		return a.getGprice();

	}

	@Override
	public int GScore(State current) {
		EightPuzzleState a = (EightPuzzleState) current;
		if (a.getMatrix() > goal.getMatrix())
			a.setHprice(a.getHprice() + a.getMatrix() - goal.getMatrix());
		else
			a.setHprice(a.getMatrix() + goal.getMatrix() - a.getMatrix());

		if (a.getMatrix() > goal.getMatrix())
			a.setHprice(a.getHprice() + a.getMatrix() - goal.getMatrix());
		else
			a.setHprice(a.getHprice() + goal.getMatrix() - a.getMatrix());

		if (a.equals(goal))
			return 0;

		return a.getHprice();
	}

	@Override
	public String getProblemDescription() {
		return this.problem;
	}

}
