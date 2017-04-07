package usos.helper.mark;

import java.math.BigDecimal;

import usos.helper.mark.strategy.NbMarkStrategy;
import usos.helper.mark.strategy.NumeralMarkStrategy;
import usos.helper.mark.strategy.ZalMarkStrategy;

public class MarkFactory {
	
	public Mark createMarkByUsosString(String markString) {
		
		markString = markString.replace("(", "");
		markString = markString.replace(")", "");
		markString = markString.replace(",", ".");
		markString = markString.trim();
		
		if(markString.equals("NB")) {
			return new Mark(new NbMarkStrategy());
		} else if(markString.equals("ZAL")) {
			return new Mark(new ZalMarkStrategy());
		} else {
			Mark mark = new Mark(new NumeralMarkStrategy());
			mark.setNumeralMark(new BigDecimal(markString));
			return mark;
		}
	}
	
	public boolean markIsMainMark(String markString) {
		return (markString.startsWith("(") != true);
	}
	
}
