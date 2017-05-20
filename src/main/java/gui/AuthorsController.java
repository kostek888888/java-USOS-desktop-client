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
import usos.UsosManager;


public class AuthorsController {

    @FXML
    private AnchorPane anchorPane;

        
    @FXML
    private Label authorsLabel;
    
    @FXML
    private Label usosLabel;

    @FXML
    private Hyperlink fominikGit;

    @FXML
    private Hyperlink wojtekGit;

    @FXML
    private Hyperlink michalGit;

    @FXML
    private Hyperlink tomekGit;

    @FXML
    private Hyperlink projectGit;
    
   
    
    ///fakeInit odpala po kliknieciu na link projektu
    ///@todo
    void fakeInit(){
    	getUsosStage().setPlLanguage();
    	resetLanguage();
    	///tu niech ustawi jezyk na taki jaki byl wybrany w oknie logowania
    }
	
    
    
    
    private UsosStage getUsosStage() {
    	//FUSZERKA !!! @todo
    	return  (UsosStage) anchorPane.getScene().getWindow();
    }
    
    private UsosManager getUsosManager() {
    	//FUSZERKA !!! @todo
        return getUsosStage().getUsosManager();
    }

    

    void resetLanguage() {
    	authorsLabel.setText(getUsosStage().getMsg("authors.titleOnSceneLabel"));
    	usosLabel.setText(getUsosStage().getMsg("authors.titleOnSceneLabel"));
    	getUsosStage().setTitle(getUsosStage().getMsg("authors.title"));
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
       	 
       	 
       	 
       	 ///fake init usunac @todo
       	 fakeInit();
       	 
       	 
       	 
       	} catch(BindException e){
       		 e.printStackTrace(System.out);
       	}
    }
}
