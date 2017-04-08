package usos.helper.mark.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.Test;

public class NbMarkStrategyTest {

	NbMarkStrategy nbMarkStrategy = new NbMarkStrategy();

	@Test
	public void testGetStringMark() {
		
		assertEquals(nbMarkStrategy.getStringMark(new BigDecimal("2.2")), "NB");
		assertEquals(nbMarkStrategy.getStringMark(null), "NB");
	}

	@Test
	public void testGetValueMark() {
		assertEquals(nbMarkStrategy.getValueMark(null), new BigDecimal("2"));
		assertEquals(nbMarkStrategy.getValueMark(new BigDecimal("4.2")), new BigDecimal("2"));
	}

}
