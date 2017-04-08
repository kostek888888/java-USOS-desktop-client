package usos.helper.mark;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import usos.helper.mark.strategy.MarkStrategyInterface;
import usos.helper.mark.strategy.NbMarkStrategy;
import usos.helper.mark.strategy.NumeralMarkStrategy;
import usos.helper.mark.strategy.ZalMarkStrategy;

public class MarkFactoryTest {
	
	static MarkFactory markFactory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		markFactory = new MarkFactory();
		
	}

	@Test
	public void testCreateMarkByUsosString() {
		
		Mark markZal = markFactory.createMarkByUsosString("ZAL");
		assertNotNull(markZal);
		assertTrue( markZal.getMarkStrategy() instanceof ZalMarkStrategy);
		
		Mark markZal2 = markFactory.createMarkByUsosString("( ZAL )");
		assertNotNull(markZal2);
		assertTrue( markZal2.getMarkStrategy() instanceof ZalMarkStrategy);
		
		Mark markNb = markFactory.createMarkByUsosString(" NB");
		assertNotNull(markNb);
		assertTrue( markNb.getMarkStrategy() instanceof NbMarkStrategy);
		
		Mark markNb2 = markFactory.createMarkByUsosString("(NB) ");
		assertNotNull(markNb2);
		assertTrue( markNb2.getMarkStrategy() instanceof NbMarkStrategy);
		
		Mark markNumeral = markFactory.createMarkByUsosString("2.5");
		assertNotNull(markNumeral);
		assertTrue( markNumeral.getMarkStrategy() instanceof NumeralMarkStrategy);
		
		Mark markNumeral2 = markFactory.createMarkByUsosString("( 2. 5)");
		assertNotNull(markNumeral2);
		assertTrue( markNumeral2.getMarkStrategy() instanceof NumeralMarkStrategy);
		
	}

	@Test
	public void testMarkIsMainMark() {
		assertEquals(markFactory.markIsMainMark("2.5"), true);
		assertEquals(markFactory.markIsMainMark("NB"), true);
		assertEquals(markFactory.markIsMainMark("ZAL"), true);
		assertEquals(markFactory.markIsMainMark("(ZAL)"), false);
		
		
		
		
	}

}
