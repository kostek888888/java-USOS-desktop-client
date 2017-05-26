package gui;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import usos.UsosManager;

public class UsosStage extends Stage {

	private ResourceBundle messages;
	
	public String getMsg(String msg) {
		return messages.getString(msg);
	}


	UsosStage() {
		setPlLanguage();

	}
	
	public void setDefLanguage() {
	    Locale defaultLocale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
	    messages = ResourceBundle.getBundle("MessagesBundle", defaultLocale);
	    
	    //jesli ktos ma np ustawiony niemiecki (a nie mamy po niemiecku) to ustawi mu angielski
	    if(defaultLocale.getLanguage()!="pl" && defaultLocale.getLanguage()!="en")
	    {
	    	setEnLanguage();
	    }

	    
	}
	
	public void setEnLanguage() {
        Locale currentLocale = new Locale("en", "US");
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}
	
	public void setPlLanguage() {
		Locale currentLocale = new Locale("pl", "PL");
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
	}

	private UsosManager usosManager;
	
	 
	
	public void setUsosManager(UsosManager usosManager) {
		this.usosManager = usosManager;
	}


	public UsosManager getUsosManager() {
		return usosManager;
	}
	
	
}
