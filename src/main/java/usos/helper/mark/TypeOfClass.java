package usos.helper.mark;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Rodzaj zajęć (wykłady, laboratoria itp)
 */
public class TypeOfClass {
	
	private String name;
	
	private Mark mainMark;
	
	private List<Mark> oldMarks = new ArrayList<Mark>();
	
	public void addOldMarks(Mark mark) {
		oldMarks.add(mark); 
	}
	
	public List<Mark> getOldMarks() {
		return this.oldMarks;
	}
	
	public Mark getMainMark() {
		return this.mainMark;
	}

	public void setMainMark(Mark mainMark) {
		this.mainMark = mainMark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
