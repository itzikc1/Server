package model;

import static org.junit.Assert.*;
import game.MazeGameDomain;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AstarTest {
	private Astar astar;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		astar=new Astar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaerch() {
		MazeGameDomain domain = new MazeGameDomain(5, 5, 0);
		ArrayList<Action> saerch = astar.saerch(domain);
		assertEquals(8, saerch.size());

	}

}
