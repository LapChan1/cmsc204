package a6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Town_STUDENT_Test {
	Town t1,t2;

	@Before
	public void setUp() throws Exception {
		t1=new Town("a");
		t2=new Town("b");
	}

	@After
	public void tearDown() throws Exception {
		t1=t2=null;
	}


	@Test
	public void testCompareTo() {
		assertTrue(0==t1.compareTo(t1));
		assertTrue(0>t1.compareTo(t2));
	}

	@Test
	public void testEqualsTown() {
		assertTrue(t1.equals(new Town("a")));
		assertTrue(!t1.equals(t2));
	}

	@Test
	public void testGetName() {
		assertEquals("a",t1.getName());
		assertEquals("b",t2.getName());
	}

	@Test
	public void testToString() {
		assertEquals("a",t1.toString());
		assertEquals("b",t2.toString());
	}

}
