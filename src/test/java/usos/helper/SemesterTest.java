package usos.helper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SemesterTest {
	
	static Semester semester;
	static Subject testSubject;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		semester = new Semester();
		testSubject = new Subject();
		testSubject.setName("trooooo");
	}

	@Test
	public void testGetSubjects() {
		assertNotNull(semester.getSubjects());
		semester.getSubjects().clear();
		assertEquals(semester.getSubjects().size(), 0);
		semester.addSubject(testSubject);
		assertEquals(semester.getSubjects().size(), 1);
		
	}

	@Test
	public void testAddSubject() {
		semester.getSubjects().clear();
		assertEquals(semester.getSubjects().size(), 0);
		semester.addSubject(testSubject);
		assertEquals(semester.getSubjects().size(), 1);
	}

	@Test
	public void testGetName() {
		assertEquals(testSubject.getName(), "trooooo");
	}

	@Test
	public void testSetName() {
		semester.setName("test");
		assertEquals(semester.getName(), "test");
	}

}
