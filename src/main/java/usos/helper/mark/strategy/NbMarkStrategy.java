package usos.helper.mark.strategy;

import java.math.BigDecimal;

public class NbMarkStrategy implements MarkStrategyInterface {
	
	public final static String MARK_NB_STRING = "NB";
	private BigDecimal markNbValue;
	
	public NbMarkStrategy() {
		markNbValue =  new BigDecimal("2"); 
	}
	
	public String getStringMark(BigDecimal numeralMark) {
		return MARK_NB_STRING;
	}

	public BigDecimal getValueMark(BigDecimal numeralMark) {
		return markNbValue; 
	}

}
