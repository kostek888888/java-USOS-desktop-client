package usos.helper.mark;

import java.math.BigDecimal;

import usos.helper.mark.strategy.MarkStrategyInterface;
import usos.helper.mark.strategy.NzalMarkStrategy;

public class Mark {
	
	private MarkStrategyInterface markStrategy;
	private BigDecimal numeralMark;
	
	public Mark(MarkStrategyInterface markStrategy) {
		this.markStrategy = markStrategy;
	}

	public void setNumeralMark(BigDecimal numeralMark) {
		this.numeralMark = numeralMark;
	}
	
	public String getStringMark() {
		return markStrategy.getStringMark(numeralMark);
	}
	
	public BigDecimal getValueMark() {
		return markStrategy.getValueMark(numeralMark);
	}
	
	public MarkStrategyInterface getMarkStrategy() {
		return this.markStrategy;
	}
	
}
