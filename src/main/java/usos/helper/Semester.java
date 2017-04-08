package usos.helper;

import java.util.ArrayList;
import java.util.List;

public class Semester {
	
	private List<Subject> subjects = new ArrayList<Subject>();
	private String name;
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
