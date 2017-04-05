package usos.helper;

import java.math.BigDecimal;

public class Mark {
	
	public enum Status {
		MARK_NUMERAL, 
		MARK_NB, 
		MARK_ZAL,
		MARK_EMPTY
	}
	
	private BigDecimal numeralMark;
	private Status status;
	
	
	public BigDecimal getNumeralMark() {
		
		switch (status) {
	        case MARK_NUMERAL:
	            System.out.println("Mondays are bad.");
	            break;
	                
	        case MARK_NB:
	            System.out.println("Fridays are better.");
	            break;
	                     
	        case MARK_ZAL: 
	            break;
	            
	        case MARK_EMPTY: 
	            break;  
	            
	        default:
	            //throw new UnsupportedOperationException();
	            break;
		}
		
		return null;
	}
	
	
}
