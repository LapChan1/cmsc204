package JunitLab;

import static org.junit.Assert.*;
 

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GradeBookTest {
private GradeBook GB1, GB2,GB3;

	@Before
	public void setUp() throws Exception{ 
		GB1 = new GradeBook(5);
		GB2 = new GradeBook(5);
		GB3 = new GradeBook(0);
		
		for (int n=0;n<3;n++) 
			GB1.addScore(75.5);

		GB2.addScore(90);
		GB2.addScore(70);
		GB2.addScore(100);
	}
	

	@After
	public void teardown() throws Exception{
		GB1=GB2=GB3=null;
	}

	/**
	 * test if scores are correctly added by the content and size of scores[] of gradebook
	 */
	@Test
	public void testAddScore() {
		assertTrue(GB1.toString().equals("75.5 75.5 75.5 "));
		assertEquals(3, GB1.getScoresSize());
		
		assertTrue(GB2.toString().equals("90.0 70.0 100.0 "));
		assertEquals(3, GB2.getScoresSize());
		
		assertTrue(GB3.toString().equals(""));
		assertEquals(0, GB3.getScoresSize());

		assertEquals(false, GB3.addScore(6));
	}
	
	/**
	 * check if the sum is correct
	 */
	@Test 
	public void testSum() {
		assertEquals(75.5*3,GB1.sum(),.0001);
		assertEquals(260,GB2.sum(),.0001);
	}

	/**
	 * check if minimum value is return
	 */
	@Test 
	public void testMinimum() {
		assertEquals(75.5,GB1.minimum(),.0001);
		assertEquals(70,GB2.minimum(),.0001);
	}
	
	/**
	 * check if the finalScore equal to the sum of the values minus the minimum when there are 2 or more scores
	 * check if the method return 0 when there are no score
	 */
	@Test 
	public void testFinalScore() {
		assertEquals(151, GB1.finalScore(),.0001);
		assertEquals(190, GB2.finalScore(),.0001);
		assertEquals(0, GB3.finalScore(),.0001);
	}
}
