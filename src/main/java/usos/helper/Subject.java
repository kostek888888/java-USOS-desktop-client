package usos.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usos.helper.mark.Mark;

public class Subject {
	
	private String name;
	
	//Map<String, Integer> Oceny = new HashMap<String, Integer>();
	private Map<TypeOfClass.type, TypeOfClass> typesOfClass = new HashMap<TypeOfClass.type, TypeOfClass>();
	
	public void addTypeOfClass(TypeOfClass.type type, TypeOfClass typeOfClass) {
		this.typesOfClass.put(type, typeOfClass);
	}
	
	public Map<TypeOfClass.type, TypeOfClass> getTypesOfClass() {
		return typesOfClass;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
