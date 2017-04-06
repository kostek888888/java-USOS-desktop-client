package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class ZalMarkStrategy implements MarkStrategyInterface {
	
	public final static String MARK_ZAL_STRING = "ZAL";
	
	public String getStringMark(BigDecimal numeralMark) {
		return MARK_ZAL_STRING;
	}

	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return null;
	}


}
