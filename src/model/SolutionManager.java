package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SolutionManager {
	private HashMap<String, Solution> solutionsMap;
	private static SolutionManager instance = null;
	private static final String FILE_NAME = "solutions.dat";// Create file
															// solutions.dat for
															// all solutions
															// until

	protected SolutionManager() {
		solutionsMap = new HashMap<String, Solution>();// HashMap of action with
														// solutions
	}

	public static SolutionManager getInstance() {
		if (instance == null) {
			instance = new SolutionManager();
		}
		return instance;
	}

	// add Solution to HashMap of action
	public void addSolution(Solution solution) {
		solutionsMap.put(solution.getProblemDescription(), solution);
	}

	// get Solution from HashMap of action
	public Solution getSolution(String problemDescription) {
		return solutionsMap.get(problemDescription);
	}

	// add Solution to file solutions.dat
	public void saveSolutionsInFile() {
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			out = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(out);
			oos.writeObject(solutionsMap);
			// if File Not Found
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// get Solution file
	public void openSolutionsInFile() {
		FileInputStream in = null;
		ObjectInputStream is = null;
		try {
			in = new FileInputStream(FILE_NAME);
			is = new ObjectInputStream(in);
			solutionsMap = (HashMap<String, Solution>) is.readObject();
			// if File Not Found
		} catch (FileNotFoundException e) {
			saveSolutionsInFile();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("no file open");
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
