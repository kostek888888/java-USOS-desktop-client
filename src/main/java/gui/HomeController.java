package gui;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class HomeController {
	
	private String language;

    protected String getLanguage() {
		return language;
	}


	protected void setLanguage(String language) {
		this.language = language;
	}

    @FXML
    private AnchorPane anchorPane;
    
    
    HomeController(String language)
    {
    	setLanguage(language);
    	System.out.println("Jezyk home = " + getLanguage());
    }  

}


	

	





