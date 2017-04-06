package usos.helper.mark.strategy;

import java.math.BigDecimal;

/**
 * Wzorzec projektowy strategy.
 *
 */
public interface MarkStrategyInterface {
	
	public String getStringMark(BigDecimal numeralMark);
	
	/**
	 * zwraca wartość oceny, używanej np do obliczania średniej
	 * @return BigDecimal UWAGA! DOZWOLONY NULL !
	 */
	public BigDecimal getValueMark(BigDecimal numeralMark);
}
