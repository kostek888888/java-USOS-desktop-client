package gui;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class TableRow {
	private final StringProperty subject;
    private final StringProperty type;
    private final StringProperty marks;


    
    /**
     * Default constructor.
     */
    public TableRow() {
        this(null, null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public TableRow(String subject, String type, String marks) {
        this.subject = new SimpleStringProperty(subject);
        this.type = new SimpleStringProperty(type);
        this.marks = new SimpleStringProperty(marks);
    }
    
    public String getSubject()
    {
    	return subject.get(); 
    }
    
    public void setSubject(String subject){
    	this.subject.set(subject);
    }
    
    public StringProperty subjectProperty(){
    	return subject;
    }
    
    
    public String getType()
    {
    	return type.get(); 
    }
    
    public void setType(String type){
    	this.type.set(type);
    }
    
    public StringProperty typeProperty(){
    	return type;
    }
    
    
    
    public String getMarks()
    {
    	return marks.get(); 
    }
    
    public void setMarks(String marks){
    	this.marks.set(marks);
    }
    
    public StringProperty marksProperty(){
    	return marks;
    }
}
