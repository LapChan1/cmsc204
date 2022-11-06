package a4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseDBElementStudentTest {
	CourseDBElement CDBE1,CDBE2;
	
	@Before
	public void setUp() throws Exception {
		CDBE1 = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular");
		CDBE2 = new CourseDBElement("CMSC500", 40000, 4, "SC100", "Nobody InParticular");
	}

	@After
	public void tearDown() throws Exception {
		CDBE2=CDBE1=null;
	}

	@Test
	public void testCompareTo() {
		assertTrue(CDBE1.compareTo(CDBE1)==0);
		assertTrue(CDBE2.compareTo(CDBE1)==1);
		assertTrue(CDBE1.compareTo(CDBE2)==-1);
		
	}

}
