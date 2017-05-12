package gui;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import usos.LoginInvalidCredentialsException;
import usos.LogoutException;
import usos.UsosManager;


public class guiController {

    @FXML
    private ImageView imageEnglishLanguage;
    
    @FXML
    private ImageView imagePolishLanguage;
    
	
    @FXML
    private Label loginLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button loginButton;
    
    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passTextField;
    
   	@FXML
	private AnchorPane anchorPane;
   	
    @FXML
    private Button authorsButton;
   	
   	
   	
   	private String language = "english";

	public final String getLanguage() {
		return language;
	}

	protected final void setLanguage(String language) {
		this.language = language;
	}

	
	

   
    @FXML
    private void loginButtonClick(MouseEvent event) throws IOException, SQLException, LogoutException  {

		
    	///tworzenie obiektow dla okienka dialogowego
    	Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
		alert.setHeaderText(null);
		
		UsosManager usosManager = new UsosManager();
		usosManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");    ///tryb testowy
		
		try {
			usosManager.login(loginTextField.getText(),passTextField.getText());    ///haslo musi byc qwerty
    		if(getLanguage()=="english")
    		{
        		alert.setTitle("Information");
        		alert.setContentText("Success Login");
    		}
    		if(getLanguage()=="polish")
    		{
        		alert.setTitle("Informacja");
        		alert.setContentText("Udane Logowanie");
    		}
    		alert.showAndWait();
    	
    		usosManager.checkChangesInMarks();
    		
			
			
			
		} catch (LoginInvalidCredentialsException e) {
			if(getLanguage()=="english")
    		{
        		alert.setTitle("Warning");
        		alert.setContentText("Wrong login or password");
    		}
    		if(getLanguage()=="polish")
    		{
        		alert.setTitle("Uwaga");
        		alert.setContentText("Żły login lub hasło");
    		}
    		alert.showAndWait();
      		
		} finally {
			usosManager.logout();
		}
		
		
		/*
		///przejscie do okna Home
    	Home home = new Home();
		Stage s = new Stage();
		home.start(s);
		
		///zamkniecie ona logowania
		Stage loginStage = (Stage) loginButton.getScene().getWindow();
	    loginStage.close();
		*/
    }
    
    
    @FXML
   private void enterPressed(KeyEvent key) throws IOException, SQLException, LogoutException
    {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
		alert.setHeaderText(null);
    		  if (key.getCode().equals(KeyCode.ENTER))
              { 				
    			  	UsosManager usosManager = new UsosManager();
    			  	usosManager.turnOnTestMode("http://31.178.72.165:8080/javaUSOSpskMock");   ///tryb testowy
    				try {
    					usosManager.login(loginTextField.getText(),passTextField.getText());    ///haslo musi byc qwerty

    		    		if(getLanguage()=="english")
    		    		{
    		        		alert.setTitle("Information");
    		        		alert.setContentText("Success Login");
    		    		}
    		    		if(getLanguage()=="polish")
    		    		{
    		        		alert.setTitle("Informacja");
    		        		alert.setContentText("Udane Logowanie");
    		    		}
    		    		alert.showAndWait();
    					
    					
    					usosManager.checkChangesInMarks();
    				} catch (LoginInvalidCredentialsException e) {

    					if(getLanguage()=="english")
    		    		{
    		        		alert.setTitle("Warning");
    		        		alert.setContentText("Wrong login or password");
    		    		}
    		    		if(getLanguage()=="polish")
    		    		{
    		        		alert.setTitle("Uwaga");
    		        		alert.setContentText("Żły login lub hasło");
    		    		}

    		    		alert.showAndWait();
    		    		
    				} finally {
    					usosManager.logout();
    				}
              }
    }
    
    
    
    @FXML
    void selectEnglish(MouseEvent event) {
    	imageEnglishLanguage.setDisable(false);
    	loginLabel.setText("Login");
    	passwordLabel.setText("Password");
    	loginButton.setText("Sign In");
    	passwordLabel.setLayoutX(50.0);
    	authorsButton.setText("Authors");
 
    	Stage stage = (Stage) anchorPane.getScene().getWindow();
    	stage.setTitle("USOS MENAGER Login");
    	setLanguage("english");

    }
    
    

    @FXML
    void selectPolish(MouseEvent event) {
    	loginLabel.setText("Login");
    	passwordLabel.setText("Hasło");
    	loginButton.setText("Zaloguj się");
    	passwordLabel.setLayoutX(70.0);   ///Polskie "Has�o" jest kr�tsze niz angielskie Password i trzeba przesun��
    	authorsButton.setText("Autorzy");
    	
    	Stage stage = (Stage) anchorPane.getScene().getWindow();
    	stage.setTitle("USOS MENADŻER Logowanie");
    	setLanguage("polish");

    }
	
    ///ustawienie kursora na dlon gdy wejdzie na obszar flag
    @FXML
    void changeCursor(MouseEvent event) {
    	imageEnglishLanguage.getScene().getRoot().setCursor(Cursor.HAND);
    	
    }
    
    ///powrot do standardowego kursora gdy opusci obszar flag
    @FXML
    void backCursor(MouseEvent event) {
    	imageEnglishLanguage.getScene().getRoot().setCursor(Cursor.DEFAULT);
    }
    
    


    @FXML
    void authorsButtonClick(MouseEvent event) {
    	Authors authors = new Authors();
		Stage s = new Stage();
		authors.start(s);
    }

}