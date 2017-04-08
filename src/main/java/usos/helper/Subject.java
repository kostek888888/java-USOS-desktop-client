package usos.helper;

import java.util.ArrayList;
import java.util.List;

import usos.helper.mark.Mark;

public class Subject {
	
	private String name;
	
	private List<TypeOfClass> typesOfClass = new ArrayList<TypeOfClass>();
	
	public void addTypeOfClass(TypeOfClass typeOfClass) {
		this.typesOfClass.add(typeOfClass);
	}
	
	public List<TypeOfClass> getTypesOfClass() {
		return typesOfClass;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
