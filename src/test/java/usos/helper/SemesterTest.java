package usos.helper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SemesterTest {
	
	static Semester semester = new Semester();
	static Subject testSubject;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testSubject = new Subject();
		testSubject.setName("trooooo");
	}

	@Test
	public void testGetSubjects() {
		assertNotNull(semester.getSubjects());
		assertEquals(semester.getSubjects().size(), 0);
		semester.addSubject(testSubject);
		assertEquals(semester.getSubjects().size(), 1);
		
	}

	@Test
	public void testAddSubject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

}
