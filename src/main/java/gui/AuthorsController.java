package gui;


import java.awt.Desktop;
import java.io.IOException;
import java.net.BindException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import usos.LoginInvalidCredentialsException;

public class AuthorsController {

    @FXML
    private AnchorPane anchorPane;

    
    
    @FXML
    private Label authorsLabel;

    @FXML
    private Hyperlink fominikGit;

    @FXML
    private Hyperlink wojtekGit;

    @FXML
    private Hyperlink michalGit;

    @FXML
    private Hyperlink tomekGit;

    @FXML
    private Label usosLabel;

    @FXML
    private Hyperlink projectGit;
    
	private String language = "english";

	public final String getLanguage() {
		return language;
	}

	protected final void setLanguage(String language) {
		this.language = language;
	}



	


    
    @FXML
    void wojtekGitClick(MouseEvent event) throws IOException, URISyntaxException {
    	try{
       	 Desktop d=Desktop.getDesktop();
       	 d.browse(new URI("https://github.com/wojtek9502"));
       	} catch(BindException e){
       		 e.printStackTrace(System.out);
       	}
    }
    

    @FXML
    void DominikGitClick(MouseEvent event) throws IOException, URISyntaxException  {

    	try{
    	 Desktop d=Desktop.getDesktop();
    	 d.browse(new URI("https://github.com/TheMrDraven"));
    	} catch(BindException e){
    		 e.printStackTrace(System.out);
    	}
    }

    @FXML
    void MichalGitClick(MouseEvent event) throws IOException, URISyntaxException {

    	try{
       	 Desktop d=Desktop.getDesktop();
       	 d.browse(new URI("https://github.com/kostek888888"));
       	} catch(BindException e){
       		 e.printStackTrace(System.out);
       	}
    }
    
    @FXML
    void tomekGitClick(MouseEvent event) throws IOException, URISyntaxException {
    	try{
       	 Desktop d=Desktop.getDesktop();
       	 d.browse(new URI("https://github.com/tomaszkowalczyk94"));
       	} catch(BindException e){
       		 e.printStackTrace(System.out);
       	}
    }

    @FXML
    void projectGitClick(MouseEvent event) throws IOException, URISyntaxException {
    	
    	try{
       	 Desktop d=Desktop.getDesktop();
       	 d.browse(new URI("https://github.com/kostek888888/java-USOS-desktop-client/")); 	
       	} catch(BindException e){
       		 e.printStackTrace(System.out);
       	}
    }





}
