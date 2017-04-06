package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class NbMarkStrategy implements MarkStrategyInterface {
	
	public final static String MARK_NB_STRING = "NB";
	public final static BigDecimal MARK_NB_VALUE = new BigDecimal('2');
	
	public String getStringMark(BigDecimal numeralMark) {
		return MARK_NB_STRING;
	}

	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return MARK_NB_VALUE;
	}

}
