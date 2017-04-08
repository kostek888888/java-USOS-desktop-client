package usos.helper.mark;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import usos.helper.mark.strategy.NumeralMarkStrategy;

public class MarkTest {
	
	static Mark mark;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mark = new Mark(new NumeralMarkStrategy());
	}

	@Test
	public void testSetNumeralMark() {
		mark.setNumeralMark(new BigDecimal("4.5"));
		
		assertEquals(mark.getStringMark(), "4.5");
	}

	@Test
	public void testGetStringMark() {
		mark.setNumeralMark(new BigDecimal("2"));
		
		assertEquals(mark.getStringMark(), "2");		
	}

	@Test
	public void testGetValueMark() {
		mark.setNumeralMark(new BigDecimal("2.5"));
		
		assertEquals(mark.getValueMark(), new BigDecimal("2.5"));		
	}

}
