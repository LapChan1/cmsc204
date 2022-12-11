package a6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Road_STUDENT_Test {
	Road r1,r2,r3;
	Town t1,t2,t3,t4;
	
	@Before
	public void setUp() throws Exception {
		t1=new Town("a");
		t2=new Town("b");
		t3=new Town("c");
		t4=new Town("d");
		
		r1=new Road(t1,t2,2,"Road 1");
		r2=new Road(t3,t4,3,"Road 2");
		r3=new Road(t2,t3,3,"Road 3");
		
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
		t1=t2=t3=t4=null;
	}


	@Test
	public void testCompareTo() {
		assertEquals(0,r1.compareTo(r1));
		assertEquals(-1,r1.compareTo(r2));
		assertEquals(1,r3.compareTo(r2));
	}

	@Test
	public void testContains() {
		assertTrue(r1.contains(t1)&&r1.contains(t2));
		assertFalse(r1.contains(t3)||r1.contains(t4));
	}

	@Test
	public void testEqualsObject() {
		assertTrue(r1.equals(r1));
		assertTrue(r1.equals(new Road(t1,t2,2,"Road 1")));
	}

	@Test
	public void testGetDestination() {
		assertTrue(t2.equals(r1.getDestination()));
		assertFalse(t2.equals(r1.getSource()));
		assertTrue(t4.equals(r2.getDestination()));
		assertTrue(t3.equals(r3.getDestination()));
	}

	@Test
	public void testGetName() {
		assertEquals("Road 1",r1.getName());
		assertEquals("Road 2",r2.getName());
		assertEquals("Road 3",r3.getName());
	}

	@Test
	public void testGetSource() {
		assertTrue(t1.equals(r1.getSource()));
		assertTrue(t3.equals(r2.getSource()));
		assertTrue(t2.equals(r3.getSource()));
	}

	@Test
	public void testGetWeight() {
		assertEquals(2,r1.getWeight());
		assertEquals(3,r2.getWeight());
		assertEquals(3,r3.getWeight());
	}

}
