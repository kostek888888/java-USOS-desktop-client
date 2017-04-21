package usos.helper;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SubjectTest {

	Subject subject = new Subject();
	TypeOfClass exampleTypeOfClass = new TypeOfClass();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testAddTypeOfClass() {
		
		assertEquals(subject.getTypesOfClass().size(), 0);
		subject.addTypeOfClass(TypeOfClass.type.LECTURE, exampleTypeOfClass);
		assertEquals(subject.getTypesOfClass().size(), 1);
		assertEquals(subject.getTypesOfClass().get(TypeOfClass.type.LECTURE), exampleTypeOfClass);
	}

	@Test
	public void testGetTypesOfClass() {
		assertEquals(subject.getTypesOfClass().size(), 0);
		subject.addTypeOfClass(TypeOfClass.type.LECTURE, exampleTypeOfClass);
		assertEquals(subject.getTypesOfClass().size(), 1);
		assertEquals(subject.getTypesOfClass().get(TypeOfClass.type.LECTURE), exampleTypeOfClass);
	}

	@Test
	public void testGetName() {
		assertNull(subject.getName());
		subject.setName("trol");
		assertEquals(subject.getName(), "trol");
	}

	@Test
	public void testSetName() {
		assertNull(subject.getName());
		subject.setName("trol");
		assertEquals(subject.getName(), "trol");
	}

}
