package usos.helper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import usos.helper.TypeOfClass;
import usos.helper.mark.Mark;
import usos.helper.mark.strategy.NumeralMarkStrategy;

public class TypeOfClassTest {

	TypeOfClass typeOfClass = new TypeOfClass();
	static Mark exampleMark = new Mark(new NumeralMarkStrategy());
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		exampleMark.setNumeralMark(new BigDecimal("3.0"));
	}

	@Test
	public void testAddOldMarks() {
		assertEquals(typeOfClass.getOldMarks().size(), 0);
		
		typeOfClass.addOldMarks(exampleMark);
		List<Mark> oldMarks = typeOfClass.getOldMarks();
		
		assertEquals(oldMarks.get(oldMarks.size()-1), exampleMark);
		assertEquals(typeOfClass.getOldMarks().size(), 1);
	}

	@Test
	public void testGetOldMarks() {
		assertEquals(typeOfClass.getOldMarks().size(), 0);
		typeOfClass.addOldMarks(exampleMark);
		assertEquals(typeOfClass.getOldMarks().size(), 1);
		assertEquals(typeOfClass.getOldMarks().get(0), exampleMark);
		
	}

	@Test
	public void testGetMainMark() {
		assertEquals(typeOfClass.getMainMark(), null);
		
		typeOfClass.setMainMark(exampleMark);
		assertEquals(typeOfClass.getMainMark(), exampleMark);
	}

	@Test
	public void testSetMainMark() {
		typeOfClass.setMainMark(exampleMark);
		assertEquals(typeOfClass.getMainMark(), exampleMark);
	}

	@Test
	public void testGetName() {
		typeOfClass.setName("trolooo");
		
		assertEquals(typeOfClass.getName(), "trolooo");
	}

	@Test
	public void testSetName() {
		typeOfClass.setName("trolooo");
		
		assertEquals(typeOfClass.getName(), "trolooo");
	}

}
