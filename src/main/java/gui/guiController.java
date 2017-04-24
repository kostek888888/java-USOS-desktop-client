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



    
    @FXML
    void loginButtonClick(MouseEvent event) {
    	if("login".equals(loginTextField.getText())     &&    "haslo".equals(passTextField.getText()) )
    	{
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Success Login");

    		alert.showAndWait();
    	}
    	else
    	{
    		Alert alert = new Alert(AlertType.WARNING);
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("Wrong Login or Password");

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
    		    		alert.setTitle("Information Dialog");
    		    		alert.setHeaderText(null);
    		    		alert.setContentText("Success Login");
    		    		alert.showAndWait();
    		    	}
    		    	else
    		    		{
	    		    		Alert alert = new Alert(AlertType.WARNING);
	    		    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    		    		stage.getIcons().add(new Image(("file:@../../icon/favicon-0.png")));
	    		    		alert.setTitle("Information Dialog");
	    		    		alert.setHeaderText(null);
	    		    		alert.setContentText("Wrong Login or Password");
	
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
    	stage.setTitle("USOS MENAGER LOGIN");

    }
    
    

    @FXML
    void selectPolish(MouseEvent event) {
    	loginLabel.setText("Login");
    	passwordLabel.setText("Has³o");
    	loginButton.setText("Zaloguj siê");
    	passwordLabel.setLayoutX(70.0);   ///Polskie "Has³o" jest krótsze niz angielskie Password i trzeba przesun¹æ
    	
    	Stage stage = (Stage) anchorPane.getScene().getWindow();
    	stage.setTitle("USOS MENAD¯ER LOGOWANIE");

    }
	
    ///ustawienie kursora na dlon gdy wejdzie na obszar flagi
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
