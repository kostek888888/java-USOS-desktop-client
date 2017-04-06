package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class NumeralMarkStrategy implements MarkStrategyInterface {

	public String getStringMark(BigDecimal numeralMark) {
		return numeralMark.toString();
	}

	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return numeralMark;
	}



}
