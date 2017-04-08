package usos.helper.mark.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

public class NumeralMarkStrategyTest {
	
	NumeralMarkStrategy numeralMarkStrategy = new NumeralMarkStrategy();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetStringMark() {
		assertEquals(numeralMarkStrategy.getStringMark(new BigDecimal("2.2")), "2.2");
	}

	@Test
	public void testGetValueMark() {
		assertEquals(numeralMarkStrategy.getValueMark(new BigDecimal("3.2")), new BigDecimal("3.2"));
	}

}
