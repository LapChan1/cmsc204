package a4;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import a4.CourseDBStructure.Node;

public class CourseDBStructureStudentTest {
	CourseDBStructure cds, testStructure;
	CourseDBElement E1,E2,E3;

	@Before
	public void setUp() throws Exception {
		cds = new CourseDBStructure(20);

		E1 = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular");
		E2 = new CourseDBElement("CMSC100", 25410, 2, "SA2", "N2");
		
		cds.add(E1);
		cds.add(E2);
		
	}

	@After
	public void tearDown() throws Exception {
		cds = null;
		E1=E2=E3=null;
	}

	@Test
	public void testAdd() {
		assertTrue(cds.showAll().size()==2);
		
	}


}
