package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class NzalMarkStrategy implements MarkStrategyInterface {
	
	public final static String MARK_NZAL_STRING = "NZAL";
	
	public String getStringMark(BigDecimal numeralMark) {
		return MARK_NZAL_STRING;
	}

	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return null;
	}


}
