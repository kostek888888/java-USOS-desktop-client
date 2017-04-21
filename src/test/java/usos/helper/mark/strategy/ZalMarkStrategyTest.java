package usos.helper.mark.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

public class ZalMarkStrategyTest {
	
	ZalMarkStrategy zalMarkStrategy = new ZalMarkStrategy();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetStringMark() {
		assertEquals(zalMarkStrategy.getStringMark(new BigDecimal("2.2")), "ZAL");
		assertEquals(zalMarkStrategy.getStringMark(null), "ZAL");
	}

	@Test
	public void testGetValueMark() {
		assertEquals(zalMarkStrategy.getValueMark(null), null);
		assertEquals(zalMarkStrategy.getValueMark(new BigDecimal("4.2")), null);
	}

}
