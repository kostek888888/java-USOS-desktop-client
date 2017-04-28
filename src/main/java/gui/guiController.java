package gui;

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
   	
   	
   	
   	private String language = "english";
   	
   	public void setLanguage(String language)
   	{
   		this.language=language;
   	}
   	
   	public String getLanguage()
   	{
   		return language;
   	}



    
    @FXML
    void loginButtonClick(MouseEvent event) {
    	if("login".equals(loginTextField.getText())     &&    "haslo".equals(passTextField.getText()) )
    	{
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setHeaderText(null);
    		
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
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.WARNING);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setHeaderText(null);
    		
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
    	}  	
    }
    
    
    @FXML
    void enterPressed(KeyEvent key)
    {
    		  if (key.getCode().equals(KeyCode.ENTER))
              {
    			  if("login".equals(loginTextField.getText())     &&    "haslo".equals(passTextField.getText()) )
    		    	{
    		    		
    		    		Alert alert = new Alert(AlertType.INFORMATION);
    		    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		    		alert.setHeaderText(null);
    		    		
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
    		    	}
    		    	else
    		    	{
    		    		Alert alert = new Alert(AlertType.WARNING);
    		    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		    		alert.setHeaderText(null);
    		    		
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
 
    	Stage stage = (Stage) anchorPane.getScene().getWindow();
    	stage.setTitle("USOS MENAGER");
    	setLanguage("english");

    }
    
    

    @FXML
    void selectPolish(MouseEvent event) {
    	loginLabel.setText("Login");
    	passwordLabel.setText("Hasło");
    	loginButton.setText("Zaloguj się");
    	passwordLabel.setLayoutX(70.0);   ///Polskie "Has�o" jest kr�tsze niz angielskie Password i trzeba przesun��
    	
    	Stage stage = (Stage) anchorPane.getScene().getWindow();
    	stage.setTitle("USOS MENADŻER");
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

}
