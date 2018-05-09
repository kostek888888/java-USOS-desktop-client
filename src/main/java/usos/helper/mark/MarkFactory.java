package usos.helper.mark;

import java.math.BigDecimal;

import usos.helper.mark.strategy.NbMarkStrategy;
import usos.helper.mark.strategy.NoMarkStrategy;
import usos.helper.mark.strategy.NumeralMarkStrategy;
import usos.helper.mark.strategy.NzalMarkStrategy;
import usos.helper.mark.strategy.ZalMarkStrategy;

public class MarkFactory {
	
	public Mark createMarkByUsosString(String markString) {
		
		markString = markString.replace("(", "");
		markString = markString.replace(")", "");
		markString = markString.replace(",", ".");
		markString = markString.replace(" ", "");
		markString = markString.trim();
		
		if(markString.equals("NB")) {
			return new Mark(new NbMarkStrategy());
		} else if(markString.equals("ZAL")) {
			return new Mark(new ZalMarkStrategy());
		} else if(markString.equals("NZAL")) {
			return new Mark(new NzalMarkStrategy());
		} else if (markString.equals("brakocen")) {
			System.out.println("brak oceny");
			return new Mark(new NoMarkStrategy());
		} else {
			Mark mark = new Mark(new NumeralMarkStrategy());
			mark.setNumeralMark(new BigDecimal(markString));
			return mark;
		}
	}
	
	public boolean markIsMainMark(String markString) { // sprawdzenie czy ocena jest ocena glowna np (3) 4 - ocena glowna to 4
		if(markString.startsWith("(") != true) {
			return true; // jesli ocena jest glowna zwroc true
		} else {
			if(markString.contains("brak")) {
				return true; // jesli ocena moze nie byc glowna ale zawiera "brak" to jednak nia jest wiec zwroc true
			} else {
				return false; // ocena na pewno nie jest glowna zwroc false
			}
		}
	}
	
}
