package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class NoMarkStrategy implements MarkStrategyInterface {

	public final static String MARK_NO_MARK_STRING = "BRAK OCEN";
	
	public String getStringMark(BigDecimal numeralMark) {
		return MARK_NO_MARK_STRING;
	}
	
	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return null;
	}
	
}
