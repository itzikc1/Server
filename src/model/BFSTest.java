package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.MazeGameDomain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BFSTest {
    private BFS bfs;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bfs = new BFS();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaerch() {
		MazeGameDomain domain = new MazeGameDomain(5, 5,"0");
		ArrayList<Action> saerch = bfs.saerch(domain);
		assertEquals(8, saerch.size());
		
	}

}
